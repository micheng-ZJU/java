package Parser;
import java.io.*;
import java.text.DecimalFormat;

public abstract class LogParser {	
	
	public String logFileName;	
	public abstract String generateResultFileName();
	
	public LogParser(String logFileName){
		this.logFileName = logFileName;
	}
	
	public void fileProcess(String resultFileName, String [] keywords, String[] actions){		
		try{
			BufferedReader br = new BufferedReader(new FileReader("./log/"+logFileName));			
			BufferedWriter bw = new BufferedWriter(new FileWriter("./result/"+resultFileName+".txt"));
			
			analyze(br, bw, keywords, actions);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void analyze(BufferedReader br, BufferedWriter bw, String[] keywords, String[] actions) throws IOException{
		String line;
		int count = 0, i = 0;
		String time;
		double start = 0, end = 0, elapse_time = 0;
		DecimalFormat df = new DecimalFormat("#0.000");
		
		
		while((line = br.readLine())!=null && count<keywords.length){
			if(line.contains(keywords[count])){
				// Skip the first 3 entries because it is not included in automation. 
				// The logs are generated when building the app.
				if(i<3){
					i++; continue;
				}
					
				String s = line.split("Z]")[0];
				time = s.substring(12, s.length());
			
				
				// find end point
				if(line.contains(keywords[count]+"Response")){
					System.out.println("end of action:" + line);
					end = (Double.parseDouble(time.substring(0,2))*60 + Double.parseDouble(time.substring(3,5)))*60+Double.parseDouble(time.substring(6,time.length()));
					elapse_time = end - start;
					bw.write(actions[count]+": \t"+df.format(elapse_time));
					bw.newLine();
					count ++;
				}
				// find start point
				else if((line.contains("U"+keywords[count])&&count!=1)||(line.contains(keywords[count])&&count==1)){
					System.out.println("start of action:" + line);
					start = (Double.parseDouble(time.substring(0,2))*60 + Double.parseDouble(time.substring(3,5)))*60+Double.parseDouble(time.substring(6,time.length()));
				}
			}			
		}
		
		bw.close();
	};

}

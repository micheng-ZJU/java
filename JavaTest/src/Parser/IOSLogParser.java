package Parser;

public class IOSLogParser extends LogParser {


	public IOSLogParser(String logFileName) {
		super(logFileName);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String generateResultFileName() {
		// TODO Auto-generated method stub
		String resultFileName = logFileName.substring(logFileName.length()-23, logFileName.length()-6);
		return resultFileName;
	}

}

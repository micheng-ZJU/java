package Parser;

public class AndroidLogParser extends LogParser {

	
	public AndroidLogParser(String logFileName) {
		super(logFileName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateResultFileName() {
		// TODO Auto-generated method stub
		return "AndroidResult";
	}


}

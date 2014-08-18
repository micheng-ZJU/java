import Parser.AndroidLogParser;
import Parser.IOSLogParser;
import Parser.LogParser;

// Author: Cheng, Ming
// 2014-07

public class JavaMain {

	// Specify your platform here
	static String platform = "iOS";
	
	static String [] keywords_android = {
		"RecoveryBadges",
		"ValidateBadge",
		"GetFavoriteKey",
		"ActivateKey",
		"GetKey",
		"VerifyQRCode",
		"VerifyUsherCode",
		"SendRecoveryLink"
	};
	
	static String[] keywords_ios = {
		"RecoveryBadges",
		"UValidateBadge",
		"GetFavoriteKey",
		"ActivateKey",
		"GetKey",
		"VerifyQRCode",
		"VerifyUsherCode",
		"SendRecoveryLink"
	};
	static String [] actions = {
		"Recover 11 badges",
		"Login to MSTR by recovery",
		"Get favorit keys",
		"Open a door",
		"Get all keys",
		"Validate with QR code",
		"Validate with Usher code",
		"Send recovery link"
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String resultFileName;
		if(platform.matches("Android")){
			// Specify your android log file here
			LogParser lp = new AndroidLogParser("LocalLogFile.log");
			resultFileName = lp.generateResultFileName();
			lp.fileProcess(resultFileName, keywords_android, actions);
		}
		else {
			// Specify your ios log file here
			LogParser lp = new IOSLogParser("Cong’s iPhone_2014-07-18 085109 +0000");
			resultFileName = lp.generateResultFileName();
			lp.fileProcess(resultFileName, keywords_ios, actions);
		}

	}

}

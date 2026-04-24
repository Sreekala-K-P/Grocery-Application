package constant;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties";   //url path
	
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\MainData.xlsx";  //excel path
	
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	
	public static final String INVALIDCREDENTIALERROR="User is able to login with invalid credentials";
	
	public static final String VALIDUSERINVALIDPWDERROR="User is able to login with invalid password";
	
	public static final String INVALIDUSERVALIDPWDERROR="User is able to login with invalid username";
	
	public static final String LOGGEDOUTERROR="User is unable to logout";
	
	public static final String NEWADMINUSERERROR="Unable to add new admin user";
	
	public static final String SEARCHNEWADMINUSERERROR="User is unable to search the newly added user";
	
	public static final String EDITMANAGECONTACTERROR="Contact information is not updated";
	
	public static final String ADDNEWNEWSERROR="User is unable to add new news";
	
	public static final String SEARCHNEWNEWS="User is unable to get newly added news";
}

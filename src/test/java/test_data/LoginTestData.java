package test_data;


public class LoginTestData {

    private static final String valid_username = "TechGlobal";
    private static final String valid_password = "Test1234";
    private static final String valid_email = "johndoe@gmail.com";
    private static final String invalid_username = "john";
    private static final String invalid_password = "1234";


    public static String getValidUsername(){
        return valid_username;
    }
    public static String getValidPassword(){return valid_password;}
    public static String getValidEmail(){return valid_email;}
    public static String getInvalidUsername(){return invalid_username;}
    public static String getInvalidPassword(){return invalid_password;}
}

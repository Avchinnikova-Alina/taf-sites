package by.itacademy.avchinnikova.alina.taf.sites;

public class Util {
    public static String generateСorrectEmail(int numberOfChars) {
        String[] email = {"a", "b", "c", "d"};
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * email.length);
            result = result.concat(email[j]);
        }
        return(result + "@gmail.com");
    }
    public static String generateIncorrectEmail(int numberOfChars) {
        String[] email = {"a", "b", "c", "d"};
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * email.length);
            result = result.concat(email[j]);
        }
        return(result);
    }
    public static String generatePassword(int numberOfChars) {
        String[] password = {"a", "b", "c", "d","r"};
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * password.length);
            result = result.concat(password[j]);
        }
        return(result);
    }
}

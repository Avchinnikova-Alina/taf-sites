package by.itacademy.avchinnikova.alina.taf.sites.utils;

public class Util {
    public static String generateIncorrectEmail(int numberOfChars) {
        String[] email = {"a", "b", "c", "d"};
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int) Math.floor(Math.random() * email.length);
            result = result.concat(email[j]);
        }
        return (result);
    }
}
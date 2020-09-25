package utils;

public class CommonMethods {
    public static int randomNumber(int start, int end) {
        return (int) ((Math.random() * (end - start)) + start);
    }
}

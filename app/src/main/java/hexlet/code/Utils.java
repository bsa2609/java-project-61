package hexlet.code;

public class Utils {
    public static int getRandomInt(int minValue, int maxValue) {
        return (int) (Math.round(Math.random() * (maxValue - minValue)) + minValue);
    }
}

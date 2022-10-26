package domain;

public class Numbers {
    private final String[] stringNumbers;

    private Numbers(String[] split) {
        this.stringNumbers = split;
    }

    public static Numbers of(String[] split) {
        return new Numbers(split);
    }

    public int size() {
        return stringNumbers.length;
    }

    public int sum() {
        int sum = 0;
        for (String stringNum : stringNumbers) {
            sum += Integer.parseInt(stringNum);
        }
        return sum;
    }
}

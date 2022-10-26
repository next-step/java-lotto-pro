package domain;

public class Numbers {
    private String[] stringNumbers;

    private Numbers(String[] split) {
        this.stringNumbers = split;
    }

    public static Numbers of(String[] split) {
        return new Numbers(split);
    }

    public int size(){
        return stringNumbers.length;
    }
}

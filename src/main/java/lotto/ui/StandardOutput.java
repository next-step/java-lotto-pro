package lotto.ui;

public class StandardOutput implements Output {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printMessage(String message, Object... args) {
        System.out.printf(message, args);
        System.out.println();
    }
}

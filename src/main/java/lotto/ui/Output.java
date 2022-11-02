package lotto.ui;

public interface Output {
    void printMessage(String message);
    void printMessage(String message, Object... args);
}

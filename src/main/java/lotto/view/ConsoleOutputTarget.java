package lotto.view;

public class ConsoleOutputTarget implements OutputTarget {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}

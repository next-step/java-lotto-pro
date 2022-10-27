package lotto.ui;

public class StandardOutput implements Output {


    @Override
    public void print(String text) {
        System.out.println(text);
    }
}

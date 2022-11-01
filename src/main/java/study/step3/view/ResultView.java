package study.step3.view;

public class ResultView {

    public static void output(StringBuilder value) {
        output(value.toString());
    }

    public static void output(String value) {
        System.out.println(value);
    }

    public static void newline() {
        System.out.println();
    }
}

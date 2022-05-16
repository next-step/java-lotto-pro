package study.step3;

import study.step3.io.ConsolePrinter;

public class Application {
    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain(new ConsolePrinter());
        lottoMain.start();
    }
}

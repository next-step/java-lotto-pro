package study.lotto;

import study.lotto.io.ConsolePrinter;

public class Application {
    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain(new ConsolePrinter());
        lottoMain.start();
    }
}

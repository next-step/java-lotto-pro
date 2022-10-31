package lotto;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static lotto.LottoPrinter.newLine;
import static lotto.LottoPrinter.print;
import static lotto.LottoScanner.scanWinningNumbers;
import static lotto.LottoScanner.scanPayAmount;

public class LottoApp implements App {

    private static final String WELCOME = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private App lottoStaticApp;

    public void run() throws IOException {
        LottoStore lottoStore = new LottoStore();

        print(WELCOME);
        
        List<Lotto> lottoList = lottoStore.pay(new PayAmount(scanPayAmount()));
        print(String.format(BUY_LOTTO, lottoList.size()));

        for (Lotto lotto : lottoList) {
            print(lotto.toString());
        }

        newLine();
        
        print(WINNING_NUMBER);
        Lotto winLotto = Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(scanWinningNumbers())));
    }


    public static void main(String[] args) throws IOException {
        new LottoApp().run();
    }
}

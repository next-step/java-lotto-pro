package lotto;


import java.io.IOException;
import java.util.Arrays;

import static lotto.LottoPrinter.newLine;
import static lotto.LottoPrinter.print;
import static lotto.LottoScanner.*;

public class LottoApp implements App {

    private static final String WELCOME = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String BUY_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String BUY_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    public void run() throws IOException {
        LottoStore lottoStore = new LottoStore();

        print(WELCOME);
        int payAmount = scanOneNumber();

        newLine();

        LottoBuyer lottoBuyer = new LottoBuyer(new PayAmount(payAmount));

        print(BUY_MANUAL_COUNT);
        int buyManualCount = scanOneNumber();

        newLine();

        print(BUY_MANUAL_NUMBER);
        for (int i = 0; i < buyManualCount; i++) {
            lottoBuyer.buyWithManual(lottoStore, Arrays.asList(scanManyNumbers()));
        }

        lottoBuyer.buyWithRandom(lottoStore);

        newLine();

        print(String.format(BUY_LOTTO, lottoBuyer.getManualLottoCount(), lottoBuyer.getRandomLottoCount()));
        print(lottoBuyer.toString());

        print(WINNING_NUMBER);
        Lotto winLotto = Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(scanManyNumbers())));

        print(BONUS_NUMBER);
        BonusLottoNumber bonusLottoNumber = BonusLottoNumber.valueOf(scanOneNumber(), winLotto);

        newLine();

        App lottoStaticApp = LottoStaticApp.builder()
            .lottoList(lottoBuyer.reportLottoList())
            .winLotto(winLotto)
            .bonusLottoNumber(bonusLottoNumber)
            .payAmount(new PayAmount(payAmount))
            .build();

        lottoStaticApp.run();
    }


    public static void main(String[] args) throws IOException {
        new LottoApp().run();
    }
}

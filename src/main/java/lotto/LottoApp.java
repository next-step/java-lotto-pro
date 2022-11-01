package lotto;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static lotto.LottoPrinter.newLine;
import static lotto.LottoPrinter.print;
import static lotto.LottoScanner.*;

public class LottoApp implements App {

    private static final String WELCOME = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String BONUS_BALL_DUPLICATION = "중복된 번호를 보너스볼로 입력하셨습니다.";

    public void run() throws IOException {
        LottoStore lottoStore = new LottoStore();

        print(WELCOME);
        int payAmount = scanOneNumber();

        List<Lotto> lottoList = lottoStore.pay(new PayAmount(payAmount));
        print(String.format(BUY_LOTTO, lottoList.size()));

        for (Lotto lotto : lottoList) {
            print(lotto.toString());
        }

        newLine();
        
        print(WINNING_NUMBER);
        Lotto winLotto = Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(scanWinningNumbers())));

        print(BONUS_NUMBER);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(scanOneNumber());

        if (winLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(BONUS_BALL_DUPLICATION);
        }

        newLine();

        App lottoStaticApp = LottoStaticApp.builder()
            .lottoList(lottoList)
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

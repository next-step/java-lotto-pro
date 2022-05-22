package step3.lotto.view.reader;

import static step3.lotto.domain.lotto.Lotto.LOTTO_NUMBER_COUNT;
import static step3.lotto.utils.LottoNumberUtils.intArrayToList;
import static step3.lotto.view.InputView.printInputBonusNumberGuideMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.LottoNumber;
import step3.lotto.domain.lotto.Winnings;
import step3.lotto.view.InputView;

/**
 * @author : choi-ys
 * @date : 2022/05/17 3:34 오후
 */
public class InputReader {

    public static final String WINNING_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputPrice() throws IOException {
        InputView.printInputPriceGuideMessage();
        return Integer.parseInt(br.readLine());
    }

    public static Winnings inputWinnings() throws IOException {
        Lotto winningsLotto = inputLastWinningsLotto();
        LottoNumber bonusNumber = inputBonusNumber();
        return Winnings.of(winningsLotto, bonusNumber);
    }

    private static LottoNumber inputBonusNumber() throws IOException {
        printInputBonusNumberGuideMessage();
        return LottoNumber.of(Integer.parseInt(br.readLine()));
    }

    public static Lotto inputLastWinningsLotto() throws IOException {
        InputView.printInputLastWinningLottoGuideMessage();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[LOTTO_NUMBER_COUNT];
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            arr[i] = Integer.parseInt(st.nextToken(WINNING_LOTTO_NUMBERS_DELIMITER));
        }
        return Lotto.of(intArrayToList(arr));
    }
}

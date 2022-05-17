package step3.lotto.view.reader;

import static step3.lotto.domain.lotto.Lotto.LOTTO_NUMBER_COUNT;
import static step3.lotto.utils.LottoNumberUtils.intArrayToList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.view.InputView;

/**
 * @author : choi-ys
 * @date : 2022/05/17 3:34 오후
 */
public class InputReader {

    public static final String WINNING_LOTTO_NUMBERS_DELIMITER = ", ";
    private BufferedReader br;

    public int inputPrice() throws IOException {
        InputView.printInputPriceGuideMessage();
        br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public Lotto inputLastWinningLotto() throws IOException {
        InputView.printInputLastWinningLottoGuideMessage();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[LOTTO_NUMBER_COUNT];
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            arr[i] = Integer.parseInt(st.nextToken(WINNING_LOTTO_NUMBERS_DELIMITER));
        }
        return Lotto.of(intArrayToList(arr));
    }
}

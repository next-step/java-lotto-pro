package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String BLANK = " ";
    private static final String INPUT_BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto inputWinnerNumber() {
        System.out.println(INPUT_WINNER_NUMBER_MESSAGE);
        return getLotto();
    }

    private static Lotto getLotto() {
        String stringNumbers = scanner.nextLine();
        String removeBlankStringNumbers = stringNumbers.replace(BLANK, "");
        String[] split = removeBlankStringNumbers.split(DELIMITER);

        List<LottoNumber> winnerLottoNumbers = new ArrayList<>();
        for (String stringNumber : split) {
            int number = Integer.parseInt(stringNumber);
            winnerLottoNumbers.add(new LottoNumber(number));
        }
        return new Lotto(winnerLottoNumbers);
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        int number = Integer.parseInt(scanner.nextLine());
        return new LottoNumber(number);
    }

    public static int inputManualQuantity() {
        System.out.println(INPUT_MANUAL_LOTTO);
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lottos inputManualLotto(int manualCount) {
        System.out.println(INPUT_MANUAL_LOTTOS);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            lottoList.add(getLotto());
        }
        return new Lottos(lottoList);
    }
}

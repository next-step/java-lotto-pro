package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.utils.StringParser;

import static lotto.constants.LottoGameErrorMessage.INVALID_BONUS_LOTTO_NUMBER;
import static lotto.constants.LottoGameMessage.*;

import java.util.*;

public class InputView {
    private InputView() {}

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println(WAIT_FOR_USER_MONEY_INPUT);
        return scanner.nextLine();
    }

    public static String inputLatestLottoResult() {
        System.out.println(WAIT_FOR_LATEST_LOTTO_RESULT_INPUT);
        return scanner.nextLine();
    }

    public static LottoNumber inputBonusLottoNumber(LottoNumbers lastWinningLottoNumbers) {
        System.out.println(WAIT_FOR_BONUS_LOTTO_NUMBER_INPUT);
        LottoNumber receivedBonusLottoNumber = new LottoNumber(StringParser.parseAsInteger(scanner.nextLine()));

        if (!isValidBonusBall(lastWinningLottoNumbers, receivedBonusLottoNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_LOTTO_NUMBER);
        }

        return receivedBonusLottoNumber;
    }

    private static boolean isValidBonusBall(LottoNumbers lastWinningLottoNumbers, LottoNumber bonusBall) {
        return !lastWinningLottoNumbers.contains(bonusBall);
    }
}

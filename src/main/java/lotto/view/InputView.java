package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.utils.StringParser;
import lotto.utils.StringUtil;

import static lotto.constants.LottoGameErrorMessage.INVALID_BONUS_LOTTO_NUMBER;
import static lotto.constants.LottoGameErrorMessage.INVALID_MANUAL_LOTTO_PURCHASE_COUNT;
import static lotto.constants.LottoGameMessage.*;

import java.util.*;

public class InputView {
    private InputView() {}

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println(WAIT_FOR_USER_MONEY_INPUT);
        return scanner.nextLine();
    }

    public static LottoCount inputManualLottoPurchaseCount(LottoCount availablePurchaseLottoCount) {
        System.out.println(WAIT_FOR_MANUAL_LOTTO_PURCHASE_COUNT_INPUT);
        String manualLottoPurchaseCount = scanner.nextLine();

        if (isValidManualLottoPurchaseCount(manualLottoPurchaseCount, availablePurchaseLottoCount)) {
            return LottoCount.from(StringParser.parseAsInteger(manualLottoPurchaseCount));
        }

        System.out.println(INVALID_MANUAL_LOTTO_PURCHASE_COUNT);

        return inputManualLottoPurchaseCount(availablePurchaseLottoCount);
    }

    private static boolean isValidManualLottoPurchaseCount(String manualLottoPurchaseCount,
                                                    LottoCount availablePurchaseLottoCount) {
        return StringParser.parseAsInteger(manualLottoPurchaseCount) <= availablePurchaseLottoCount.getCount();
    }

    public static String inputLatestLottoResult() {
        System.out.println(WAIT_FOR_LATEST_LOTTO_RESULT_INPUT);
        return scanner.nextLine();
    }

    public static List<String> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println(WAIT_FOR_MANUAL_LOTTO_NUMBERS_INPUT);

        List<String> manualLottoStrings = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoStrings.add(scanner.nextLine());
            System.out.println();
        }

        return manualLottoStrings;
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
        return lastWinningLottoNumbers.notContains(bonusBall);
    }
}

package nextstep.lotto.io;

import nextstep.lotto.domain.BonusBall;
import nextstep.lotto.domain.Lotto;
import nextstep.lotto.domain.LottoCount;
import nextstep.lotto.domain.LottoNumber;
import nextstep.lotto.domain.LottoNumbers;
import nextstep.lotto.domain.MatchCount;
import nextstep.lotto.domain.MatchCountCollection;
import nextstep.lotto.domain.PurchaseLotto;
import nextstep.lotto.domain.PurchaseLottoAmount;
import nextstep.lotto.domain.WinningLotto;
import nextstep.lotto.exception.LottoRuntimeException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static nextstep.lotto.constance.LottoConstance.LOTTO_PRICE;
import static nextstep.lotto.constance.LottoDisplayMessage.BONUS_BALL_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.DIVIDE_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.INPUT_MANUAL_PURCHASE_LOTTO_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.LAST_WEEK_LOTTO_WIN_NUMBERS_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.LOSS_STAT_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.MANUAL_PURCHASE_AMOUNT_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_POSTFIX_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.PROFIT_STAT_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_AMOUNT_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_LOTTO_VIEW_MIDDLE;
import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_LOTTO_VIEW_POSTFIX;
import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_LOTTO_VIEW_PREFIX;
import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_PREFIX_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.WINNING_STAT_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.WINNING_STAT_RESULT_POSTFIX_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.WINNING_STAT_RESULT_PREFIX_MESSAGE;


public class LottoDisplay {

    public static final String ERROR = "[ERROR]";
    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입 금액은 숫자만 입력이 가능합니다.";
    public static final String INVALID_WINNING_LOTTO_NUMBER_MESSAGE = "당첨 번호는 숫자만 입력이 가능합니다.";
    public static final String INVALID_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 개수가 구입 금액을 초과하였습니다.";


    private static final Scanner scanner = new Scanner(System.in);

    public static PurchaseLottoAmount inputPurchaseAmount() {

        System.out.println(PURCHASE_AMOUNT_MESSAGE);

        try {
            String inputPurchaseAmount = scanner.nextLine();
            Long purchaseAmount = Long.valueOf(inputPurchaseAmount);
            Long manualPurchaseCount = inputManualPurchaseCount(purchaseAmount);
            return new PurchaseLottoAmount(purchaseAmount, manualPurchaseCount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR + INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE);
            return inputPurchaseAmount();
        }
    }

    public static Long inputManualPurchaseCount(Long purchaseAmount) {

        System.out.println(MANUAL_PURCHASE_AMOUNT_MESSAGE);

        try {
            String inputManualPurchaseCount = scanner.nextLine();
            Long manualPurchaseCount = Long.valueOf(inputManualPurchaseCount);
            validateUpperThanAmount(purchaseAmount, manualPurchaseCount);
            return manualPurchaseCount;
        } catch (NumberFormatException e) {
            System.out.println(ERROR + INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE);
            return inputManualPurchaseCount(purchaseAmount);
        }
    }

    public static void validateUpperThanAmount(Long purchaseAmount, Long manualPurchaseCount) {
        if (purchaseAmount < manualPurchaseCount * LOTTO_PRICE) {
            throw new LottoRuntimeException(INVALID_MANUAL_LOTTO_COUNT_MESSAGE);
        }
    }

    public static Lotto inputManualPurchaseLotto(Boolean showMessage) {

        if (showMessage) {
            System.out.println("");
            System.out.println(INPUT_MANUAL_PURCHASE_LOTTO_MESSAGE);
        }

        try {
            String inputManualPurchaseLotto = scanner.nextLine();
            List<LottoNumber> manualPurchaseLottoNumbers = Arrays.stream(StringUtils.split(inputManualPurchaseLotto, PURCHASE_LOTTO_VIEW_MIDDLE))
                    .map(i -> new LottoNumber(Integer.parseInt(i)))
                    .collect(Collectors.toList());

            return new Lotto(new LottoNumbers(manualPurchaseLottoNumbers));

        } catch (NumberFormatException e) {
            System.out.println(ERROR + INVALID_WINNING_LOTTO_NUMBER_MESSAGE);
            return inputManualPurchaseLotto(Boolean.TRUE);
        } catch (LottoRuntimeException e) {
            System.out.println(ERROR + e.getMessage());
            return inputManualPurchaseLotto(Boolean.TRUE);
        }
    }

    public static void printLottoCountResult(LottoCount lottoCount) {
        System.out.println(String.format(PURCHASE_PREFIX_MESSAGE, lottoCount.getManualLottoCount(), lottoCount.getAutoLottoCount()));
    }

    public static void printAutoLottoResult(PurchaseLotto purchaseLotto) {

        for (Lotto lotto : purchaseLotto) {
            List<LottoNumber> lottoNumbers = lotto.getLottoNumbers().getLottoNumbers();
            System.out.println(PURCHASE_LOTTO_VIEW_PREFIX + StringUtils.join(lottoNumbers, PURCHASE_LOTTO_VIEW_MIDDLE) + PURCHASE_LOTTO_VIEW_POSTFIX);
        }
        System.out.println();
    }

    public static WinningLotto inputLastWeekWinningLotto() {

        System.out.println(LAST_WEEK_LOTTO_WIN_NUMBERS_MESSAGE);

        try {
            String inputLottoNumber = scanner.nextLine();
            List<LottoNumber> winningLottoNumbers = Arrays.stream(StringUtils.split(inputLottoNumber, PURCHASE_LOTTO_VIEW_MIDDLE))
                    .map(i -> new LottoNumber(Integer.parseInt(i)))
                    .collect(Collectors.toList());

            Lotto winningLotto = new Lotto(new LottoNumbers(winningLottoNumbers));
            BonusBall bonusBall = inputBonusBallLotto(winningLotto);

            return new WinningLotto(winningLotto, bonusBall);

        } catch (NumberFormatException e) {
            System.out.println(ERROR + INVALID_WINNING_LOTTO_NUMBER_MESSAGE);
            return inputLastWeekWinningLotto();
        } catch (LottoRuntimeException e) {
            System.out.println(ERROR + e.getMessage());
            return inputLastWeekWinningLotto();
        }
    }

    public static BonusBall inputBonusBallLotto(Lotto winningLotto) {

        System.out.println(BONUS_BALL_MESSAGE);

        try {
            String inputBonusBall = scanner.nextLine();
            LottoNumber bonusBallNumber = new LottoNumber(Integer.parseInt(inputBonusBall));
            return new BonusBall(bonusBallNumber, winningLotto);
        } catch (NumberFormatException e) {
            System.out.println(ERROR + INVALID_WINNING_LOTTO_NUMBER_MESSAGE);
            return inputBonusBallLotto(winningLotto);
        } catch (LottoRuntimeException e) {
            System.out.println(ERROR + e.getMessage());
            return inputBonusBallLotto(winningLotto);
        }
    }

    public static void printWinningStatMessage(MatchCountCollection matchCountCollection) {

        System.out.println(WINNING_STAT_MESSAGE);
        System.out.println(DIVIDE_MESSAGE);
        for (MatchCount matchCount : matchCountCollection) {
            System.out.print(matchCount.getLottoWinningPrice());
            System.out.print(matchCount);
            System.out.println(MATCH_COUNT_POSTFIX_MESSAGE);
        }
    }

    public static void printReturnRate(BigDecimal rate) {

        System.out.print(WINNING_STAT_RESULT_PREFIX_MESSAGE + rate + WINNING_STAT_RESULT_POSTFIX_MESSAGE);
        if (rate.compareTo(new BigDecimal(1)) > 0) {
            System.out.println(PROFIT_STAT_MESSAGE);
            return;
        }

        System.out.println(LOSS_STAT_MESSAGE);
    }
}

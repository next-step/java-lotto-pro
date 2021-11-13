package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    public static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final int MINUS_COUNT = 1;
    public static final String EMPTY_MESSAGE = "";
    public static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String NUMBERS_PATTERN_EXCEPTION_MESSAGE = "입력 형식이 잘못되었습니다. 처음부터 다시 입력해주세요. (예시: 1, 2, 3, 4, 5, 6)";
    private final Scanner scanner = new Scanner(System.in);

    private final LottoShop lottoShop = new LottoShop();

    public Money getPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        String input = scanner.nextLine();
        try {
            Money money = new Money(Integer.parseInt(input));
            LottoShop.validatePurchaseAmount(money);
            return money;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다. (입력값: " + input + ")");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(EMPTY_MESSAGE);
        return getPurchaseMoney();
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = scanner.nextLine();
        try {
            List<Integer> intNumbers = StringUtils.convertIntegerList(input);
            List<Number> numbers = convertIntsToNumbers(intNumbers);
            return new WinningNumbers(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(EMPTY_MESSAGE);
        }
        return getWinningNumbers();
    }

    public Number getBonusNumber(WinningNumbers winningNumbers) {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        String input = scanner.nextLine();
        try {
            Number bonusNumber = new Number(Integer.parseInt(input));
            validateContainsNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(EMPTY_MESSAGE);
        }
        return getBonusNumber(winningNumbers);
    }

    public PurchaseCounts getPurchaseCounts(Money money) {
        System.out.println(EMPTY_MESSAGE);
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        String input = scanner.nextLine();
        try {
            PurchaseCount manualPurchaseCount = new PurchaseCount(Integer.parseInt(input));
            return lottoShop.countPurchasableLotto(money, manualPurchaseCount);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다. (입력값: " + input + ")");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getPurchaseCounts(money);
    }

    public List<List<Integer>> getManualNumbers(PurchaseCount manualPurchaseCount) {
        if (manualPurchaseCount.isZero()) {
            return new ArrayList<>();
        }

        System.out.println(EMPTY_MESSAGE);
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
        final PurchaseCount initPurchaseCount = new PurchaseCount(manualPurchaseCount.getCount());
        List<List<Integer>> numbers = new ArrayList<>();
        while (manualPurchaseCount.isGreaterThanZero()) {
            String input = scanner.nextLine();
            try {
                numbers.add(StringUtils.convertIntegerList(input));
                manualPurchaseCount = manualPurchaseCount.minus(MINUS_COUNT);
            } catch (Exception e) {
                System.out.println(NUMBERS_PATTERN_EXCEPTION_MESSAGE);
                return getManualNumbers(initPurchaseCount);
            }
        }
        return numbers;
    }

    private List<Number> convertIntsToNumbers(List<Integer> intNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (int number : intNumbers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }

    private void validateContainsNumber(WinningNumbers winningNumbers, Number bonusNumber) {
        if (winningNumbers.isContains(bonusNumber)) {
            throw new IllegalArgumentException("지난주 당첨 번호와 중복된 숫자가 입력되었습니다. (입력값: " + bonusNumber.getNumber() + ")");
        }
    }
}
package camp.nextstep.edu.view;

import camp.nextstep.edu.common.PositiveNumber;
import camp.nextstep.edu.level1.lotto.lotto.Lotto;
import camp.nextstep.edu.level1.lotto.lotto.LottoNumber;
import camp.nextstep.edu.level1.lotto.lotto.LottoNumbers;
import camp.nextstep.edu.level1.lotto.lotto.LottoResult;
import camp.nextstep.edu.level1.stringCaluator.calculator.StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {
    private static final String PREFIX_ERROR_MESSAGE = "[ERROR]";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static StringCalculator enterCalculateValue() {
        System.out.println("양수를 구분자와 함께 입력해 주세요.");
        System.out.println("기본 구분자는 :, 입니다.");
        System.out.println("//로 시작된 문자를 입력하 후 계산할 값을 입력하면, // 뒤의 문자로 구분하여 계산합니다.");

        StringBuilder sb = new StringBuilder();
        sb.append(scanner.nextLine());

        if (sb.toString().startsWith("//")) {
            sb.append("\n");
            sb.append(scanner.nextLine());
        }

        return new StringCalculator(sb.toString());
    }

    public static Lotto enterLottoValue() {
        System.out.println("구입금액을 입력해 주세요.");
        Lotto lotto = untilEnterValidValue(() -> new Lotto(scanner.nextLine()));
        lotto.printPurchaseLottoNumbers();;
        System.out.println();

        return lotto;
    }

    public static LottoResult enterLottoWinningNumbers(Lotto lotto) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        PositiveNumber manualPurchaseCount = untilEnterValidValue(() -> {
            PositiveNumber inputNumber = new PositiveNumber(scanner.nextLine());
            lotto.checkPossibleManualLottoPurchaseCount(inputNumber);

            return inputNumber;
        });

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        List<LottoNumbers> manualPurchaseLottoNumbers = new ArrayList<>();
        for (int index = 0; index < manualPurchaseCount.getValue(); index++) {
            manualPurchaseLottoNumbers.add(
                    untilEnterValidValue(() -> new LottoNumbers(scanner.nextLine()))
            );
        }

        lotto.manualLottoPurchase(manualPurchaseLottoNumbers);
        lotto.printPurchaseResult();
        lotto.printPurchaseLottoNumbers();

        return untilEnterValidValue(() -> {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            LottoNumbers enteredWinningNumbers = untilEnterValidValue(() -> new LottoNumbers(scanner.nextLine()));

            System.out.println("보너스 볼을 입력해 주세요.");
            LottoNumber enteredBonusNumber = untilEnterValidValue(() -> new LottoNumber(scanner.nextLine()));

            return lotto.compareWinningNumber(enteredWinningNumbers, enteredBonusNumber);
        });
    }

    private static <T> T untilEnterValidValue(Supplier<T> action) {
        boolean isSuccessInput = false;
        T result = null;

        while (!isSuccessInput) {
            try {
                result = action.get();
                isSuccessInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR_MESSAGE + " " + e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }

        return result;
    }
}

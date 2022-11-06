package lotto.view;

import lotto.LottoBag;
import lotto.NumberBag;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static void printNumbers(LottoBag lottoBag) {
        printNumbers(lottoBag.getLottoNumbers());
    }

    public static void inputMoney() {
        System.out.println("구매 금액을 입력해 주세요.");
    }

    public static void inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void inputManualNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printManualAutoCount(long manualCount, long autoCount) {
        System.out.println("수동으로" + manualCount + "장, " + "자동으로 " + autoCount + "장 구매했습니다.");
    }

    public static void inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    private static void printNumbers(List<NumberBag> lottoNumbers) {
        for (NumberBag numbers : lottoNumbers) {
            StringBuilder builder = new StringBuilder();
            builder.append("[")
                    .append(numbers.getNumbers().stream()
                            .map(it -> String.valueOf(it.getIntNumber()))
                            .collect(Collectors.joining(", ")))
                    .append("]");
            System.out.println(builder);
        }
    }
}

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

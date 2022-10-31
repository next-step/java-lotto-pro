package lotto.view;

import lotto.LottoBag;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static void printNumbers(LottoBag lottoBag) {
        printNumbers(lottoBag.getLottoNumbers());
    }

    private static void printNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            StringBuilder builder = new StringBuilder();
            builder.append("[")
                    .append(numbers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")))
                    .append("]");
            System.out.println(builder);
        }
    }
}

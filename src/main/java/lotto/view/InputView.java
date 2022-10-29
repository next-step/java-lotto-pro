package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static void printNumbers(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .append("]");
        System.out.println(builder);
    }
}

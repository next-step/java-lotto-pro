package step3.domain;

import step3.enums.Rule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoFactory {

    private static final List<Integer> RANGE = Stream
            .iterate(0, i -> i + 1)
            .limit(Rule.TOTAL_END_NUMBER.getRange())
            .collect(Collectors.toList());

    public static LottoNumbers getRandomSixNumbers() {
        Collections.shuffle(RANGE);
        return new LottoNumbers(RANGE.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    public static List<LottoNumber> split(String numbersWithComma) {
        return Arrays.stream(numbersWithComma.replace(" ", "").split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

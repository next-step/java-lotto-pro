package lotto.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.LottoLine;
import lotto.exception.LottoStringFormatException;

public class LottoStringGenerator {

    private static final String SPACE = " ";
    private static final String NON_SPACE = "";
    private static final String SEPARATOR = ",";

    private LottoStringGenerator(){}

    public static LottoLine toLottoLine(String lottoLine) {
        try {
            return new LottoLine(Arrays.stream(lottoLine.replace(SPACE, NON_SPACE)
                .split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new LottoStringFormatException();
        }
    }

}

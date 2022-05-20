package lotto;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class LottoNumbersMapper {
    private static final String SPLITTER = ",";

    private LottoNumbersMapper() {
    }

    public static List<LottoNumber> mapToLottoNumbers(final String winningNumber) {
        return stream(winningNumber.trim().split(SPLITTER))
                .map(numberString -> LottoNumber.valueOf(numberString.trim()))
                .collect(Collectors.toList());
    }
}

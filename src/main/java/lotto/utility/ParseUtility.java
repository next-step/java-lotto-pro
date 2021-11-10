package lotto.utility;

import lotto.domain.WinningLottoNumbers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParseUtility {
    public static final String SPLIT_DELIMITER = ",";

    public static WinningLottoNumbers StringToWinningNumbers(String inputWinningNumber, int bonusNumber) {
        return new WinningLottoNumbers(Arrays.stream(inputWinningNumber
                        .split(SPLIT_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()), bonusNumber);
    }
}

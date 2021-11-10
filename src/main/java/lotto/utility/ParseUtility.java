package lotto.utility;

import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParseUtility {
    public static final String SPLIT_DELIMITER = ",";

    public static LottoTicket StringToLottoTicket(String inputWinningNumber, int bonusNumber) {
        return new LottoTicket(Arrays.stream(inputWinningNumber
                        .split(SPLIT_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()), bonusNumber);
    }
}

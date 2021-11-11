package lotto.utility;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoNumbers;
import lotto.exception.NotANumberException;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class ParseUtility {
    public static final String SPLIT_DELIMITER = ",";

    public static WinningLottoNumbers StringToWinningNumbers(String inputWinningNumber, String bonusNumber) {
        try {
            return new WinningLottoNumbers(Arrays.stream(inputWinningNumber
                    .split(SPLIT_DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()), Integer.parseInt(bonusNumber));
        } catch (InputMismatchException | NumberFormatException e) {
            throw new NotANumberException();
        }

    }

    public static LottoTicket StringToLottoTicket(String inputWinningNumber) {
        try {
            return new LottoTicket(Arrays.stream(inputWinningNumber
                    .split(SPLIT_DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        } catch (InputMismatchException | NumberFormatException e) {
            throw new NotANumberException();
        }
    }
}

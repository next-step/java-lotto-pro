package step3.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import step3.common.exception.InvalidParamException;
import step3.dto.WinnerLottoNumbersDto;

public class InputView {
    private static final String ONLY_NUMBER = "숫자만 입력 해주세요.";

    private static final Scanner sc = new Scanner(System.in);
    private final ResultView resultView = new ResultView();

    public int[] readLineToArray() {
        return Stream.of(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public int readOnlyNumber() {
        try {
            return sc.nextInt();
        } catch (InvalidParamException invalidParamException) {
            resultView.println(ONLY_NUMBER);
            return readOnlyNumber();
        }
    }

    public WinnerLottoNumbersDto getWinnerLottoNumberDto() {
        try {
            return new WinnerLottoNumbersDto(readLineToArray());
        } catch (InvalidParamException invalidParamException) {
            resultView.println(invalidParamException.getMessage());
            return getWinnerLottoNumberDto();
        }
    }
}

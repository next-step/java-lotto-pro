package step3.view;

import java.util.Scanner;
import java.util.stream.Stream;

import step3.common.exception.InvalidParamException;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoWinNumbersRequestDto;

public class InputView {
    private static final String ONLY_NUMBER = "숫자만 입력 해주세요.";

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int readOnlyNumber() {
        try {
            return sc.nextInt();
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(ONLY_NUMBER);
            return readOnlyNumber();
        }
    }

    public static int[] readLineToArray() {
        return Stream.of(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static LottoBuyRequestDto readLottoRequestDto() {
        ResultView.amountRequestPrintln();
        LottoBuyRequestDto lottoRequestDto = new LottoBuyRequestDto();
        lottoRequestDto.mapAmount(readOnlyNumber());
        return lottoRequestDto;
    }

    public static LottoWinNumbersRequestDto readLottoWinnerRequestDto(int amount) {
        ResultView.winnerRequestPrintln();
        try {
            return new LottoWinNumbersRequestDto(readLineToArray(), amount);
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return readLottoWinnerRequestDto(amount);
        }
    }
}

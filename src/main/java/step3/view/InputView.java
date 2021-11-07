package step3.view;

import java.util.Scanner;
import java.util.stream.Stream;

import step3.common.exception.InvalidParamException;
import step3.dto.LottoBonusNumberRequestDto;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoWinNumbersRequestDto;

public class InputView {
    private static final String ONLY_NUMBER = "숫자만 입력 해주세요.";

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int readOnlyNumber() {
        try {
            return Integer.parseInt(getIntScanner());
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return readOnlyNumber();
        }
    }

    public static int[] readLineToArray() {
        return Stream.of(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static LottoBuyRequestDto readLottoRequestDto() {
        try {
            ResultView.amountRequestPrintln();

            return new LottoBuyRequestDto(readOnlyNumber());
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return readLottoRequestDto();
        }
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

    public static LottoBonusNumberRequestDto readLottoBonusNumberRequestDto() {
        ResultView.bonusNumberRequestPrintln();
        try {
            return new LottoBonusNumberRequestDto(readOnlyNumber());
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return readLottoBonusNumberRequestDto();
        }
    }

    private static String getIntScanner() {
        String result = sc.next();
        if (!result.chars().allMatch(Character::isDigit)) {
            throw new InvalidParamException(ONLY_NUMBER);
        }
        return result;
    }
}

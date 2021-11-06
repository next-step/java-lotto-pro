package lotto.view;

import lotto.domain.LottoProperty;
import lotto.exception.ErrorMessage;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinningNumberView {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    private LottoWinningNumberView() {
    }

    public static List<Integer> input() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        String winnerNumber = scanner.nextLine();
        List<String> trimWinningNumbers = Stream.of(winnerNumber.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        winnerNumberSizeValid(trimWinningNumbers);
        winnerNumberRangeValid(trimWinningNumbers);

        return trimWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void winnerNumberRangeValid(List<String> winnerNumbers) {
        for (String winnerNumber : winnerNumbers) {
            int number = Integer.parseInt(winnerNumber);
            if (number < LottoProperty.LOTTO_START_NUMBER && number > LottoProperty.LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    //TODO : 질문4
    private static void winnerNumberSizeValid(List<String> winnerNumbers) {
        if (winnerNumbers.size() != LottoProperty.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_WINNING_NUMBER_COUNT.getMessage());
        }
    }
}

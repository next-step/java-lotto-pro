package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinningNumberView {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    private LottoWinningNumberView() {
    }

    public static Lotto input() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        String winnerNumber = Console.nextLine();

        return Stream.of(winnerNumber.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}

package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class InputView {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String WINNING_NUMBER_SPLIT_REGEX = ",";

    private static final String INPUT_BOUNS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        return scanner.nextLine();
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE);

        return createWinningLotto(scanner.nextLine());
    }

    public static LottoNumber inputBounsBall() {
        System.out.println(INPUT_BOUNS_BALL_MESSAGE);

        return LottoNumber.from(scanner.nextInt());
    }

    private static Lotto createWinningLotto(String winnignNumber) {
        List<Integer> winningNumbers = Arrays.asList(winnignNumber.replaceAll("\\s", "").split(WINNING_NUMBER_SPLIT_REGEX))
            .stream()
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

        return Lotto.from(winningNumbers);
    }
}

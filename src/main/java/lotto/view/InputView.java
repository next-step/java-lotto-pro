package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class InputView {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";

    private static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";

    private static final String INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String WINNING_NUMBER_SPLIT_REGEX = ",";

    private static final String INPUT_BOUNS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final int MANUAL_LOTTO_ZERO = 0;

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        return scanner.nextLine();
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Lotto> inputManualLottoNumber(int manualLottoCount) {
        if(manualLottoCount > MANUAL_LOTTO_ZERO) {
            System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
        }
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(createLotto(scanner.nextLine()));
        }
        return manualLottos;
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE);

        return createLotto(scanner.nextLine());
    }

    public static LottoNumber inputBounsBall() {
        System.out.println(INPUT_BOUNS_BALL_MESSAGE);

        return LottoNumber.from(scanner.nextInt());
    }

    private static Lotto createLotto(String lottoNumber) {
        List<Integer> winningNumbers = Arrays.asList(lottoNumber.replaceAll("\\s", "").split(WINNING_NUMBER_SPLIT_REGEX))
            .stream()
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

        return Lotto.from(winningNumbers);
    }
}

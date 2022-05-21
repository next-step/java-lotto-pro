package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BUY_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static String getBuyPrice() {
        System.out.println(INPUT_BUY_PRICE_MESSAGE);
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String getWinningNumbers() {
        System.out.println(INPUT_WINNING_MESSAGE);
        return scanner.nextLine();
    }

    public static Lottos getManualLottoNumbers() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String lottoCount = scanner.nextLine();
        return getLottos(lottoCount);
    }

    private static Lottos getLottos(String lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0, count = Integer.parseInt(lottoCount); i < count; i++) {
            manualLottos.add(LottoFactory.create(scanner.nextLine()));
        }
        return new Lottos(manualLottos);
    }
}

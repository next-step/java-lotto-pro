package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static int insertMoney() {
        OutputView.print("구입금액을 입력해 주세요.");
        return nextInt();
    }

    public static int insertManualLottoCount() {
        OutputView.print("수동으로 구매할 로또 수를 입력해 주세요");
        return nextInt();
    }

    public static List<Lotto> insertManualLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        OutputView.print("수동으로 구매할 번호를 입력해 주세요.");
        for(int i=0; i<count; i++) {
            lottos.add(new Lotto(inputLotto()));
        }

        return lottos;
    }

    public static List<LottoNumber> insertWinningLotto() {
        OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
        return inputLotto();
    }

    public static List<LottoNumber> inputLotto() {
        return Arrays.stream(scanner.next().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber insertBonusBall() {
        OutputView.print("보너스 볼을 입력해 주세요.");
        return new LottoNumber(nextInt());
    }
}

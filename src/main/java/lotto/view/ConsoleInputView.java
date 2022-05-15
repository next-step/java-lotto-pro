package lotto.view;

import lotto.lotto.*;
import lotto.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ConsoleInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Money readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.of(scanner.nextLine());
    }

    @Override
    public ManualLottoes readManualLottoes() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final int countOfPurchases = Integer.parseInt(scanner.nextLine());
        return generateLottoes(countOfPurchases);
    }

    private ManualLottoes generateLottoes(int countOfPurchases) {
        final List<String> lottoes = new ArrayList<>(countOfPurchases);
        for (int i = 0; i < countOfPurchases; i++) {
            lottoes.add(scanner.nextLine());
        }
        return ManualLottoes.of(lottoes);
    }

    @Override
    public WinningLotto readPreviousWinningLotto() {
        return WinningLotto.of(readLotto(), readBonusLottoNumber());
    }

    private Lotto readLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return generateLotto(scanner.nextLine());
    }

    private static Lotto generateLotto(String maybeLottoNumbers) {
        return LottoGenerator.commaSplitting(maybeLottoNumbers)
                             .generate();
    }

    private LottoNumber readBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(scanner.nextLine());
    }
}

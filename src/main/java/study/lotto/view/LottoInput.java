package study.lotto.view;

import study.lotto.domain.WinningLotto;
import study.lotto.domain.order.UserOrder;
import study.util.NumberUtil;

import java.util.Scanner;
import java.util.stream.IntStream;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public UserOrder inputUserPurchase() {
        return new UserOrder(scanner.nextLine());
    }

    public int inputManualQuantity(UserOrder userOrder) {
        return userOrder.checkManualQuantity(NumberUtil.convertToPositiveInt(scanner.nextLine()));
    }

    public void inputManualLottos(int quantity, UserOrder userOrder) {
        IntStream.range(NumberUtil.INIT_ZERO, quantity).forEach((i) -> {
            userOrder.createManualOrder(scanner.nextLine());
        });
    }

    public WinningLotto inputWinningNumbers() {
        return new WinningLotto(scanner.nextLine());
    }

    public void inputBonusBall(WinningLotto winningLotto) {
        winningLotto.addBonusBall(scanner.nextInt());
    }
}

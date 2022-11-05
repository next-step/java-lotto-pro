package lotto.ui;

import static java.lang.Long.parseLong;

import java.util.List;
import java.util.Scanner;
import lotto.ui.dto.BoughtLotto;
import lotto.ui.dto.BuyLottoInput;
import lotto.ui.dto.BuyLottoOutput;

public class BuyLottoView {
    private static final Scanner scanner = new Scanner(System.in);

    public static BuyLottoInput buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        final long amount = readAmount();
        return new BuyLottoInput(amount);
    }

    private static long readAmount() {
        try {
            return readPositiveLong();
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력해 주세요.");
            return readAmount();
        }
    }

    private static long readPositiveLong() {
        final String nextLine = scanner.nextLine();

        final long amount = parseLong(nextLine);

        if (amount < 0) {
            System.out.println("양수를 입력해 주세요.");
            return readPositiveLong();
        }

        return amount;
    }

    public static void printLottos(final BuyLottoOutput output) {
        final List<BoughtLotto> boughtLottos = output.getBoughtLottos();
        printLottos(boughtLottos);
        System.out.println();
    }

    private static void printLottos(List<BoughtLotto> boughtLottos) {
        System.out.println(boughtLottos.size() + "개를 구매했습니다.");
        for (BoughtLotto lotto : boughtLottos) {
            System.out.println(lotto);
        }
    }
}

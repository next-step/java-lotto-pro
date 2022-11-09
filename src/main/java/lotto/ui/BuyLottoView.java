package lotto.ui;

import static java.lang.Long.parseLong;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.ui.dto.BoughtLotto;
import lotto.ui.dto.BuyLottoInput;
import lotto.ui.dto.BuyLottoOutput;

public class BuyLottoView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LottoNumberReader lottoNumberReader = new LottoNumberReader(scanner);

    public static BuyLottoInput buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        final long amount = readAmount();

        final List<List<Integer>> playerPicks = readPlayerPicks();

        return new BuyLottoInput(amount, playerPicks);
    }

    private static List<List<Integer>> readPlayerPicks() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final long pickCount = readAmount();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(BuyLottoView::readPlayerPick)
                .limit(pickCount)
                .collect(Collectors.toList());
    }

    private static List<Integer> readPlayerPick() {
        return lottoNumberReader.readLottoNumbers();
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
        printPickCount(output.getPlayerPickCount(), output.getQuickPickCount());
        printLottos(output.getBoughtLottos());
        System.out.println();
    }

    private static void printPickCount(final int playerPickCount, final int quickPickCount) {
        System.out.println("수동으로 " + playerPickCount + "장, 자동으로 " + quickPickCount + "장을 구매했습니다.");
    }

    private static void printLottos(List<BoughtLotto> boughtLottos) {
        for (BoughtLotto lotto : boughtLottos) {
            System.out.println(lotto);
        }
    }
}

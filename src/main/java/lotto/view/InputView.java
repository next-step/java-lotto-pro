package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.Lottos;
import lotto.model.WinTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getBuyMoney() {
        showEnterBuyMoneyMessage();
        return getInteger();
    }

    public void showEnterBuyMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoBoughtMessage(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        final List<LottoTicket> lottoList = lottos.getLottos();
        lottoList.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public WinTicket getWinLottoTicket() {
        showEnterWinNumbersMessage();
        final List<Integer> winNumbers = getWinNumbers();
        showEnterBonusNumbersMessage();
        final int bonusNumber = getBonusNumber();
        return WinTicket.of(winNumbers, bonusNumber);
    }

    private void showEnterWinNumbersMessage() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
    }

    private List<Integer> getWinNumbers() {
        final String input = scanner.nextLine();
        final String[] inputs = input.split(",");
        return Arrays.stream(inputs)
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void showEnterBonusNumbersMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    private int getBonusNumber() {
        return getInteger();
    }

    private int getInteger() {
        final int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }
}

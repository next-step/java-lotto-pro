package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static final String ENTER_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_TEXT = "%d개를 구매했습니다.";
    private static Scanner scanner = new Scanner(System.in);

    public static int enterMoney() {
        System.out.println(ENTER_MONEY_TEXT);
        return scanner.nextInt();
    }

    public static void outputBoughtLotto(int boughtCount) {
        System.out.printf(BUY_LOTTO_TEXT, boughtCount);
    }

    public static void outputLottoTicket(LottoTicket lottoTicket) {
        List<LottoNumbers> ticket = lottoTicket.getTicket();
        ticket.stream().forEach(System.out::println);
    }
}

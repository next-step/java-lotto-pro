package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static final String ENTER_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static int enterMoney() {
        System.out.println(ENTER_MONEY_TEXT);
        return scanner.nextInt();
    }

    public static void outputBoughtLotto(int boughtCount) {
        System.out.println(boughtCount + "개를 구매했습니다.");
    }

    public static void outputLottoTicket(LottoTicket lottoTicket) {
        List<LottoNumbers> ticket = lottoTicket.getTicket();
        ticket.stream().forEach(System.out::println);
    }
}

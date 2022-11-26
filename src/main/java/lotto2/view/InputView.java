package lotto2.view;

import lotto2.model.*;

import java.util.Scanner;

public class InputView {
    public MoneyToBuy inputMoney() {
        System.out.print("구입금액을 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return new MoneyToBuy(input);
    }

    public String inputWinningNumbers() {
        System.out.print("지난 주 당첨 번호를 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public LottoNumber inputBonusNumber() {
        System.out.print("보너스 볼을 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return new LottoNumber(input);
    }
}

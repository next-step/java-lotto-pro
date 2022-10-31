package lotto.auto.ui;

import lotto.auto.Lotto;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public InputView() {
        System.out.println("구입금액을 입력해주세요");
    }

    public String getInputString() {
        return consoleInput();
    }

    public String getInputWinningNubers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return consoleInput();
    }

    public String consoleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto eachLotto : lottoList) {
            System.out.println(eachLotto.toString());
        }
    }
}

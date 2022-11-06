package lotto.ui;

import lotto.common.LottoAutoUtils;

import java.util.Scanner;

public class InputView {
    public InputView() {
        System.out.println("구입금액을 입력해주세요");
    }

    public String getInputString() {
        return consoleInput();
    }

    public String getInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return consoleInput();
    }

    public String getInputBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return consoleInput();
    }


    public String consoleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getDirectInputLottoNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int cnt = new LottoAutoUtils().stringToNumber(consoleInput());
        String directInputLottoNumbers = "";
        for (int i = 1; i < cnt; i++) {
            directInputLottoNumbers += consoleInput() + "\n";
        }
        ;
        return directInputLottoNumbers += consoleInput();
    }
}

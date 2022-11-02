package step3.view;

import step3.view.input.InputAmount;
import step3.view.input.InputBonusLottoNumber;
import step3.view.input.InputWinningLottoNumbers;

public class InputView {

    public static Integer inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InputAmount().create();
    }

    public static String inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new InputWinningLottoNumbers().create();
    }

    public static Integer inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new InputBonusLottoNumber().create();
    }
}

package step3.view;

import step3.view.input.*;

import java.util.List;

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

    public static Integer inputManualLottoQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new InputManualLottoQuantity().create();
    }

    public static void printManualLottoQuantity() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<Integer> inputManualLottoNumbers() {
        return new InputManualLottoNumbers().create();
    }
}

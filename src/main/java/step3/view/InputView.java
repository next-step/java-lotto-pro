package step3.view;

import step3.view.input.*;

import java.util.List;

import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;

public class InputView {

    public static Integer inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InputAmount().create()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage()));
    }

    public static String inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new InputWinningLottoNumbers().create()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage()));
    }

    public static Integer inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new InputBonusLottoNumber().create()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage()));
    }

    public static Integer inputManualLottoQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new InputManualLottoQuantity().create()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage()));
    }

    public static List<Integer> inputManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return new InputManualLottoNumbers().create()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage()));
    }
}

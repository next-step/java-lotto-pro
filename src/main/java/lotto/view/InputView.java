package lotto.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import lotto.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoUtil;
import lotto.strategy.ManualPickNumberStrategy;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int[] enterManualLotto() {
        while (true) {
            try {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                int[] intArray = LottoUtil.convertLottoStringToIntArray(enterString().split(","));
                return intArray;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningLotto enterWinningLotto() {
        while (true) {
            try {
                int[] lottoNumber = enterManualLotto();
                List<LottoNumber> lottoNumbers = LottoUtil.convertToLottoNumber(lottoNumber);
                Lotto lotto = new Lotto(new ManualPickNumberStrategy(lottoNumbers));
                LottoNumber bonusLottoNumber = new LottoNumber(enterBonusNumber());
                WinningLotto winningLotto = new WinningLotto(lotto, bonusLottoNumber);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String enterString() {
        return SCANNER.next();
    }

    public static int enterBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return enterNumber();
    }


    public static int enterPurchaseAmount() throws InputMismatchException {
        System.out.println("구입금액을 입력해주세요");
        return enterNumber();
    }

    private static int enterNumber() throws InputMismatchException {
        while (true) {
            try {
                int number = SCANNER.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하였습니다");
                SCANNER.next();
            }
        }
    }
}

package lotto.view;

import lotto.domain.LottoNumber;
import lotto.exception.BonusNumberWrongFormatException;

public class LottoWinningBonusNumberView {

    private LottoWinningBonusNumberView() {
    }

    public static LottoNumber input() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = Console.nextLine();

        return new LottoNumber(numberValid(bonusNumber));

    }

    private static int numberValid(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e) {
            throw new BonusNumberWrongFormatException(e);
        }
    }
}

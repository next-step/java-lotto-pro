package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String MESSAGE_GET_USER_MONEY = "구입 금액을 입력해 주세요.";
    public static final String MESSAGE_GET_WINNING_LOTTO = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String WINNING_LOTTO_DELIMITER = ", ";
    public static final String MESSAGE_GET_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static Money getUserMoney() {
        System.out.println(MESSAGE_GET_USER_MONEY);
        return new Money(Integer.parseInt(Console.readLine()));
    }

    public static WinningLotto getWinningLotto() {
        Lotto winningLotto = getWinningLottoFromUser();
        LottoNumber bonusNumber = getBonusNumber();

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static Lotto getWinningLottoFromUser() {
        System.out.println(MESSAGE_GET_WINNING_LOTTO);

        String input = Console.readLine();
        String[] splitInput = input.split(WINNING_LOTTO_DELIMITER);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String s : splitInput) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(s)));
        }

        return new Lotto(lottoNumbers);
    }

    private static LottoNumber getBonusNumber() {
        System.out.println(MESSAGE_GET_BONUS_NUMBER);

        String input = Console.readLine();

        return new LottoNumber(Integer.parseInt(input));
    }
}

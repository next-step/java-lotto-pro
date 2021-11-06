package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static Money getUserMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return new Money(Integer.parseInt(Console.readLine()));
    }

    public static Lotto getWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        String input = Console.readLine();
        String[] splitInput = input.split(", ");

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String s : splitInput) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(s)));
        }

        return new Lotto(lottoNumbers);
    }
}

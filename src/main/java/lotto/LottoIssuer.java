package lotto;

import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoIssuer {
    public static final Money LOTTO_PRICE = new Money(1000);

    public static List<Lotto> issue(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        while (money.isEqualsOrGreater(LOTTO_PRICE)) {
            money.minus(LOTTO_PRICE);
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public static void result(List<Lotto> lottoList, List<Integer> winningNumbers) {
        WinningResultBag results = new WinningResultBag(lottoList.stream()
                .map(lotto -> lotto.getResult(winningNumbers))
                .collect(Collectors.toList()));
        ResultView.printResult(results);
    }
}

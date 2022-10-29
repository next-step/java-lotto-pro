package lotto;

import lotto.domain.buyer.LottoBuyer;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.dto.LottoBill;
import lotto.dto.StatisticResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    public void start() {
        int amount = InputView.inputMoney();

        LottoBuyer lottoBuyer = new LottoBuyer(new Money(amount));
        LottoBill lottoBill = lottoBuyer.buyLotto(new LottoSeller());

        OutputView.printLottoCount(lottoBill.getLottoPiece());
        OutputView.printLottos(lottoBill.toString());

        String[] numbers = InputView.inputWinLottoNumber();
        Lotto winLotto = createWinnerLotto(numbers);

        StatisticResult statisticResult = lottoBuyer.calculateYieldStatistic(winLotto);
        OutputView.printStatistic(statisticResult.toString());
    }

    private Lotto createWinnerLotto(String[] lottoNumber) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumber)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);

    }

}

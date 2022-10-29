package lotto;

import lotto.domain.buyer.LottoBuyer;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.prize.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {

    public void start() {
        int amount = InputView.inputMoney();

        LottoBuyer lottoBuyer = new LottoBuyer(new Money(amount));
        Lottos lottos = lottoBuyer.buyLotto(new LottoSeller());

        OutputView.printLottoCount(lottos.getLottoCount());
        OutputView.printLottos(lottos.toString());

        String[] numbers = InputView.inputWinLottoNumber();
        Lotto winLotto = createWinnerLotto(numbers);

        Map<Prize, Integer> prizes = lottos.getPrizeOfLotto(winLotto);
        BigDecimal bigDecimal = lottoBuyer.calculateYield(prizes, lottos.getLottoCount());
        OutputView.printStatistic(prizes, bigDecimal);
    }

    private Lotto createWinnerLotto(String[] lottoNumber) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumber)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);

    }

}

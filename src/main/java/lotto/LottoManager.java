package lotto;

import lotto.domain.buyer.LottoBuyer;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinnerLotto;
import lotto.domain.money.Money;
import lotto.prize.Prizes;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    public void start() {
        int amount = InputView.inputMoney();

        LottoBuyer lottoBuyer = new LottoBuyer(new Money(amount));
        int manualQuantity = InputView.inputManualLottoQuantity();
        List<String> maunalNumbers = InputView.inputManualLottoNumbers(manualQuantity);
        Lottos buyLottos = lottoBuyer.buyAutoAndManualLotto(maunalNumbers);

        OutputView.printLottoCount(buyLottos.getLottoCount(), manualQuantity);
        OutputView.printLottos(buyLottos.toString());

        Lotto winnerLotto = new WinnerLotto(createWinnerLotto(InputView.inputWinLottoNumber()),
                new LottoNumber(InputView.inputBonusNumber()));

        Prizes prizes = buyLottos.getPrizeOfLotto(winnerLotto);
        BigDecimal bigDecimal = lottoBuyer.calculateYield(prizes, buyLottos.getLottoCount());
        OutputView.printStatistic(prizes, bigDecimal);
    }

    private List<LottoNumber> createWinnerLotto(String[] lottoNumber) {
        return Arrays.stream(lottoNumber)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

    }

}

package lotto.game;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lotto.dto.LottoGameResultDTO;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinLottoNumbers;
import lotto.rank.LottoRank;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private final LottoNumbersFactory lottoNumbersFactory;
    private final InputView inputView;
    private final ResultView resultView;
    private int budget;

    public LottoGame(LottoNumbersFactory lottoNumbersFactory, InputView inputView, ResultView resultView) {
        this.lottoNumbersFactory = lottoNumbersFactory;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        budget = inputView.takeBudget();
        List<LottoNumbers> lottoNumbersList = buyLotto();
        resultView.printBoughtLottos(lottoNumbersList);
        WinLottoNumbers winNumbers = drawWinNumbers();
        List<LottoRank> lottoRanks = matchLottos(lottoNumbersList, winNumbers);
        LottoGameResultDTO gameResult = gameResult(lottoRanks);
        resultView.printGameResult(gameResult);
    }

    private List<LottoNumbers> buyLotto() {
        BuyLotto buyLotto = new BuyLotto(budget, lottoNumbersFactory);
        int manualBuyCount = inputView.takeManualBuyCount();
        manualBuyLotto(buyLotto, manualBuyCount);
        int autoBuyCount = buyLotto.autoBuyRemainingBudget();
        resultView.printBoughtCount(manualBuyCount, autoBuyCount);
        return buyLotto.boughtLottos();
    }

    private void manualBuyLotto(BuyLotto buyLotto, int manualBuyCount) {
        inputView.printManualLottoNumbersHeader();
        for (int i = 0; i < manualBuyCount; i++) {
            List<Integer> numbers = inputView.takeManualLottoNumbers();
            buyLotto.manual(numbers);
        }
    }

    private WinLottoNumbers drawWinNumbers() {
        LottoNumbers winMainNumbers = drawWinMainNumbers();
        LottoNumber bonusNumber = drawBonusNumber();
        return WinLottoNumbers.Builder.getInstance()
                .lottoNumbers(winMainNumbers)
                .bonusNumber(bonusNumber)
                .build();
    }

    private LottoNumbers drawWinMainNumbers() {
        List<Integer> numbers = inputView.takeWinMainNumbers();
        return lottoNumbersFactory.createLottoNumbers(numbers);
    }

    private LottoNumber drawBonusNumber() {
        int number = inputView.takeBonusNumbers();
        return new LottoNumber(number);
    }

    private List<LottoRank> matchLottos(List<LottoNumbers> lottoNumbersList, WinLottoNumbers winNumbers) {
        return lottoNumbersList.stream()
                .map(lottoNumbers -> winNumbers.match(lottoNumbers))
                .collect(toList());
    }

    private LottoGameResultDTO gameResult(List<LottoRank> lottoRanks) {
        LottoGameResult gameResult = new LottoGameResult(lottoRanks);
        return new LottoGameResultDTO(gameResult.statistics(), gameResult.yield());
    }
}

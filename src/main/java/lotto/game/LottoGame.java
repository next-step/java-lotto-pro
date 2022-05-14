package lotto.game;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import lotto.dto.LottoGameResultDTO;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumbers;
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
        takeBudget();
        List<LottoNumbers> lottoNumbersList = buyLotto();
        resultView.printBoughtLottos(lottoNumbersList);
        LottoNumbers winNumbers = drawWinNumbers();
        List<LottoRank> lottoRanks = matchLottos(lottoNumbersList, winNumbers);
        LottoGameResultDTO gameResult = gameResult(lottoRanks);
        resultView.printGameResult(gameResult);
    }

    private void takeBudget() {
        budget = inputView.takeBudget();
    }

    private List<LottoNumbers> buyLotto() {
        int drawCount = budget / LOTTO_PRICE;
        return IntStream.range(0,drawCount).mapToObj(i->lottoNumbersFactory.createRandomLottoNumbers()).collect(toList());
    }

    private LottoNumbers drawWinNumbers() {
        List<Integer> numbers = inputView.takeWinNumbers();
        return lottoNumbersFactory.createLottoNumbers(numbers);
    }

    private List<LottoRank> matchLottos(List<LottoNumbers> lottoNumbersList, LottoNumbers winNumbers) {
        return lottoNumbersList.stream()
                .map(lottoNumbers->lottoNumbers.matchWithWinNumbers(winNumbers))
                .collect(toList());
    }

    private LottoGameResultDTO gameResult(List<LottoRank> lottoRanks) {
        LottoGameResult gameResult = new LottoGameResult(lottoRanks);
        return new LottoGameResultDTO(gameResult.statistics(), gameResult.yield());
    }
}

package lotto.game;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoGameResultDTO;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumbers;
import lotto.rank.LottoRank;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {
    private final int LOTTO_PRICE = 1000;

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
        LottoNumbers winNumbers = drawWinNumbers();
        List<LottoRank> lottoRanks = matchLottos(lottoNumbersList, winNumbers);
        LottoGameResultDTO gameResult = calculateStatisticsAndYield(lottoRanks);
        resultView.printGameResult(gameResult);
    }

    private void takeBudget() {
        budget = inputView.takeBudget();
    }

    private List<LottoNumbers> buyLotto() {
        int drawCount = budget / LOTTO_PRICE;
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < drawCount; i++) {
            lottoNumbersList.add(lottoNumbersFactory.createRandomLottoNumbers());
        }
        resultView.printBoughtLottos(lottoNumbersList);
        return lottoNumbersList;
    }

    private LottoNumbers drawWinNumbers() {
        List<Integer> numbers = inputView.takeWinNumbers();
        return lottoNumbersFactory.createLottoNumbers(numbers);
    }

    private List<LottoRank> matchLottos(List<LottoNumbers> lottoNumbersList, LottoNumbers winNumbers) {
        List<LottoRank> ranks = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            ranks.add(lottoNumbers.matchWithWinNumbers(winNumbers));
        }
        return ranks;
    }

    private LottoGameResultDTO calculateStatisticsAndYield(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> statistics = calculateStatistics(lottoRanks);
        double yield = calculateYield(statistics);
        return new LottoGameResultDTO(statistics, yield);
    }

    private Map<LottoRank, Integer> calculateStatistics(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> statistics = lottoRanks.stream().collect(
                groupingBy(
                        lottoRank -> lottoRank
                        , () -> new EnumMap<>(LottoRank.class)
                        , collectingAndThen(toList(), list -> list.size())
                )
        );
        statistics.remove(LottoRank.NO_PRIZE);
        return statistics;
    }

    private double calculateYield(Map<LottoRank, Integer> statistics) {
        long prize = 0;
        for (LottoRank rank : statistics.keySet()) {
            int count = statistics.get(rank);
            prize += rank.calculatePrize(count);
        }
        return prize / (double) budget;
    }
}

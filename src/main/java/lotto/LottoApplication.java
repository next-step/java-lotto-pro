package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningRank;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();
    private LottoPrice lottoPrice;
    private List<Integer> winningNumbers;
    private Integer winningBonusNumber;

    public LottoPrice purchase(Integer price) {
        lottoPrice = new LottoPrice(price);
        return lottoPrice;
    }

    public List<LottoNumbers> generateLottoNumbers() {
        Integer count = lottoPrice.getCount();
        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = new LottoNumbers();
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, Integer winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public LottoStatistics calculateStatistics() {
        return new LottoStatistics(calculateWinningRanks(), lottoPrice);
    }

    private List<WinningRank> calculateWinningRanks() {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (LottoNumbers lottoNumber : lottoNumbers) {
            winningRanks.add(lottoNumber.matchWinningNumbers(winningNumbers, winningBonusNumber));
        }
        return winningRanks;
    }
}

package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottoNumber;
import lotto.domain.WinningRank;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();
    private LottoPrice lottoPrice;
    private WinningLottoNumber winningNumbers;

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

    public void setWinningNumbers(WinningLottoNumber winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoStatistics calculateStatistics() {
        return new LottoStatistics(calculateWinningRanks(), lottoPrice);
    }

    private List<WinningRank> calculateWinningRanks() {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (LottoNumbers lottoNumber : lottoNumbers) {
            winningRanks.add(lottoNumber.matchWinningNumbers(winningNumbers));
        }
        return winningRanks;
    }
}

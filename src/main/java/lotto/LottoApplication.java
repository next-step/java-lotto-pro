package lotto;

import lotto.domain.GenerateLottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottoNumber;
import lotto.domain.WinningRank;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();
    private final GenerateLottoNumber generateLottoNumber = new GenerateLottoNumber();
    private LottoPrice lottoPrice;
    private WinningLottoNumber winningNumbers;

    public LottoPrice purchase(Integer price, Integer manualCount) {
        lottoPrice = new LottoPrice(price, manualCount);
        return lottoPrice;
    }

    public List<LottoNumbers> generateLottoNumbers(List<List<Integer>> manualLottoNumbers) {
        Integer manualCount = lottoPrice.getManualCount();
        for (int i = 0; i < manualCount; i++) {
            lottoNumbers.add(new LottoNumbers(manualLottoNumbers.get(i)));
        }
        Integer autoCount = lottoPrice.getAutoCount();
        for (int i = 0; i < autoCount; i++) {
            lottoNumbers.add(new LottoNumbers(generateLottoNumber.initNumbers()));
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

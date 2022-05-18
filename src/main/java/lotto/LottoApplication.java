package lotto;

import lotto.domain.GenerateLottoNumber;
import lotto.domain.LottoCount;
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
    private LottoCount lottoCount;
    private WinningLottoNumber winningNumbers;

    public LottoCount purchase(Integer price, Integer manualCount) {
        lottoPrice = new LottoPrice(price);
        lottoCount = new LottoCount(manualCount, lottoPrice);
        return lottoCount;
    }

    public List<LottoNumbers> generateLottoNumbers(List<List<Integer>> manualLottoNumbers) {
        Integer manualCount = lottoCount.getManualCount();
        for (int i = 0; i < manualCount; i++) {
            lottoNumbers.add(new LottoNumbers(manualLottoNumbers.get(i)));
        }
        Integer autoCount = lottoCount.getAutoCount();
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

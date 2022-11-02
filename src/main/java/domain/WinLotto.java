package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinLotto {
    private static final String DEFAULT_SPLIT_DILIMETER = ",";

    private final Lotto winLottoNumbers;
    private final WinReport winLottoReport;

    public WinLotto(String inputWinLottoNumbers, WinReport winLottoReport) {
        this.winLottoNumbers = splitWinLottoNumbers(inputWinLottoNumbers);
        this.winLottoReport = winLottoReport;
    }
    public WinLotto(String inputWinLottoNumbers) {
        this.winLottoNumbers = splitWinLottoNumbers(inputWinLottoNumbers);
        this.winLottoReport = new WinReport();
    }

    public Lotto splitWinLottoNumbers(String inputWinLottNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String winNumber : inputWinLottNumbers.split(DEFAULT_SPLIT_DILIMETER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(winNumber.trim())));
        }

        return new Lotto(lottoNumbers);
    }

    public WinReport findWinner(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            winLottoReport.putLottoResult(countCollectNumber(lotto));
        }
        return winLottoReport;
    }

    public WinReport getWinLottoReport() {
        return winLottoReport;
    }

    public int countCollectNumber(Lotto inputLotto) {
        int collectCount = 0;
        for (LottoNumber lottoNumber : inputLotto.getLottoNumbers()) {
            collectCount += containNumbers(lottoNumber);
        }
        return collectCount;
    }

    private int containNumbers(LottoNumber lottoNumber) {
        if (winLottoNumbers.getLottoNumbers().contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinLotto winLotto = (WinLotto) o;
        return Objects.equals(winLottoNumbers, winLotto.winLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winLottoNumbers);
    }

    @Override
    public String toString() {
        return "WinLotto{" +
                "winLottoNumbers=" + winLottoNumbers +
                '}';
    }

}

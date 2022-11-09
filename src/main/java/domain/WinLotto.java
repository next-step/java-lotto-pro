package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinLotto {
    private static final String DEFAULT_SPLIT_DILIMETER = ",";

    private final Lotto winLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinLotto(String inputWinLottoNumbers, LottoNumber bonusNumber) {
        this.winLottoNumbers = splitWinLottoNumbers(inputWinLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto splitWinLottoNumbers(String inputWinLottNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String winNumber : inputWinLottNumbers.split(DEFAULT_SPLIT_DILIMETER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(winNumber.trim())));
        }

        return new Lotto(lottoNumbers);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinLottoNumbers() {
        return winLottoNumbers;
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

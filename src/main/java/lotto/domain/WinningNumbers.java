package lotto.domain;

import java.util.Objects;
import lotto.view.OutputView;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusBall;

    private WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningNumbers of(String input, int inputBonus) {
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator(input));
        LottoNumber bonusNumber = new LottoNumber(inputBonus);
        if (lottoNumbers.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_BONUS_NUMBER_NOT_DUPLICATE_LOTTO_NUMBER);
        }
        return new WinningNumbers(lottoNumbers, bonusNumber);
    }

    public WinningRank checkWinningRank(LottoNumbers lottoNumbers) {
        return WinningRank.valueOf(lottoNumbers.containCount(winningNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusBall,
                that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusBall);
    }
}

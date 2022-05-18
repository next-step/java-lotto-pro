package lotto.domain;

import java.util.Objects;

public class WinningNumbers {
    private final LottoNumbers lottoNumbers;

    private final LottoNumber bonusNumber;

    private WinningNumbers(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        validateBonusNumber(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        return new WinningNumbers(lottoNumbers, bonusNumber);
    }

    private void validateBonusNumber(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("잘못된 보너스 번호 입니다.");
        }
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningNumbers)) {
            return false;
        }
        final WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber,
                that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}

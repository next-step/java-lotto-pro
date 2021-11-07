package lotto.domain;

import java.util.Objects;

public class WinningLottoNumbers {
    private final LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNumbers(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningLottoNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스번호가 중복됩니다");
        }
    }

    public Rank getRank(LottoNumbers lottoNumbers) {
        int matchedCount = 0;
        int matchedBonusCount = 0;
        for (LottoNumber number : lottoNumbers.getNumbers()) {
            matchedCount = getIncreasedNumberIfContains(number, matchedCount);
            matchedBonusCount = getIncreasedBonusCountIfMatched(number, matchedBonusCount);
        }
        return Rank.of(matchedCount, matchedBonusCount);
    }

    private int getIncreasedBonusCountIfMatched(LottoNumber number, int matchedBonusCount) {
        if (Objects.equals(bonusNumber, number)) {
            return matchedBonusCount + 1;
        }
        return matchedBonusCount;
    }

    private int getIncreasedNumberIfContains(LottoNumber number, int result) {
        if (winningNumbers.contains(number)) {
            return result + 1;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoNumbers that = (WinningLottoNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}

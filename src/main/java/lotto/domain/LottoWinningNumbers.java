package lotto.domain;

import java.util.Objects;
import java.util.function.Predicate;

public class LottoWinningNumbers {

    private static final String INVALID_BONUS_NUMBER = "보너스 볼은 당첨 번호랑 같을 수 없습니다.";
    private final LottoNumbers lottoWinningNumbers;
    private final LottoNumber lottoBonusNumber;

    public LottoWinningNumbers(LottoNumbers lottoWinningNumbers, LottoNumber lottoBonusNumber) {
        validateDuplicate(lottoWinningNumbers, lottoBonusNumber);
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.lottoBonusNumber = lottoBonusNumber;
    }

    private void validateDuplicate(LottoNumbers lottoWinningNumbers, LottoNumber lottoBonusNumber) {
        if (lottoWinningNumbers.contains(lottoBonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }

    public LottoRank compareLottoNumbers(LottoNumbers lottoNumbers) {
        return LottoRank.of(calculateMatchCount(lottoNumbers), lottoNumbers.contains(lottoBonusNumber));
    }

    private int calculateMatchCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getLottoNumbers().stream()
                .filter(lottoNumber -> lottoWinningNumbers.getLottoNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(lottoNumber)))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningNumbers that = (LottoWinningNumbers) o;
        return Objects.equals(lottoWinningNumbers, that.lottoWinningNumbers) && Objects.equals(lottoBonusNumber, that.lottoBonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningNumbers, lottoBonusNumber);
    }

}

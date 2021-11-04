package study.lotto.model;

import java.util.HashSet;
import java.util.Set;

public class WinningNumber {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ILLEGAL_WINNING_NUMBER_SIZE_MESSAGE =
            "당첨번호는 6개의 서로 다른 로또번호를 가지고 있어야 합니다.";

    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    private WinningNumber(final Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public static WinningNumber valueOf(final Set<LottoNumber> lottoNumbers) {
        return new WinningNumber(lottoNumbers);
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalWinningNumberSizeException(ILLEGAL_WINNING_NUMBER_SIZE_MESSAGE);
        }
    }

    public boolean containsAll(final HashSet<LottoNumber> lottoNumbers) {
        return this.lottoNumbers.containsAll(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningNumber that = (WinningNumber) o;

        return lottoNumbers != null ? lottoNumbers.equals(that.lottoNumbers) : that.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}

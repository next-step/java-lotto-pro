package lotto.domain;

import java.util.Objects;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Prize prize(final LottoNumbers winningNumbers, final BonusBall bonusBall) {
        return Prize.checkPrize(lottoNumbers.matches(winningNumbers),
                lottoNumbers.matchesBonusBall(bonusBall));
    }

    public void print() {
        lottoNumbers.print();
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

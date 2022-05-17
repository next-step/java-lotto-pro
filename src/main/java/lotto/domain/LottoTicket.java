package lotto.domain;

import java.util.Objects;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    LottoTicket(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Prize prize(final LottoNumbers winningNumbers) {
        return Prize.findPrizeByMatchCount(lottoNumbers.matches(winningNumbers));
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

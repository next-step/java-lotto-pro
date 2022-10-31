package lotto.domain;

import lotto.common.ErrorMessage;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoTicket {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final Set<LottoNumber> ticket;

    public LottoTicket(Set<LottoNumber> lottoTicket) {
        this.validateDuplication(lottoTicket);
        this.ticket = lottoTicket;
    }

    private void validateDuplication(Set<LottoNumber> lottoTicket) {
        if (lottoTicket.size() == LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}

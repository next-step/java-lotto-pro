package lotto.domain;

import java.util.Objects;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class TicketCount {
    private static final int MIN_COUNT = 0;

    private final long count;

    public TicketCount(long count) {
        validate(count);
        this.count = count;
    }

    private void validate(long count) {
        if (count < MIN_COUNT) {
            throw new LottoException(LottoErrorCode.INVALID_COUNT);
        }
    }

    public long getCount() {
        return count;
    }

    public boolean isBiggerThan(TicketCount ticketCount) {
        return isBiggerThan(ticketCount.count);
    }

    public boolean isBiggerThan(long count) {
        return count < this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TicketCount)) {
            return false;
        }
        TicketCount that = (TicketCount)o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public TicketCount minus(TicketCount ticketCount) {
        return new TicketCount(this.count - ticketCount.count);
    }
}

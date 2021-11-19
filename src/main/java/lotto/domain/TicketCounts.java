package lotto.domain;

import java.util.Objects;

public class TicketCounts {
    private final TicketCount manualCount;
    private final TicketCount autoCount;

    public TicketCounts(TicketCount manualCount, TicketCount autoCount) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public TicketCount getManualCount() {
        return manualCount;
    }

    public TicketCount getAutoCount() {
        return autoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TicketCounts)) {
            return false;
        }
        TicketCounts that = (TicketCounts)o;
        return Objects.equals(manualCount, that.manualCount) &&
            Objects.equals(autoCount, that.autoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualCount, autoCount);
    }
}

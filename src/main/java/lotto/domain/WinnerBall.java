package lotto.domain;

import java.util.Objects;
import java.util.stream.Collectors;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class WinnerBall {
    private final Ticket ticket;
    private final Ball bonusBall;

    public WinnerBall(Ticket ticket, Ball bonusBall) {
        validateNoDuplicate(ticket, bonusBall);
        this.ticket = ticket;
        this.bonusBall = bonusBall;
    }

    private void validateNoDuplicate(Ticket ticket, Ball bonusBall) {
        if (ticket.getBalls().contains(bonusBall)) {
            throw new LottoException(LottoErrorCode.INVALID_BONUS_BALL);
        }
    }

    public Ranks calculateRank(Tickets tickets) {
        return new Ranks(tickets.getTickets().stream()
            .map(ticket -> ticket.calculateRank(this.ticket, containsBonus(ticket)))
            .collect(Collectors.toList()));
    }

    private boolean containsBonus(Ticket ticket) {
        return ticket.getBalls().contains(bonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinnerBall)) {
            return false;
        }
        WinnerBall that = (WinnerBall)o;
        return Objects.equals(ticket, that.ticket) &&
            Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, bonusBall);
    }
}

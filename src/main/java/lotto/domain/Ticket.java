package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Ticket {
    public static final int SIZE = 6;

    private final Set<Ball> balls;

    public Ticket(List<Integer> numbers) {
        checkValidSize(numbers);

        this.balls = numbers.stream()
            .map(Ball::of)
            .collect(Collectors.toSet());

        checkNoDuplicate();
    }

    private void checkValidSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_TICKET);
        }
    }

    private void checkNoDuplicate() {
        if (balls.size() != SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_TICKET);
        }
    }

    public Set<Ball> getBalls() {
        return balls;
    }

    public Rank calculateRank(Ticket winnerTicket, boolean containsBonus) {
        int correctCount = (int)this.balls.stream()
            .filter(winnerTicket.balls::contains)
            .count();

        return Rank.valueOf(correctCount, containsBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ticket)) {
            return false;
        }
        Ticket that = (Ticket)o;
        return Objects.equals(balls, that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}

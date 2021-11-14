package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Ticket {
    public static final int SIZE = 6;

    private final List<Ball> balls;

    public Ticket(List<Integer> numbers) {
        checkValidSize(numbers);
        checkNoDuplicate(numbers);

        this.balls = numbers.stream()
            .map(Ball::new)
            .sorted()
            .collect(Collectors.toList());
    }

    private void checkNoDuplicate(List<Integer> numbers) {
        if (SIZE != numbers.stream().distinct().count()) {
            throw new LottoException(LottoErrorCode.INVALID_TICKET);
        }
    }

    private void checkValidSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_TICKET);
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Rank calculateRank(Ticket winnerTicket, boolean containsBonus) {
        int correctCount = (int)this.balls.stream()
            .filter(number -> winnerTicket.balls.contains(number))
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

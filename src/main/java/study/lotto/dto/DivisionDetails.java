package study.lotto.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DivisionResults;
import study.lotto.domain.draw.DrawResult;

public class DivisionDetails {
    private final int matchCount;
    private final BigDecimal prize;
    private final Long winningCount;

    public DivisionDetails(Division division, Long winningCount) {
        this(division.getMatchCount(), division.getPrize(), winningCount);
    }

    public DivisionDetails(int matchCount, BigDecimal prize, Long winningCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public static List<DivisionDetails> from(DrawResult drawResult) {
        return drawResult.getDivisionResults().stream()
                .map(DivisionDetails::from)
                .collect(Collectors.toList());
    }

    public static DivisionDetails from(DivisionResult divisionResult) {
        return new DivisionDetails(divisionResult.getDivision(), divisionResult.getCount());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public Long getWinningCount() {
        return winningCount;
    }
}

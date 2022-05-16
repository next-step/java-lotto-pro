package study.lotto.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DrawResult;

public class DivisionDetails {
    private final int matchCount;
    private final boolean bonusMatch;
    private final BigDecimal prize;
    private final Long winningCount;

    public DivisionDetails(Division division, Long winningCount) {
        this.matchCount = division.getMatchCount();
        this.bonusMatch = division.getBonusMandatory();
        this.prize = division.getPrize();
        this.winningCount = winningCount;
    }

    public static List<DivisionDetails> from(DrawResult drawResult) {
        return drawResult.get().stream()
                .map(DivisionDetails::from)
                .collect(Collectors.toList());
    }

    public static DivisionDetails from(DivisionResult divisionResult) {
        return new DivisionDetails(divisionResult.getDivision(), divisionResult.getCount());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() { return bonusMatch; }

    public BigDecimal getPrize() {
        return prize;
    }

    public Long getWinningCount() {
        return winningCount;
    }
}

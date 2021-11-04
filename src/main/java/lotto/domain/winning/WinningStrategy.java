package lotto.domain.winning;

@FunctionalInterface
public interface WinningStrategy {

    boolean matching(int winningCount, boolean isMatchBonus);

}

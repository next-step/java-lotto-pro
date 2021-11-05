package lotto.domain.winning;

public interface WinningStrategy<T, U> {

    boolean matching(T winningCount, U isMatchBonus);

}

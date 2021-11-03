package lotto.domain.startegy.winningstrategy;

@FunctionalInterface
public interface WinningStrategy {
    boolean winnable(int matchingCount, boolean isBonus);
}

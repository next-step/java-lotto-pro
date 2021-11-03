package lotto.startegy;

@FunctionalInterface
public interface MatchStrategy {
    boolean isMatch(int matchCount);
}

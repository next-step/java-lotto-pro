package lotto.domain;

public class LottoResult {
    private static final double CRITERION = 1;

    public static boolean isCriterionRate(double earningsRate) {
        return earningsRate > CRITERION;
    }
}

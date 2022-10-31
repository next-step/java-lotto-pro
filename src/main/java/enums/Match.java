package enums;

import java.util.Arrays;

import static model.WinningLottoNumbers.BONUS_BALL_ADD_DELIMETER;

public enum Match {
    ZERO(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int amount;

    Match(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Match findMatch(int matchCount, boolean isMatchBonusBall) {
        if (isSecond(matchCount, isMatchBonusBall)) {
            return Match.SECOND;
        }

        return Arrays.stream(Match.values()).filter(match -> match.getCount() == matchCount)
                .findFirst()
                .orElse(ZERO);
    }

    private static boolean isSecond(int matchCount, boolean isMatchBonusBall) {
        return matchCount + BONUS_BALL_ADD_DELIMETER == SECOND.matchCount && isMatchBonusBall;
    }

    public static boolean isSecond(Match match) {
        return match.equals(Match.SECOND);
    }

    public static boolean isZero(Match match) {
        return match.equals(Match.ZERO);
    }

    public int getCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }
}

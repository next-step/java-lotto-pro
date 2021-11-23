package lotto.consts;

import java.util.Arrays;

public enum WinningEnum {

    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false);

    private final int prize;
    private final int matched;
    private final boolean bonusNumberMatched;

    WinningEnum(int prize, int matched, boolean bonusNumberMatched) {
        this.prize = prize;
        this.matched = matched;
        this.bonusNumberMatched = bonusNumberMatched;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatched() {
        return matched;
    }

    public static WinningEnum findByMatched(int matched, boolean bonusNumberMatched) {
        return Arrays.stream(values()).filter(winningEnum -> winningEnum.matched == matched && winningEnum.bonusNumberMatched == bonusNumberMatched).findAny().orElse(NONE);
    }
}

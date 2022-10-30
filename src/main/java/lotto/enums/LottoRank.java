package lotto.enums;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchNumberCount;
    private final int reward;
    private final boolean bonus;

    LottoRank(int matchNumberCount, int reward, boolean bonus) {
        this.matchNumberCount = matchNumberCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    // TODO: 기존 코드(추후 삭제)
    public static LottoRank findLottoRank(int matchNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> item.matchNumberCount == matchNumberCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    public static LottoRank findLottoRank(int matchNumberCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> matchLottoRank(item, matchNumberCount, bonus))
                .findAny()
                .orElse(LottoRank.NONE);
    }

    private static boolean matchLottoRank(LottoRank lottoRank, int matchNumberCount, boolean bonus) {
        // TODO: 기존 로또 번호 일치 여부 확인
        if (lottoRank.matchNumberCount == matchNumberCount) {
            // TODO: 보너스 번호 일치 여부 확인
            if (lottoRank.bonus == (LottoRank.SECOND.matchNumberCount == matchNumberCount && bonus)) {
                return true;
            }
        }
        return false;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getReward() {
        return reward;
    }

}
package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);

    private final int match;
    private final long prize;
    private final boolean hasBonus;

    LottoRank(int match, long prize, boolean hasBonus) {
        this.match = match;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static LottoRank valueOf(int match, boolean hasBonus) {
        List<LottoRank> ranks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        return ranks.stream().filter(rank -> rank.isMatchRank(match, hasBonus)).findFirst().orElse(LottoRank.NONE);
    }

    public static List<LottoRank> filteredHasPrize(List<LottoRank> lottoRanks) {
        return lottoRanks.stream().filter(LottoRank::hasPrize).collect(Collectors.toList());
    }

    private boolean matchBonus(boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

    public int getMatch() {
        return match;
    }

    public boolean isMatch(int match) {
        return this.match == match;
    }

    public long getPrize() {
        return prize;
    }

    public boolean hasBonus() {
        return this.hasBonus;
    }
    
    public boolean isMatchRank(int match, boolean hasBonus) {
        if (!isMatch(match)) {
            return false;
        }
        if (!matchBonus(hasBonus)) {
            return false;
        }

        return true;
    }

    public boolean hasPrize() {
        if (prize > NONE.prize) {
            return true;
        }
        return false;
    }
}


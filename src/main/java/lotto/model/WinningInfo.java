package lotto.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningInfo {
    SAME_COUNT_3(3, 5000),
    SAME_COUNT_4(4, 50000),
    SAME_COUNT_5(5, 1500000),
    SAME_COUNT_6(6, 2000000000);

    private final int sameCount;
    private final int winningMoney;

    WinningInfo(int sameCount, int winningMoney) {
        this.sameCount = sameCount;
        this.winningMoney = winningMoney;
    }

    public int sameCount() {
        return sameCount;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public static WinningInfo valueOfSameCount(Integer sameCount) {
        return FIND_SAME_COUNT.get(sameCount);
    }

    private static final Map<Integer, WinningInfo> FIND_SAME_COUNT =
            Stream.of(values()).collect(Collectors.toMap(WinningInfo::sameCount, info -> info));

}

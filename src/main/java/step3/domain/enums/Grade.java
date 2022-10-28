package step3.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum Grade {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final long count;
    private final long amount;

    Grade(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public long getCount() {
        return count;
    }

    public long getAmount() {
        return amount;
    }

    private static final Map<Long, Grade> countPerGrade = new HashMap<>();

    static {
        for (Grade grade : values()) {
            countPerGrade.put(grade.count, grade);
        }
    }

    public static Grade getGradeBy(long count, boolean matchBonus) {
        if (count == 5) {
            return getSecondOrThird(matchBonus);
        }
        if (count >= 3 && count <= 6) {
            return countPerGrade.get(count);
        }
        return MISS;
    }

    private static Grade getSecondOrThird(boolean matchBonus) {
        if(matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}

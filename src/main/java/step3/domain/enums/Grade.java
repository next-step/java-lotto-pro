package step3.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum Grade {
    DRAW(0, 0),
    FORTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

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

    public static Grade getGradeBy(long count) {
        if (count >= 3 && count <= 6)
            return countPerGrade.get(count);
        return DRAW;
    }
}

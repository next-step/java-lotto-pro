package step3.domain;

import java.util.EnumMap;
import java.util.Map;
import step3.domain.enums.Grade;

public class Grades {
    private final Map<Grade, Long> grades = new EnumMap<>(Grade.class);

    public void increaseGradeCount(Grade grade) {
        long currentCount = grades.getOrDefault(grade, 0L);
        grades.put(grade, currentCount + 1);
    }

    public long getGradeCount(Grade grade) {
        return grades.getOrDefault(grade, 0L);
    }
}

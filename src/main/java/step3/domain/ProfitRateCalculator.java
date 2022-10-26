package step3.domain;

import step3.domain.enums.Grade;

public class ProfitRateCalculator {

    public static float getProfitRate(Grades grades, Integer amount) {
        long profit = 0;
        for (Grade grade : Grade.values()) {
            long count = grades.getGradeCount(grade);
            profit += grade.getAmount() * count;
        }
        return (float) profit / amount;
    }
}

package step3.domain;

import java.util.List;
import step3.domain.enums.Grade;

public class GradeCalculator {

    public static Grades getGrades(Lottos lottos, List<Integer> winNumbers) {
        Grades grades = new Grades();
        for (Lotto lotto : lottos.getLottos()) {
            long count = lotto.getNumberCountContainsBy(winNumbers);
            Grade grade = Grade.getGradeBy(count);
            grades.increaseGradeCount(grade);
        }
        return grades;
    }
}

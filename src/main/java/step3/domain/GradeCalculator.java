package step3.domain;

import step3.domain.enums.Grade;

public class GradeCalculator {

    public static Grades getGrades(Lottos lottos, Lotto winLotto) {
        Grades grades = new Grades();
        for (Lotto lotto : lottos) {
            long count = lotto.getNumberCountContainsBy(winLotto);
            Grade grade = Grade.getGradeBy(count);
            grades.increaseGradeCount(grade);
        }
        return grades;
    }
}

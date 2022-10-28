package step3.domain;

import step3.domain.enums.Grade;

public class GradeCalculator {

    public static Grades getGrades(Lottos lottos, LottoWinning lottoWinning) {
        Grades grades = new Grades();
        for (Lotto lotto : lottos) {
            long count = lottoWinning.getLottoMatchCount(lotto);
            boolean matchBonus = lottoWinning.matchBonusNumberBy(lotto);
            Grade grade = Grade.getGradeBy(count, matchBonus);
            grades.increaseGradeCount(grade);
        }
        return grades;
    }
}

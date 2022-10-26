package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.enums.Grade;

class GradesTest {

    @Test
    @DisplayName("당첨 등급에 따라 정상적으로 등급 당첨 카운트가 증가해야 한다")
    void increase_grade_count() {
        // given
        Grade grade = Grade.FIRST;
        Grades grades = new Grades();

        // when
        grades.increaseGradeCount(grade);

        // then
        assertThat(grades.getGradeCount(grade)).isEqualTo(1);
    }

    @Test
    @DisplayName("해당 등급의 카운트를 증기시킨적 없을 경우 기본값으로 0이 반환되어야 한다")
    void return_zero_when_not_increase_grade_count() {
        // given
        Grade givenGrade = Grade.FIRST;
        Grade otherGrade = Grade.DRAW;
        Grades grades = new Grades();

        // when
        grades.increaseGradeCount(givenGrade);

        // then
        assertThat(grades.getGradeCount(otherGrade)).isZero();
    }

}
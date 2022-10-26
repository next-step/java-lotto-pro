package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.enums.Grade;

class GradeCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,10,15,20:3", "1,8,15,22,29,36:2,9,16,23,30,37:0", "1,2,3,4,5,6:1,2,3,4,5,6:6"}, delimiter = ':')
    @DisplayName("로또 당첨번호와 생성된 로또를 비교해 일치한 개수를 카운팅하여 당첨 정보인 Grades를 리턴해야 한다")
    void calculate_grades_by_compare_LottoNumbers_and_winNumbers(String numbers, String winNumbers, int expectedCount) {
        // given
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(getIntegerCollectionBy(numbers)));

        // when
        Grades grades = GradeCalculator.getGrades(lottos, getIntegerCollectionBy(winNumbers));

        // then
        assertThat(grades.getGradeCount(Grade.getGradeBy(expectedCount))).isEqualTo(1);
    }

    private List<Integer> getIntegerCollectionBy(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
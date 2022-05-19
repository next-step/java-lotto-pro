package lotto.domain;

import lotto.domain.factory.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    @Test
    @DisplayName("객체 생성시 로또번호가 오름차순으로 정렬된다")
    void sort() {
        assertThat(LottoFactory.create("1,6,5,4,3,2")).isEqualTo(LottoFactory.create("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @DisplayName("우승 번호와 매칭되는 개수를 반환한다")
    @CsvSource(value = {
            "9,10,11,12,13,14:0",
            "1,10,11,12,13,14:1",
            "1,2,11,12,13,14:2",
            "1,2,3,12,13,14:3",
            "1,2,3,4,13,14:4",
            "1,2,3,4,5,14:5",
            "1,2,3,4,5,6:6",
    }, delimiter = ':')
    void matchCount(String lottoNumbers, int expected) {
        Lotto winningLotto = LottoFactory.create("1,2,3,4,5,6");
        assertThat(LottoFactory.create(lottoNumbers).matchCount(winningLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("로또번호가 6개가 아닐경우 예외가 발생한다")
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4","1,2,3,4,5","1,2,3,4,5,6,7"})
    void lottoCountException(String lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.create(lottoNumbers))
                .withMessage("로또번호가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("로또번호 1,2,3,4,5,6 멤버변수에 6이 포함되어 있으면 true 를 반환한다")
    void containsTrue() {
        assertThat(LottoFactory.create("1,2,3,4,5,6").contains(LottoNumber.of("6"))).isTrue();
    }

    @Test
    @DisplayName("로또번호 1,2,3,4,5,6 멤버변수에 7이 없으면 false 를 반환한다")
    void containsFalse() {
        assertThat(LottoFactory.create("1,2,3,4,5,6").contains(LottoNumber.of("7"))).isFalse();
    }
}

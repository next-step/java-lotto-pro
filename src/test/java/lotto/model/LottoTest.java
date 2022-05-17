package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @ParameterizedTest(name = "로또 객체 수동 생성 결과 중복을 제외하고 6개의 로또 번호를 가진다")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,6,6"})
    void lottoSizeTest(String input) {
        // given
        Lotto lotto = new Lotto(new InputNumberGenerator(input));

        // when
        List<Number> actual = lotto.getNumbers();

        // then
        assertThat(actual).hasSize(6);
    }

    @DisplayName("로또 객체 랜덤 생성 결과 6개의 로또 번호를 가진다")
    @Test
    void randomLottoSizeTest() {
        // given
        Lotto lotto = new Lotto(new RandomNumberGenerator());

        // when
        List<Number> actual = lotto.getNumbers();

        // then
        assertThat(actual).hasSize(6);
    }

    @ParameterizedTest(name = "Lotto 객체에 Number 객체가 존재하면 참을, 객체가 존재하지 않으면 거짓을 반환한다")
    @CsvSource(value = {"1,2,3,4,5,6:1:true", "1,2,3,4,5,6:7:false"}, delimiter = ':')
    void containsTest(String inputs, Number number, boolean expected) {
        // given
        Lotto lotto = new Lotto(new InputNumberGenerator(inputs));

        // when
        boolean actual = lotto.contains(number);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}

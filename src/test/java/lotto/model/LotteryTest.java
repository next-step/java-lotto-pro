package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryTest {
    @ParameterizedTest(name = "로또 객체 수동 생성 결과 중복을 제외하고 6개의 로또 번호를 가진다")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,6,6"})
    void lottoSizeTest(String input) {
        // given
        Lottery lottery = new Lottery(new InputNumberGenerator(input));

        // when
        List<Number> actual = lottery.getNumbers();

        // then
        assertThat(actual).hasSize(6);
    }

    @DisplayName("로또 객체 랜덤 생성 결과 6개의 로또 번호를 가진다")
    @Test
    void randomLottoSizeTest() {
        // given
        Lottery lottery = new Lottery(new RandomNumberGenerator());

        // when
        List<Number> actual = lottery.getNumbers();

        // then
        assertThat(actual).hasSize(6);
    }
}

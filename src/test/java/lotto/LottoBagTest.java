package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("로또 목록 테스트")
class LottoBagTest {

    @DisplayName("생성 테스트")
    @Test
    void create_lottoBag_success() {
        assertThatNoException().isThrownBy(() -> new LottoBag(new Money(10000), new LottoNumberGenerator()));
    }

    @ParameterizedTest(name = "발급 로또 갯수 테스트 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "10000:10", "10500:10", "500:0" }, delimiter = ':')
    void create_numberOfLotto_success(int money, int numberOfLotto) {
        //given:
        LottoBag lottoBag = new LottoBag(new Money(money), new LottoNumberGenerator());
        //when, then:
        assertThat(lottoBag.hasSize()).isEqualTo(numberOfLotto);
    }
}

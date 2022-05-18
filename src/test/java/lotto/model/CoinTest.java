package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CoinTest {

    private static final int LOTTO_PRICE = 1000;

    @ParameterizedTest(name = "금액을 {0}원 입력하여 가진다.")
    @ValueSource(strings = {"1000", "10000", "50000"})
    void insertMoneyTest(String expected) {
        // given & when
        Coin coin = new Coin(expected);
        int actual = coin.getDeposit();

        // then
        assertThat(actual).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest(name = "유효하지 않은 {0} 값을 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"오천원", "만원", "1000원"})
    void invalidInputTest(String money) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new Coin(money))
                .withMessageContaining("유효하지 않은 값입니다.");
    }


    @ParameterizedTest(name = "로또 1장의 금액보다 적은 값을 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"999", "0"})
    void minimumRangeMoneyTest(String money) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new Coin(money))
                .withMessageContaining("최소 구입금액은 " + LOTTO_PRICE + "원 입니다.");
    }

    @ParameterizedTest(name = "금액을 {0}원 입력하면 구매 횟수는 {1}회이다")
    @CsvSource(value = {"1000:1", "10000:10", "5999:5", "3333:3"}, delimiter = ':')
    void purchaseLottoTest(String money, int countOfLotto) {
        // given
        Coin coin = new Coin(money);

        // when
        int actual = coin.maxCountOfLotto();

        // then
        assertThat(actual).isEqualTo(countOfLotto);
    }
}

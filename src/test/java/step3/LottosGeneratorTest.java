package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Lottos;
import step3.domain.LottosGenerator;
import step3.domain.Price;

@DisplayName("LottosGenerator 클래스")
public class LottosGeneratorTest {
    @DisplayName("입력한 금액(금액 / 1,000)만큼의 로또를 발급한다.")
    @ParameterizedTest
    @CsvSource(value = {"15000:15", "12000:12", "8000:8"}, delimiter = ':')
    void generate_Per_Price(final int inputPrice, final int size) {
        final Lottos lottos = LottosGenerator.generateLottos(new Price(inputPrice));
        assertThat(lottos.getLottosCount()).isEqualTo(size);
    }

    @DisplayName("입력한 금액이 0 혹은 음수면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -15000, -12000, -8000})
    void price_Is_Minus_Then_IllegalArgumentException(final int inputPrice) {
        assertThatThrownBy(() -> LottosGenerator.generateLottos(new Price(inputPrice)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 천단위로 나누어 떨어지지 않으면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {18200, 13250, 1100, 3200})
    void price_Is_Not_Divisible_Then_IllegalArgumentException(final int inputPrice) {
        assertThatThrownBy(() -> LottosGenerator.generateLottos(new Price(inputPrice)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

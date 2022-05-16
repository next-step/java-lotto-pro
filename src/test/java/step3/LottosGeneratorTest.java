package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Lottos;
import step3.domain.LottosGenerator;
import step3.domain.Price;

@DisplayName("LottosGenerator 클래스")
public class LottosGeneratorTest {
    @DisplayName("입력한 금액(금액 / 1,000)만큼의 로또를 발급한다.")
    @ParameterizedTest
    @CsvSource(value = {"15000:15", "12000:12", "8000:8"}, delimiter = ':')
    void generatePerPrice(final int inputPrice, final int size) {
        final Lottos lottos = LottosGenerator.generateLottos(new Price(inputPrice));
        assertThat(lottos.getLottosCount()).isEqualTo(size);
    }
}

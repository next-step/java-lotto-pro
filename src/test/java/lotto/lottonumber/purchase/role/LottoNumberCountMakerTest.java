package lotto.lottonumber.purchase.role;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumberCountMakerTest {

    @ParameterizedTest
    @DisplayName("로또가격 으로 나눈 수 만큼 로또번호 갯수 생성")
    @CsvSource(value = {"1000:1", "12000:12", "25000:25"}, delimiter = ':')
    void makeLottoNumberCount(String purchase, int expected) {
        assertThat(new LottoNumberCountMaker().execute(purchase)).isEqualTo(expected);
    }
}

package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
class LottoTest {

    @Test
    void 정상_생성_프린트_검증() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
    @Test
    void 로또_같음_테스트() {
        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6))).isEqualTo(new Lotto(Arrays.asList(6,5,4,3,2,1)));
    }
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "7:false", "8:false"}, delimiter = ':')
    void 로또_번호_포함_테스트(int number, boolean result) {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.isMatched(new LottoNumber(number))).isEqualTo(result);
    }



}
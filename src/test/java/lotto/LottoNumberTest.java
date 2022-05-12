package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("LottoNumber는 ")
public class LottoNumberTest {
    @DisplayName("1 이상 45 이하이다")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void validateLotto(int number){
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("1 이상 45 이하가 아니라면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidateLotto(int number){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumber(number));
    }
}

package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import lotto.number.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0","-1","46"})
    @NullAndEmptySource
    void 로또번호_생성_예외_케이스(String input){
        assertThatIllegalArgumentException().isThrownBy(()->{
          new LottoNumber(input);
        });
    }

    @ParameterizedTest
    @MethodSource("provideValidNumber")
    void 로또번호_생성_성공_케이스(int input){
        LottoNumber lottoNumber = new LottoNumber(input);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(input));
    }

    private static IntStream provideValidNumber(){
        return IntStream.range(1,46);
    }
}

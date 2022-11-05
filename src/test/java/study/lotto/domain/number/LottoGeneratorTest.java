package study.lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.Lotto;
import study.lotto.domain.number.LottoGenerator;
import study.lotto.domain.order.OrderType;
import study.message.LottoExceptionCode;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 숫자 클래스 테스트")
class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, 46, 47, 100 })
    void 로또_숫자_범위가_아니면_IllegalArgumentException_발생(int num) {
        assertThatThrownBy(() -> {
            LottoGenerator.toLottoNumber(num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 22, 33, 45})
    void 로또_숫자_범위_내에서_같은_인스턴스를_반환(int num) {
        assertEquals(LottoGenerator.toLottoNumber(num), LottoGenerator.toLottoNumber(num));
    }

    @ParameterizedTest
    @ValueSource(strings = { "AUTO", "MANUAL" })
    void 로또를_생성한다(OrderType orderType) {
       Lotto lotto = LottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6), orderType);

       assertThat(lotto).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = { "AUTO", "MANUAL" })
    void 잘못된_번호가_포함된_숫자로_로또를_생성하면_IllegalArgumentException_발생(OrderType orderType) {
        assertThatThrownBy(() -> {
            LottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 46), orderType);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
    }
}

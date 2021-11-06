package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("LottoNumber 테스트")
class LottoNumberTest {
    @DisplayName("정상범위 생성 확인")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{arguments}]")
    @ValueSource(ints = {1, 12, 23, 34, 45})
    void 정상범위_생성_확인(int testValue) {
        // when, then
        assertThat(new LottoNumber(testValue)).isEqualTo(new LottoNumber(testValue));
    }

    @DisplayName("이상범위 실패 확인")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{arguments}]")
    @ValueSource(ints = {0, 46})
    void 이상범위_실패_확인(int testValue) {
        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(testValue));
    }

}

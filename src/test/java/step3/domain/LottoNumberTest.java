package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step2.SplitNumber;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20, 30, 45})
    @DisplayName("1 부터 45까지 LottoNumber 인스턴스 정상 생성")
    void 로또_넘버_생성(int inputLottoNumber) {
        new LottoNumber(inputLottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("1 부터 45 이외 입력 값 LottoNumber 인스턴스 생성 실패")
    void 로또_넘버_생성_실패(int inputLottoNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                // when
                new LottoNumber(inputLottoNumber);
            }) // then
            .withMessageMatching(LottoNumber.RANGE_OVER_EXCEPTION);
    }
}
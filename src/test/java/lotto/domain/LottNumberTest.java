package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : LottNumberTest
 * author : haedoang
 * date : 2021/11/04
 * description : 로또 번호 클래스 테스트
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LottNumberTest {

    @Test
    @DisplayName("유효한 로또 번호 테스트")
    public void T1_validLottoNumber() {
        //GIVEN
        LottoNumber lottoNumber = LottoNumber.valueOf(1);
        //THEN
        assertThat(lottoNumber).isEqualTo(LottoNumber.valueOf(1));
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
        assertThat(LottoNumber.valueOf("1")).isEqualTo(LottoNumber.valueOf(1));
    }

    @ParameterizedTest(name = "유효하지 않은 로또 숫자 테스트(integer) : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @ValueSource(ints = {-1, 0, 46, Integer.MIN_VALUE, Integer.MAX_VALUE})
    public void T02_invalidNumbers(int candidate) {
        //THEN
        assertThatThrownBy(() -> LottoNumber.valueOf(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자만 가능합니다.");
    }


    @ParameterizedTest(name = "유효하지 않은 로또 숫자 테스트(string) : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @ValueSource(strings = {"46", "-1", "0"})
    public void T03_invalidStringnumber(String candidate) {
        //THEN
        assertThatThrownBy(() -> LottoNumber.valueOf(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자만 가능합니다.");
    }

    @ParameterizedTest(name = "빈값, null값 검증 테스트 : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @NullAndEmptySource
    public void T04_invalidNull(String str) {
        //THEN
        assertThatThrownBy(() -> LottoNumber.valueOf(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값이나 null은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("캐시 테스트")
    public void T05_cache() {
        LottoNumber lottoNumber = LottoNumber.valueOf(1);
        assertThat(LottoNumber.valueOf(1) == lottoNumber).isTrue();

    }
}

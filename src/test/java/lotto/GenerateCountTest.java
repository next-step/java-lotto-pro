package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("구매 로또 수 테스트")
class GenerateCountTest {

    @DisplayName("생성 성공")
    @Test
    void create_generateCount_success() {
        assertThatNoException().isThrownBy(() -> new GenerateCount("1"));
    }

    @DisplayName("로또 수 값 가져오기 테스트")
    @Test
    void getCount_generateCount_success() {
        //given:
        GenerateCount generateCount = new GenerateCount("1");
        //when:
        //then:
        assertThat(generateCount.getCount()).isEqualTo(1);
    }

    @DisplayName("로또 수 값 가져오기 테스트 실패 - 숫자가 아닌 값")
    @Test
    void getCount_generateCount_NumberFormatException() {
        assertThatThrownBy(() -> new GenerateCount("abc")).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("minus 메서드 테스트")
    @Test
    void minus_generateCount_success() {
        //given:
        GenerateCount generateCount = new GenerateCount(10);
        //when, then
        assertThat(generateCount.minus(new GenerateCount(1))).isEqualTo(new GenerateCount(9));
    }

    @DisplayName("수동 생성 가능 갯수 유효성 검사")
    @Test
    void checkGreaterThan_count_success() {
        //given:
        GenerateCount available = new GenerateCount(1);
        GenerateCount manual = new GenerateCount(2);
        assertThatIllegalStateException().isThrownBy(() -> available.validGreaterThan(manual));
    }
}

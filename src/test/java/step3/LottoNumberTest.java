package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.LottoNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 47})
    @DisplayName("1보다작고 45보다 큰 숫자를 생성하면 예외발생")
    void test_that_returns_size_of_money(int number) {
        //given,when,then
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호는 1에서 45사이만 허용합니다");
    }

    @Test
    @DisplayName("기본으로 생성되있는 1부터 45를 가지고있는 로또객체 반환")
    void test_that_returns_base_lottonumber() {
        //given
        List<LottoNumber> lottoNumbers = LottoNumber.getLottoNumbers();

        //when,then
        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(LottoNumber.valueOf(i + 1));
        }
    }

    @Test
    @DisplayName("기본으로 생성되있는 1부터 45를 가지고있는 번호를 반환")
    void test_that_returns_base_number() {
        //given
        List<LottoNumber> lottoNumbers = LottoNumber.getLottoNumbers();

        //when,then
        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertThat(lottoNumbers.get(i).value()).isEqualTo(i + 1);
        }
    }
}

package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 숫자 리스트를 정상적으로 생성하는지 확인한다.")
    void createLottoNumbers_로또숫자_리스트() {
        assertThat(LottoNumbers.createLottoNumbers())
                .isExactlyInstanceOf(LottoNumbers.class)
                .hasFieldOrProperty("lottoNumbers")
                .extracting("lottoNumbers")
                .isInstanceOf(List.class);
    }

    @Test
    @DisplayName("로또 숫자 리스트에 중복값이 존재하면 예외를 발생시킨다.")
    void createLottoNumbers_중복예외() {
        List<Integer> numbers = Arrays.asList(4, 10, 9, 10, 35, 61);

        assertThatThrownBy(() -> LottoNumbers.createLottoNumbers(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR] 로또 번호에 중복 값이 존재합니다!");
    }

}
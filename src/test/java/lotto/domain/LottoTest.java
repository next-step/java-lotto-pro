package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class LottoTest {

    @Test
    @DisplayName("로또의 사이즈가 6인지 테스트")
    void lotto_size_test() {
        assertThat(new Lotto().getLotto()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또가 중복되지 않은 숫자로 이루어졌는지 테스트")
    void not_duplicate_composition_test() {
        Set<Integer> lottoComposition = new HashSet<>();
        Lotto lotto = new Lotto();
        for (Integer num : lotto.getLotto()) {
            lottoComposition.add(num);
        }
        assertThat(lottoComposition).hasSize(6);
    }

    @Test
    @DisplayName("당첨 번호로 로또 생성되는지 테스트")
    void win_lotto_generate_test() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        List<Integer> numList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        assertThat(lotto.getLotto()).isEqualTo(numList);
    }

    @Test
    @DisplayName("입력된 당첨번호가 6자리가 아닌 경우 예외처리")
    void invalid_win_lotto_length_test() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 당첨번호가 유효한 숫자가 아닌 경우 예외처리")
    void invalid_win_lotto_number_test() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 66")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 당첨번호가 ,로 구분되지 않은 경우 예외처리")
    void invalid_win_lotto_delimiter_test() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4.5.6")).isInstanceOf(IllegalArgumentException.class);
    }

}

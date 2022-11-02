package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        Lotto lotto = new Lotto();
        Set<LottoNumber> lottoComposition = new HashSet<>(lotto.getLotto());
        assertThat(lottoComposition).hasSize(6);
    }

    @Test
    @DisplayName("당첨 번호로 로또 생성되는지 테스트")
    void win_lotto_generate_test() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        List<LottoNumber> numList = new ArrayList<>();
        numList.add(new LottoNumber(1));
        numList.add(new LottoNumber(2));
        numList.add(new LottoNumber(3));
        numList.add(new LottoNumber(4));
        numList.add(new LottoNumber(5));
        numList.add(new LottoNumber(6));
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

    @Test
    @DisplayName("입력된 당첨번호가 중복된 경우 예외처리")
    void duplicate_number_test() {
        assertThatThrownBy(() -> new Lotto("1,1,1,1,1,1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또에 특정 숫자 포함 여부 확인 테스트")
    void isContained_test() {
        assertThat(new Lotto("1,2,3,4,5,6").isContained(new LottoNumber(1))).isTrue();
    }

    @Test
    @DisplayName("두 Lotto의 일치한 숫자 개수 테스트")
    void countMatchNum_test() {
        Lotto lotto1 = new Lotto("1,2,3,4,5,6");
        Lotto lotto2 = new Lotto("4,5,6,7,8,9");
        assertThat(lotto1.countMatchNum(lotto2)).isEqualTo(3);
    }

}

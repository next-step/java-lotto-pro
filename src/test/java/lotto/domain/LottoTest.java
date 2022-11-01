package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

}

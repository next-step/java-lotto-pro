package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberBagTest {

    @DisplayName("로또 넘버 목록을 담는 일급 컬렉션 생성 성공")
    @Test
    void create_bag_success() {
        assertThatNoException().isThrownBy(LottoNumberBag::new);
    }

    @DisplayName("당첨 번호 일치 카운트 제공")
    @Test
    void contains_number_success() {
        LottoNumberBag lottoNumberBag = new LottoNumberBag(Arrays.asList(1, 2, 3, 10, 20, 30));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int correctCount = lottoNumberBag.correctCount(winningNumbers);
        assertThat(correctCount).isEqualTo(3);
    }
}

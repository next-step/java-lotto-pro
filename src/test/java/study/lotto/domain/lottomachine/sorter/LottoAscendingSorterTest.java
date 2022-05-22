package study.lotto.domain.lottomachine.sorter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.lottomachine.sorter.LottoAscendingSorter;

class LottoAscendingSorterTest {
    @Test
    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    void 로또_정렬() {
        Lotto lotto = Lotto.from("2, 1, 5, 4, 3, 6");

        Lotto expected = Lotto.from("1, 2, 3, 4, 5, 6");
        Lotto actual = new LottoAscendingSorter().sort(lotto);
        assertThat(actual).isEqualTo(expected);
    }
}

package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPaperTest {

    @Test
    @DisplayName("로또 번호가 저장됐는지 확인한다.")
    void save_lotto_number_test() {
        List<Lotto> lottos = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(12));
        numbers.add(new Number(23));
        numbers.add(new Number(34));
        numbers.add(new Number(43));
        numbers.add(new Number(44));
        lottos.add(new Lotto(numbers));

        LottoPaper lottoPaper = new LottoPaper(lottos);

        assertThat(lottoPaper).isEqualTo(new LottoPaper(lottos));
    }
}

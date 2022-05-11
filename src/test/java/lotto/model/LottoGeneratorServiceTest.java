package lotto.model;

import java.util.List;
import lotto.vo.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorServiceTest {

    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();

    @DisplayName("로또를 생성한다.(번호 6개)")
    @Test
    void generateLotto() {
        Lotto lotto = lottoGeneratorService.generateLotto();
        List<Integer> numberList = lotto.getNumberList();

        assertThat(numberList).hasSize(6);
        for (int number : numberList) {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(45);
        }
    }

}

package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.lottomachine.LottoGenerator;

class AutomaticLottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new AutomaticLottoGenerator();

    @Test
    @DisplayName("로또 번호를 자동 생성한다.")
    void 로또번호를_자동으로_생성() {
        assertThat(lottoGenerator.generate()).isNotEmpty();
    }

    @Test
    @DisplayName("로또번호 생성기에 정의된 정렬방법으로 번호를 정렬한다.")
    void 정렬() {
        assertThat(lottoGenerator.sort(Lotto.from("10,1,5,2,3,7")))
                .containsExactlyElementsOf(Lotto.from("1,2,3,5,7,10").get());
    }
}

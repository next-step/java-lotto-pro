package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.LottoFormatException;
import step4.model.generator.LottoManualGenerator;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또_생성_클래스")
public class LottoManualGeneratorTest {
    @DisplayName("로또생성 테스트")
    @Test
    void createLotto_pass_01() {
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(new ArrayList<String>() {{
            add("1,2,3,4,5,6");
        }}, new LottoBuyCount(1));
        assertThatNoException().isThrownBy(lottoManualGenerator::createLottos);
    }

    @DisplayName("로또생성 리스트와 count 개수가 안맞으면 에러처리")
    @Test
    void createLotto_fail_01() {
        assertThatThrownBy(() -> new LottoManualGenerator(new ArrayList<String>() {{
            add("1,2,3,4,5,6");
        }}, new LottoBuyCount(2)))
                .isInstanceOf(LottoFormatException.class);
    }
}

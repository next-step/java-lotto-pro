package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.generator.LottoAutoGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또_생성_클래스")
public class LottoAutoGeneratorTest {
    @DisplayName("로또생성 테스트")
    @Test
    void createLotto_pass_01() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator(new LottoBuyCount(1));
        assertThatNoException().isThrownBy(lottoAutoGenerator::createLottos);
    }

    @DisplayName("로또생성_결과_테스트")
    @Test
    void createLotto_pass_02() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator(new LottoBuyCount(1));
        assertThat(lottoAutoGenerator.createLottos().count()).isEqualTo(new Lottos(new Lotto("1,2,3,4,5,6")).count());
    }
}

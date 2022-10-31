package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기 테스트")
class LottoNumberGeneratorTest {

    private static final int LOTTO_NUMBER_SIZE = 6;

    @DisplayName("생성 성공")
    @Test
    void
    create_numbers_success() {
        //given:
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        //when, then:
        assertThat(lottoNumberGenerator.generate()).hasSize(LOTTO_NUMBER_SIZE);
    }

    @DisplayName("중복 숫자 테스트")
    @Test
    void create_numbers_noDuplicates() {
        //given:
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        //when, then:
        assertThat(lottoNumberGenerator.generate()).doesNotHaveDuplicates();
    }
}

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("랜덤 로또값 6자리 정상적으로 생성하는 테스트")
    void lotto_generator_generate_test() {
        Number lottoNumber = new LottoNumber();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        Set<LottoNumber> lottoNumbers = lottoNumberGenerator.generate(lottoNumber);

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
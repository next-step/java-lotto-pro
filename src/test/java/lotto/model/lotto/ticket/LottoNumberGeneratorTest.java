package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberGeneratorTest {

    @Nested
    @DisplayName("LottoNumberGenerator 생성자 테스트")
    class Constructor {
        @RepeatedTest(value = 100)
        @DisplayName("한 장의 로또에 있는 숫자는 총 6개이고, 어떤 숫자도 서로 중복이 없다.")
        void success() {
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            final List<LottoNumber> generatedNumbers = lottoNumberGenerator.generate();
            final Set<LottoNumber> generatedNumbersSet = new HashSet<>(generatedNumbers);
            assertAll(
                    () -> assertThat(lottoNumberGenerator.generate().size()).isEqualTo(LottoNumberGenerator.NUMBER_COUNT_IN_SINGLE_LOTTO_TICKET),
                    () -> assertThat(lottoNumberGenerator.generate().size()).isEqualTo(generatedNumbersSet.size())
            );
        }
    }
}

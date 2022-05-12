package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("StringSplittingLottoGenerator 클래스 테스트")
class StringSplittingLottoGeneratorTest {

    @DisplayName("StringSplittingLottoGenerator 생성 성공")
    @Test
    void successfulCreate() {
        assertThat(new StringSplittingLottoGenerator("1,2,3,4,5,6", ",")).isNotNull();
    }

    @DisplayName("StringSplittingLottoGenerator 생성 실패")
    @ParameterizedTest
    @CsvSource({
            "'',",
            ",''",
            "'',''"
    })
    void failureCreate(String value, String delimiter) {
        assertThatThrownBy(() -> {
            new StringSplittingLottoGenerator(value, delimiter);
        })
        .isInstanceOf(FailureCreatingLottoGeneratorException.class)
        .hasMessageContaining("LottoGenerator 생성 실패했습니다.");
    }

    @DisplayName("구분자(|)를 이용하여 문자열을 잘라 Lotto 생성")
    @Test
    void generate() {
        final Lotto expected = Lotto.of(1, 2, 3, 4, 5, 6);
        final LottoGenerator lottoGenerator = new StringSplittingLottoGenerator("1|2|3|4|5|6", "|");
        final Lotto lotto = lottoGenerator.generate();
        assertThat(lotto.getLottoNumbers()).isEqualTo(expected.getLottoNumbers());
    }

    @DisplayName("구분자(,)를 이용하여 문자열을 잘라 Lotto 생성")
    @Test
    void commaSplitting() {
        final LottoGenerator lottoGenerator = LottoGenerator.commaSplitting("1,2,3,4,5");
        final Lotto lotto = lottoGenerator.generate();
        assertThat(lotto).isNotNull();
    }
}

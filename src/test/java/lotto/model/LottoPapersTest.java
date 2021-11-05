package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPapersTest {

    @DisplayName("[정상]로또생성 사이즈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14:1000:3500"}, delimiter = ':')
    void 로또사이즈_테스트(long size) {
        // given
        // when
        long lottoPaperSize = LottoPapers.createLottoPapers(size).lottoPaperSize();
        // then
        assertThat(lottoPaperSize).isEqualTo(size);
    }
}

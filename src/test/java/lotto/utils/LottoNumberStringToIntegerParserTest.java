package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberStringToIntegerParserTest {

    @Test
    @DisplayName("분리된 문자열을 인자로 받아 Integer List Collection을 반환한다.")
    void parse01() {
        // given
        String text = "1, 2, 3, 4, 5, 6";
        String[] splitText = LottoNumberStringSplitter.split(text);

        // when
        List<Integer> lottoNumbers = LottoNumberStringToIntegerParser.parse(splitText);

        // then
        assertAll(
            () -> assertThat(lottoNumbers).contains(1),
            () -> assertThat(lottoNumbers).contains(2),
            () -> assertThat(lottoNumbers).contains(3),
            () -> assertThat(lottoNumbers).contains(4),
            () -> assertThat(lottoNumbers).contains(5),
            () -> assertThat(lottoNumbers).contains(6),
            () -> assertThat(lottoNumbers).hasSize(6)
        );
    }

}
package study.step4.helper;

import org.junit.jupiter.api.Test;
import study.step4.models.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStringParserTest {
    @Test
    void 구분자가_있는_문자열_정수형_리스트로_변경() {
        List<LottoNumber> lottoNumbers = LottoStringParser.stringToLottoNumbers("1, 2, 3, 4, 5, 6");

        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).isEqualTo(
                Arrays.asList(
                        new LottoNumber(1)
                        , new LottoNumber(2)
                        , new LottoNumber(3)
                        , new LottoNumber(4)
                        , new LottoNumber(5)
                        , new LottoNumber(6)));
    }
}

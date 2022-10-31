package step3;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;

public class LottoNumbersTest {
    @Test
    @DisplayName("로또번호 개수가 6개 이상인 경우 에러 발생 테스트")
    public void lottoNumbersOverMaxCnt() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6), new LottoNumber(7));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumbers(lottoNumberList))
            .withMessage(LottoNumbers.NOT_MATCHED_NUMBER_SIZE);
    }

    @Test
    @DisplayName("로또번호 개수가 중복되는 경우 에러 발생 테스트")
    public void lottoNumbersDuplicate() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(1),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumbers(lottoNumberList))
            .withMessage(LottoNumbers.EXIST_DUPLICATE_VALUE);
    }
}

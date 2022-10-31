package step3;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;

public class LottoTest {

    @Test
    @DisplayName("로또 결과 비교해서 결과 확인 테스트")
    void lottoRank() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
            new LottoNumber(6));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumberList));
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        assertThat(lotto.compareNumbers(winningNumbers)).isEqualTo(5);
    }

}

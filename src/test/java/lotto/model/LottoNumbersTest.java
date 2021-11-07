package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    void instantiate() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }
}

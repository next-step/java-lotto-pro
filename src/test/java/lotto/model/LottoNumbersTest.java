package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void instantiate_6개_성공() {
        final List<LottoNumber> lottoNumberList = generateLottoNumberListOf(6);
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 10})
    void instantiate_실패(int count) {
        final List<LottoNumber> lottoNumberList = generateLottoNumberListOf(count);
        assertThatThrownBy(() -> new LottoNumbers(lottoNumberList))
                .isInstanceOf(RuntimeException.class);
    }

    private List<LottoNumber> generateLottoNumberListOf(int count) {
        final List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        return lottoNumberList;
    }
}

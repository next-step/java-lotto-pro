package study.step4.helper;

import org.junit.jupiter.api.Test;
import study.step4.models.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    void 섞여있는_숫자_리스트_반환_1부터_45까지() {
        List<LottoNumber> lottoNumbers = LottoNumbers.shuffledLottoNumbers();

        assertThat(lottoNumbers).hasSize(45);
    }

    private List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}

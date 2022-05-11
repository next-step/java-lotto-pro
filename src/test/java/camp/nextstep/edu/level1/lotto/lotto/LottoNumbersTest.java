package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumbersTest {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    @Test
    void 로또_번호_생성_시_1_에서_45_사이의_숫자가_6개_만들어져야_한다() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] splitResult = lottoNumbers.toString()
                .substring(1, lottoNumbers.toString().length() - 1)
                .split(",");
        IntStream numbers = Arrays.stream(splitResult).mapToInt(value -> Integer.parseInt(value.trim()));

        numbers.forEach(number -> assertThat(number).isBetween(LOTTO_START_NUMBER, LOTTO_END_NUMBER));
    }
}
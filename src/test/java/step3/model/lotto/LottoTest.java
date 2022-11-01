package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class LottoTest {
    private List<LottoNumber> changeToLottoNumbers(List<Integer> numbers){
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
    @Test
    void 정상_생성_프린트_검증() {
        Lotto lotto = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "7:false", "8:false"}, delimiter = ':')
    void 로또_번호_포함_테스트(int number, boolean result) {
        Lotto lotto = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto.isMatched(new LottoNumber(number))).isEqualTo(result);
    }



}
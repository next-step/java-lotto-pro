package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {

    @DisplayName("1부터45까지 숫자를 가지고 있다.")
    @Test
    void createTest() {
        assertThat(new LottoNumbers()).isEqualTo(new LottoNumbers(defaultLottoNumbers()));
    }

    @DisplayName("섞는 방법은 입력받아서 로또를 추출한다.")
    @Test
    void extractTest() {
        Lotto lotto = new LottoNumbers().extract((lottoNumbers)->{});
        assertThat(lotto).isEqualTo(new Lotto(LottoTest.createLottoNumberList(new int[]{1,2,3,4,5,6})));
    }

    private List<LottoNumber> defaultLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i=1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}

package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {

    @DisplayName("1부터45까지 숫자를 가지고 있다.")
    @Test
    void createTest() {
        assertThat(new LottoNumbers().isContains(new LottoNumber(3))).isTrue();
    }

    @DisplayName("섞는 방법은 입력받아서 로또를 추출한다.")
    @Test
    void extractTest() {
        Lotto lotto = new LottoNumbers().extract((lottoNumbers)->{});
        assertThat(lotto).isEqualTo(new Lotto(LottoTest.createLottoNumberList(new int[]{1,2,3,4,5,6})));
    }
}

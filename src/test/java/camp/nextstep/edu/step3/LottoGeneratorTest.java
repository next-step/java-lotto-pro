package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGeneratorTest {

    @DisplayName("6개 숫자를 가진 Lotto 를 요청한 만큼 자동으로 생성한다")
    @Test
    void autoTest() {
        Lotto[] lottoArray = new LottoGenerator().auto(5);
        assertThat(lottoArray.length).isEqualTo(5);
    }

    @DisplayName("Lotto 를 수동으로 생성한다.")
    @Test
    void manualTest() {
        assertThat(new LottoGenerator().manual(new int[] {1,2,3,4,5,6}))
                .isEqualTo(new Lotto(LottoTest.createLottoNumberArray(new int[] {1,2,3,4,5,6})));
    }

    @DisplayName("Lotto 수동 생성시 중복숫자 입력시 에러를 발생한다.")
    @Test
    void distinctTest() {
        assertThatThrownBy(() -> new LottoGenerator().manual(new int[] {1,2,3,4,5,5}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

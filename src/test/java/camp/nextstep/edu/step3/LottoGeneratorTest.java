package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGeneratorTest {

    @DisplayName("6개 숫자를 가진 Lotto 를 요청한 만큼 자동으로 생성한다")
    @Test
    void autoTest() {

        assertThat(new LottoGenerator(testLottoNumbers()).auto())
                .isEqualTo(new Lotto(LottoTest.createLottoNumberList(new int[] {1,2,3,4,5,6})));
    }

    @DisplayName("Lotto 를 수동으로 생성한다.")
    @Test
    void manualTest() {
        assertThat(new LottoGenerator().manual(new int[] {1,2,3,4,5,6}))
                .isEqualTo(new Lotto(LottoTest.createLottoNumberList(new int[] {1,2,3,4,5,6})));
    }

    @DisplayName("Lotto 수동 생성시 중복숫자 입력시 에러를 발생한다.")
    @Test
    void distinctTest() {
        assertThatThrownBy(() -> new LottoGenerator().manual(new int[] {1,2,3,4,5,5}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static LottoNumbers testLottoNumbers() {
        return new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }
}

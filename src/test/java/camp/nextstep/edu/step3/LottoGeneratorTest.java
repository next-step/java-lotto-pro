package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;

public class LottoGeneratorTest {

    @DisplayName("6개 숫자를 가진 Lotto 를 요청한 만큼 자동으로 생성한다")
    @Test
    void autoTest() {
        LottoNumbers spyLottoNumbers = spy(new LottoNumbers());
        Mockito.doReturn(createLottoNumberList(new int[] {1,2,3,4,5,6})).when(spyLottoNumbers).extract(any());
        assertThat(new LottoGenerator(spyLottoNumbers).auto())
                .isEqualTo(new Lotto(createLottoNumberList(new int[] {1,2,3,4,5,6})));
    }

    @DisplayName("Lotto 를 수동으로 생성한다.")
    @Test
    void manualTest() {
        assertThat(new LottoGenerator().manual(createLottoNumberList(new int[] {1,2,3,4,5,6})))
                .isEqualTo(new Lotto(createLottoNumberList(new int[] {1,2,3,4,5,6})));
    }

    @DisplayName("Lotto 수동 생성시 중복숫자 입력시 에러를 발생한다.")
    @Test
    void distinctTest() {
        assertThatThrownBy(() -> new LottoGenerator().manual(createLottoNumberList(new int[] {1,2,3,4,5,5})))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

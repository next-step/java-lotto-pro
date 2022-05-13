package camp.nextstep.edu.step3;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoPaperTest {
    private Lotto[] basicLottoArray;
    @BeforeEach
    void setUp() {
        basicLottoArray = Arrays.array(
                new Lotto(LottoTest.createLottoNumberArray(new int[] {1,2,3,4,5,6})),
                new Lotto(LottoTest.createLottoNumberArray(new int[] {1,2,3,4,5,7}))
        );
    }

    @DisplayName("생성시 Lotto[] 를 입력 받는다.")
    @Test
    void createTest() {

        assertThat(new LottoPaper(basicLottoArray)).isEqualTo(new LottoPaper(basicLottoArray));
    }

    @DisplayName("생성시 입력값 이 잘못된 경우 RuntimeException 을 던지다.")
    @Test
    void invalidInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper((Lotto[]) null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(Collections.emptyList().toArray(new Lotto[0])));
    }

    @DisplayName("당첨번호 인 Lotto 를 입력하고 결과로 Total 를 반환한다.")
    @Test
    void checkAllTest() {
        Lotto result = new Lotto(LottoTest.createLottoNumberArray(new int[] {1,2,3,10,11,12}));
        assertThat(new LottoPaper(basicLottoArray).checkAll(result)).isEqualTo(new Total(Hit.THREE, Hit.THREE));
    }
}

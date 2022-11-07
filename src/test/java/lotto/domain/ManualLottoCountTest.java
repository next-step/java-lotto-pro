package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottoCountTest {

    @Test
    @DisplayName("수동 로또 구매 갯수는 숫자 외의 값이 올 수 없다.")
    void onlyNumberTest(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoCount.create("열장", 10)
        );
    }

    @Test
    @DisplayName("수동 로또 구매 갯수는 총 구매로또의 갯수를 넘을 수 없다.")
    void notGreaterTotalLottoCountTest(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoCount.create("11", 10)
        );
    }

    @Test
    @DisplayName("구매 갯수를 확인한다.")
    void getLottoCount(){
        ManualLottoCount count = ManualLottoCount.create("3", 10);
        assertThat(count.getCount()).isEqualTo(3);
    }
}

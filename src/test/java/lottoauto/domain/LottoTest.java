package lottoauto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("당첨 번호와 구매 번호가 몇개 맞았는지 확인한다.")
    void 당첨_구매_비교(){
        Lotto win = Lotto.create(Arrays.asList(5,15,25,35,45,30));
        Lotto buy = Lotto.create(Arrays.asList(1,10,15,20,25,30));

        assertAll(
                () -> assertThat(win.getContainNumberCount(buy)).isEqualTo(3),
                () -> assertThat(buy.getContainNumberCount(win)).isEqualTo(3)
        );
    }

}

package step3.lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:58 오후
 */
@DisplayName("Utils:LottoNumberUtils")
class LottoNumberUtilsTest {

    @Test
    @DisplayName("중복 없는 6자리의 난수 생성 검증")
    public void notDuplicatedRandomNumberAssertions() {
        // When & Then
        assertThat(new HashSet<>(LottoNumberUtils.generateLottoNumbers())).hasSize(6);
    }
}

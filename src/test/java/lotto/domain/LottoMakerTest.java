package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : LottoMakerTest
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LottoMakerTest {

    @Test
    @DisplayName("랜덤로또 생성기 테스트")
    public void T01_create() {
        assertThat(LottoMaker.createLotto()).isInstanceOf(Lotto.class);
    }

}

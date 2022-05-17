package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGroupsTest {
    @Test
    @DisplayName("여러 장의 로또를 생성한다.")
    void generate_test() {
        LottoGroups lottoGroups = new LottoGroups();
        lottoGroups.generateLottoGroupsByPolicy(new AutoGeneratePolicy(), LottoCount.from(2));
        assertThat(lottoGroups.size()).isEqualTo(2);
    }
}

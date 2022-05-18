package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGroupsTest {
    @Test
    @DisplayName("자동으로 여러 장의 로또를 생성한다.")
    void generate_test() {
        LottoGroups lottoGroups = new LottoGroups();
        lottoGroups.generateLottoGroupsByPolicy(new AutoGeneratePolicy(), LottoCount.from(2));
        assertThat(lottoGroups.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동으로 여러 장의 로또를 생성한다.")
    void manual_generate_test() {
        LottoGroups lottoGroups = new LottoGroups();
        List<String> manualLottoGroups = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        lottoGroups.generateLottoGroupsByPolicy(new ManualGeneratePolicy(manualLottoGroups), LottoCount.from(2));
        assertThat(lottoGroups.size()).isEqualTo(2);
    }
}

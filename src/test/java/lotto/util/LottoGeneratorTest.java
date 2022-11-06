package lotto.util;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("수동 로또 생성 갯수 테스트")
    public void createUserWrittenLottosTest() {
        List<List<Integer>> userWrittenLottos = new ArrayList<>();
        userWrittenLottos.add(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        userWrittenLottos.add(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        assertThat(LottoGenerator.createUserWrittenLottos(userWrittenLottos)
                .getLottos()
                .size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동 로또 생성 갯수 테스트")
    public void createAutoLottosTest() {
        Lottos autoLottos = LottoGenerator.createAutoLottos(3);
        assertThat(autoLottos.getLottos().size()).isEqualTo(3);
    }
}
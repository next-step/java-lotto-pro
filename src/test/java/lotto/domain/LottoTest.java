package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("적중 로또번호 갯수 테스트")
    public void countCollectNumber() {
        List<Integer> lottoNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList());
        List<Integer> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList());
        int collectNumberCount = new Lotto(lottoNumbers).countCollectNumber(new Lotto(winningNumbers));
        assertThat(collectNumberCount).isEqualTo(6);

        List<Integer> winningNumbers2 = Arrays.stream(new int[]{1, 2, 3, 11, 22, 33}).boxed().collect(Collectors.toList());
        int collectNumberCount2 = new Lotto(lottoNumbers).countCollectNumber(new Lotto(winningNumbers2));
        assertThat(collectNumberCount2).isEqualTo(3);
    }
}

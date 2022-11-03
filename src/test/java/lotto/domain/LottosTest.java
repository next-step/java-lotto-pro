package lotto.domain;

import lotto.constants.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또숫자 적중 결과 테스트, 2등 1개 당첨 테스트")
    public void findWinnerTest() {
        Lotto lotto = Lotto.of(Arrays.stream(new int[]{1, 2, 3, 4, 5, 45}).boxed().collect(Collectors.toList()));
        Lotto winningNums = Lotto.of(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        LottoNumber bonusBall = new LottoNumber(45);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        Lottos lottos = new Lottos(lottoList);
        LottoResult lottoResult = lottos.findWinner(winningNums, bonusBall);
        assertThat(lottoResult.getLottoResult().get(Rank.SECOND)).isGreaterThan(0);
    }
}
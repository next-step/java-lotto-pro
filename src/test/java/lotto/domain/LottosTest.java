package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("Lottos 개수 정상 생성")
    public void Lottos_정상생성() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 6, 10, 20, 34, 45));
        lottos.add(new Lotto(numbers));
        Lottos lottosList = new Lottos(lottos);
        assertThat(lottosList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동 구매 개수에 맞는 Lotto 개수 생성")
    public void Lottos_자동구매_정상생성() {
        assertThat(Lottos.buyAutoLottos(6).size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동 Lotto 와 자동 Lotto merge Lotto 개수 생성")
    public void Lottos_수동_Lotto_자동_Lotto_정상생성() {
        Lottos autoLottos = Lottos.buyAutoLottos(6);
        List<Lotto> manualLottoList = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 6, 10, 20, 34, 45));
        manualLottoList.add(new Lotto(numbers));
        Lottos manualLottos = new Lottos(manualLottoList);
        assertThat(Lottos.mergeLottos(manualLottos,autoLottos).size()).isEqualTo(7);
    }

}

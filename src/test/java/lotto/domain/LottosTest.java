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
    @DisplayName("구매 개수에 맞는 Lotto 개수 생성")
    public void Lottos_구매_정상생성() {
        assertThat(Lottos.buyLottos(6).size()).isEqualTo(6);
    }

}

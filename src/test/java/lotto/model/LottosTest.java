package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    @DisplayName("자동 생성 로또 테스트")
    @Test
    void creator() {
        Lottos lottos = new Lottos(5);
        assertEquals(5, lottos.getQuantity());
    }

    @DisplayName("5개의 로또의 결과를 구하면 5개의 결과를 응답한다.")
    @Test
    void getResults() {
        Lottos lottos = new Lottos(5);
        List<Result> results = lottos.getResults(new Lotto(), new LottoNumber(1));
        assertEquals(5, results.size());
    }

    @DisplayName("수동 생성 로또 테스트")
    @Test
    void creator_manual() {
        List<Lotto> lottoList = Arrays.asList(new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6)));
        Lottos manualLottos = new Lottos(lottoList);
        assertEquals(1, manualLottos.getQuantity());
    }

    @DisplayName("두 로또들을 하나로 합친다.")
    @Test
    void add() {
        Lottos firstLottos = new Lottos(3);
        Lottos secondLottos = new Lottos(4);
        Lottos lotto = firstLottos.add(secondLottos);
        assertEquals(7, lotto.getQuantity());
    }

    private List<LottoNumber> getLottoNumbers(int first, int second, int third, int fourth, int fifth, int sixth) {
        return Arrays.asList(new LottoNumber(first), new LottoNumber(second), new LottoNumber(third), new LottoNumber(fourth),
                new LottoNumber(fifth), new LottoNumber(sixth));
    }
}
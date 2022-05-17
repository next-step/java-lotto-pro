package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("Lottos 생성시 입력한 만큼의 lotto 를 가지고 있는지 확인")
    @Test
    void sizeLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        LottoNumberPool pool = new LottoNumberPool();

        for (int i = 0; i < 5; i++) {
            lottoList.add(pool.generateLotto());
        }

        assertThat(new Lottos(lottoList).size()).isEqualTo(5);
    }

    @DisplayName("입력한 로또 번호셋을 get으로 가져와 동일한 것인지 확인")
    @Test
    void getLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        LottoNumberPool pool = new LottoNumberPool();

        Lotto inputLotto = pool.generateLotto();
        lottoList.add(inputLotto);

        Lottos lottos = new Lottos(lottoList);
        Lotto outputLotto = lottos.get(0);

        assertThat(inputLotto.size() == outputLotto.size()).isTrue();

        for (int i = 0; i < inputLotto.size(); i++) {
            assertThat(inputLotto.get(i).equals(outputLotto.get(i))).isTrue();
        }
    }

    @DisplayName("1등 로또 결과가 정상적으로 도출되는지 확인")
    @Test
    void matchWithReferenceFirst() {
        Lotto referenceLotto = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));

        Lotto firstLotto = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));
        Lottos lottos = new Lottos(Collections.singletonList(firstLotto));
        LottosResults results = lottos.matchWithReference(referenceLotto);

        assertThat(results.getRankCount(LottoRank.FIRST)) .isEqualTo(1);


        Lotto thirdLotto_1 = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 33).map(LottoNumber::new).collect(Collectors.toList()));
        Lotto thirdLotto_2 = new Lotto(
                Stream.of(1, 5, 2, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));

        Lotto fourthLotto = new Lotto(
                Stream.of(1, 5, 3, 12, 20, 29).map(LottoNumber::new).collect(Collectors.toList()));

        Lotto fifthLo = new Lotto(
                Stream.of(1, 5, 3, 12, 20, 29).map(LottoNumber::new).collect(Collectors.toList()));


    }

    @DisplayName("3등 로또 결과가 정상적으로 도출되는지 확인")
    @Test
    void matchWithReferenceThird() {
        Lotto referenceLotto = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));

        Lotto thirdLotto_1 = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 33).map(LottoNumber::new).collect(Collectors.toList()));
        Lotto thirdLotto_2 = new Lotto(
                Stream.of(1, 5, 2, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));
        Lottos lottos = new Lottos(Arrays.asList(thirdLotto_1, thirdLotto_2));
        LottosResults results = lottos.matchWithReference(referenceLotto);

        assertThat(results.getRankCount(LottoRank.THIRD)) .isEqualTo(2);
    }

    @DisplayName("4등 로또 결과가 정상적으로 도출되는지 확인")
    @Test
    void matchWithReferenceFourth() {
        Lotto referenceLotto = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));

        Lotto fourthLotto = new Lotto(
                Stream.of(1, 5, 3, 12, 20, 29).map(LottoNumber::new).collect(Collectors.toList()));

        Lottos lottos = new Lottos(Collections.singletonList(fourthLotto));
        LottosResults results = lottos.matchWithReference(referenceLotto);

        assertThat(results.getRankCount(LottoRank.FOURTH)) .isEqualTo(1);
    }

    @DisplayName("꽝 로또 결과가 정상적으로 도출되는지 확인")
    @Test
    void matchWithReferenceMiss() {
        Lotto referenceLotto = new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40).map(LottoNumber::new).collect(Collectors.toList()));

        Lotto missLotto_zero = new Lotto(
                Stream.of(2, 3, 11, 15, 23, 30).map(LottoNumber::new).collect(Collectors.toList()));
        Lotto missLotto_one = new Lotto(
                Stream.of(2, 5, 11, 15, 23, 30).map(LottoNumber::new).collect(Collectors.toList()));
        Lotto missLotto_two = new Lotto(
                Stream.of(2, 5, 11, 15, 23, 40).map(LottoNumber::new).collect(Collectors.toList()));

        Lottos lottos = new Lottos(Arrays.asList(missLotto_zero, missLotto_one, missLotto_two));
        LottosResults results = lottos.matchWithReference(referenceLotto);

        assertThat(results.getRankCount(LottoRank.MISS)) .isEqualTo(3);
    }
}
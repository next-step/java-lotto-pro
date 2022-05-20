package lotto_auto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class LottosTest {
    @Test
    void 외부에서_로또_추가_시_에러_발생() {
        LottoNumbers numbers = new LottoNumbers(IntStream
                .rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));

        Lottos lottos = new Lottos(Arrays.asList(new Lotto(numbers),
                new Lotto(numbers)));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> lottos.getLottoList().add(new Lotto(numbers)));
    }

    @Test
    void 머지_매치() {
        LottoNumbers lottoNumbers = new LottoNumbers(IntStream
                .rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));

        LottoNumbers otherNumbers = new LottoNumbers(IntStream
                .rangeClosed(7, 12)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));

        Lottos lottos = new Lottos(Arrays.asList(new Lotto(lottoNumbers)));
        Lottos otherLottos = new Lottos(Arrays.asList(new Lotto(otherNumbers)));

        Lottos mergedLottos = lottos.merge(otherLottos);

        assertThat(getLottoToString(mergedLottos.getLottoList().get(0))).isEqualTo("1, 2, 3, 4, 5, 6");
        assertThat(getLottoToString(mergedLottos.getLottoList().get(1))).isEqualTo("7, 8, 9, 10, 11, 12");
        assertThat(mergedLottos.getLottoList().size()).isEqualTo(2);
    }

    @Test
    void 당첨된_로또들_결과_체크() {
        LottoNumbers otherNumbers = new LottoNumbers(IntStream
                .rangeClosed(7, 12)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        WinningLotto winningLotto = new WinningLotto(new Lotto(otherNumbers), new LottoNumber(1));
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(otherNumbers)));

        Figures result = lottos.matchedLottos(winningLotto);
        assertThat(result.getCountBy(LottoRank.FIRST)).isEqualTo(1);

    }

    private String getLottoToString(Lotto lotto) {
        return lotto.getLottoNumbers().getLottoNumberSet().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .collect(Collectors.joining(", "));
    }
}

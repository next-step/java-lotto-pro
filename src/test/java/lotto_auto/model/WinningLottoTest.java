package lotto_auto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningLottoTest {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setup() {
        this.lottoNumbers = new LottoNumbers(IntStream
                .rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    @Test
    void 보너스볼_중복_넘버_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto(new Lotto(lottoNumbers), new LottoNumber(1)))
                .withMessage(LottoNumbers.EXIST_DUPLICATE_VALUE);
    }

    @Test
    void 로또_비교후_결과_랭크() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6)));

        Lotto lotto = new Lotto(new LottoNumbers(lottoNumberSet));
        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));

        assertThat(winningLotto.matches(lotto)).isEqualTo(LottoRank.FIRST);
    }
}

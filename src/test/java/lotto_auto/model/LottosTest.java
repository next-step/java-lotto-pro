package lotto_auto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottosTest {
    @Test
    void 외부에서_로또_추가_시_에러_발생() {
        LottoNumbers numbers = new LottoNumbers(IntStream
                .rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Lottos lottos = new Lottos(Arrays.asList(new Lotto(numbers),
                new Lotto(numbers)));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> lottos.getLottoList().add(new Lotto(numbers)));
    }
}

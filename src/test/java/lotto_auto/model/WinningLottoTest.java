package lotto_auto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningLottoTest {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setup() {
        this.lottoNumbers = new LottoNumbers(IntStream
                .rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    @Test
    void 보너스볼_중복_넘버_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto(lottoNumbers, new LottoNumber(1)))
                .withMessage(LottoNumbers.EXIST_DUPLICATE_VALUE);
    }
}

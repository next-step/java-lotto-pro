package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    @DisplayName("생성자의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void createByNull() {
        assertThatNullPointerException().isThrownBy(() ->
            new LottoNumberGenerator(null)
        );
    }

    @Test
    @DisplayName("구매금액에 맞는 갯수의 로또번호들을 반환하는지 테스트")
    void generate() {
        Payment payment = new Payment(14000);

        Collection<LottoNumbers> lottoNumbers = new LottoNumberGenerator(payment).generate();

        assertThat(lottoNumbers).hasSize(14000 / Payment.LOTTO_PRICE);
    }
}

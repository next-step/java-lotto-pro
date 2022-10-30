package lotto.domain.lottonumber.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberFactoryImplTest {

    LottoNumberFactory factory = new LottoNumberFactoryImpl();

    @Test
    @DisplayName("로또 번호는 랜덤으로 생성되어야 함")
    void isRandom() {
        assertThat(factory.createLottoNumber().toString())
                .isNotEqualTo((factory.createLottoNumber().toString()));
    }
}

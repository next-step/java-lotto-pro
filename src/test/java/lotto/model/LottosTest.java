package lotto.model;

import lotto.factory.LottoCreateFactory;
import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    @DisplayName("갯수를 입력받아 로또를 여러개 생성하는 기능 검증")
    @Test
    void createLottosFromFactory() {
        lottos = LottoCreateFactory.createLottos(20);
        assertThat(lottos.size()).isEqualTo(20);
    }
}

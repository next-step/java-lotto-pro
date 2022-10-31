package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("로또 게임 테스트")
class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void init() {
        lottoGame = new LottoGame();
    }

}
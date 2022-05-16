package lotto.model.winning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 생성_테스트() {
        WinningLotto winningLotto = new WinningLotto(new String[]{"1", "2", "3", "4", "5", "6"});
        assertEquals(winningLotto, new WinningLotto(new String[]{"1", "2", "3", "4", "5", "6"}));
    }

}

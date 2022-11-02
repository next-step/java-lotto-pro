package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoWinningMoneyTest {
    Map<Integer, Integer> resultAll;
    Map<Integer, Integer> resultOnlyThree;

    @BeforeEach
    void beforeEach(){
        resultAll = new HashMap<Integer, Integer>(){{
            put(3, 1);
            put(4, 1);
            put(5, 1);
            put(6, 1);
        }};

        resultOnlyThree =  new HashMap<Integer, Integer>(){{
            put(3, 3);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};
    }

    @Test
    @DisplayName("전체 당첨금을 계산한다.")
    void 당첨금_계산(){
        assertThat(new LottoWinningMoney().calculateWinningMoney(resultAll))
                .isEqualTo(2001555000);
    }

    @Test
    @DisplayName("3개 맞은 로또의 당첨금을 계산한다.")
    void _3개_맞은_당첨금_계산(){
        assertThat(new LottoWinningMoney().calculateWinningMoney(resultOnlyThree))
                .isEqualTo(15000);
    }
}

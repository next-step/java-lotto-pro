package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoWinningMoneyTest {
    LottoResult resultAll;
    LottoResult resultOnlyThree;

    @BeforeEach
    void beforeEach(){
        resultAll = new LottoResult(new HashMap<Integer, List<Lotto>>(){{
            put(3, Arrays.asList(Lotto.create(Arrays.asList(1,2,3,4,5,6))));
            put(4, Arrays.asList(Lotto.create(Arrays.asList(1,2,3,4,5,6))));
            put(5, Arrays.asList(Lotto.create(Arrays.asList(1,2,3,4,5,6))));
            put(6, Arrays.asList(Lotto.create(Arrays.asList(1,2,3,4,5,6))));
        }});

        resultOnlyThree =  new LottoResult(new HashMap<Integer, List<Lotto>>(){{
            put(3, Arrays.asList(Lotto.create(Arrays.asList(1,2,3,4,5,6))
                                ,Lotto.create(Arrays.asList(1,2,3,4,5,6))
                                ,Lotto.create(Arrays.asList(1,2,3,4,5,6))));
        }});
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

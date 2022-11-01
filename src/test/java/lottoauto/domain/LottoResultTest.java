package lottoauto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoResultTest {
    Lotto win;
    @BeforeEach
    void beforeEach(){
        win = Lotto.create(Arrays.asList(5,15,25,35,45,30));
    }

    @Test
    @DisplayName("3개 당첨 결과 저장하고 조회하기")
    void _3개_당첨_결과_저장_조회(){
        Lotto buy = Lotto.create(Arrays.asList(1,10,15,20,25,30));

        LottoResult result = new LottoResult();
        result.addLottoResult(win.getContainNumberCount(buy), buy);

        assertThat(result.getResultCount(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("4개 당첨 결과 저장하고 조회하기")
    void _4개_당첨_결과_저장_조회(){
        Lotto buy = Lotto.create(Arrays.asList(5,10,15,20,25,30));

        LottoResult result = new LottoResult();
        result.addLottoResult(win.getContainNumberCount(buy), buy);

        assertThat(result.getResultCount(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 당첨 결과 저장하고 조회하기")
    void _5개_당첨_결과_저장_조회(){
        Lotto buy = Lotto.create(Arrays.asList(5,45,15,20,25,30));

        LottoResult result = new LottoResult();
        result.addLottoResult(win.getContainNumberCount(buy), buy);

        assertThat(result.getResultCount(5)).isEqualTo(1);
    }

    @Test
    @DisplayName("6개 당첨 결과 저장하고 조회하기")
    void _6개_당첨_결과_저장_조회(){
        Lotto buy = Lotto.create(Arrays.asList(35,45,30,5,15,25));

        LottoResult result = new LottoResult();
        result.addLottoResult(win.getContainNumberCount(buy), buy);

        assertThat(result.getResultCount(6)).isEqualTo(1);
    }

    @Test
    @DisplayName("0,1,2 개 당첨 결과는 저장하지 않는다.")
    void _0개_당첨_결과_미저장(){
        Lotto buy0 = Lotto.create(Arrays.asList(34,44,29,4,14,24));
        Lotto buy1 = Lotto.create(Arrays.asList(34,45,29,4,14,24));
        Lotto buy2 = Lotto.create(Arrays.asList(34,45,29,4,15,24));

        LottoResult result = new LottoResult();
        result.addLottoResult(win.getContainNumberCount(buy0), buy0);
        result.addLottoResult(win.getContainNumberCount(buy1), buy1);
        result.addLottoResult(win.getContainNumberCount(buy2), buy2);

        assertAll(
                () -> assertThat(result.getResultCount(0)).isEqualTo(0),
                () -> assertThat(result.getResultCount(1)).isEqualTo(0),
                () -> assertThat(result.getResultCount(2)).isEqualTo(0)
        );
    }
}

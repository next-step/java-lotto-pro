package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoResult.PRIZE_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private final LottoResult lottoResult;
    private final int collectNumberCnt = 3;

    LottoResultTest(){
        int lottoAmount = 5;
        lottoResult = new LottoResult(lottoAmount);
    }

    @Test
    @DisplayName("적중한갯수가 총 몇개인지 리턴하는 테스트 (ex: 3개 적중한 로또 1개일 경우 1리턴)")
    public void lottoResultTest(){
        lottoResult.putLottoResult(collectNumberCnt);
        assertThat(lottoResult.getLottoResult(collectNumberCnt)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    public void calculateProfitRatio(){
        lottoResult.putLottoResult(collectNumberCnt);
        double actualProfitRatio = lottoResult.calculateProfitRatio();
        double expected = Math.floor(1.0);
        assertThat(actualProfitRatio).isEqualTo(expected);
    }
}
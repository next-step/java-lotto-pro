package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("적중한갯수가 총 몇개인지 리턴하는 테스트 (ex: 3개 적중한 로또 1개일 경우 1리턴)")
    public void lottoResultTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.putLottoResult(3);
        assertThat(lottoResult.getLottoResult(3)).isEqualTo(1);
    }
}
package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.NormalLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoWinTest {

    private LottoNumbers lottoNumbers;
    @BeforeEach
    void setUp(){
        lottoNumbers = new NormalLottoNumbers();
        lottoNumbers.add(new LottoNumber("1"));
        lottoNumbers.add(new LottoNumber("2"));
        lottoNumbers.add(new LottoNumber("3"));
        lottoNumbers.add(new LottoNumber("4"));
        lottoNumbers.add(new LottoNumber("5"));
        lottoNumbers.add(new LottoNumber("6"));
    }
    @Test
    void 당첨여부_테스트(){

    }
}

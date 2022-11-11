package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.Rank;

public class LottoMachineTest {    
    LottoMachine lottoMachine;
    Lotto winningTicket = new Lotto("1,2,3,4,5,6", "7");
    
    @BeforeEach
    public void initTest() {
        lottoMachine = new LottoMachine(new Money("14000"));
    }
    
    @Test
    @DisplayName("구입금액에_따른_발급로또_개수_확인")
    public void lotto_issue_count() {
        assertThat(lottoMachine.buyLottoAuto(0)).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6':0"
                        , "'1,2,3,4,5,7':1"
                        , "'1,2,3,4,5,8':2"
                        , "'1,2,3,4,7,8':3"
                        , "'1,2,3,7,8,9':4"
                        }, delimiter = ':')
    @DisplayName("사용자_입력값과_로또_비교하여_결과_출력")
    public void lotto_get_result(String lottoNumber, int index) {
        lottoMachine.buyLottoManual(lottoNumber);
        assertThat(lottoMachine.getResult(winningTicket).winningMap.get(Rank.values()[index])).isEqualTo(1);
    }  
    
    @Test
    @DisplayName("사용자 입력값과 로또 비교하여 수익률 체크")
    public void lotto_get_return_rate() {
        lottoMachine.buyLottoManual("8, 21, 23, 41, 42, 43");
        lottoMachine.buyLottoManual("3, 5, 11, 16, 32, 38");
        lottoMachine.buyLottoManual("7, 11, 16, 35, 36, 44");
        lottoMachine.buyLottoManual("1, 8, 11, 31, 41, 42");
        lottoMachine.buyLottoManual("13, 14, 16, 38, 42, 45");
        lottoMachine.buyLottoManual("7, 11, 30, 40, 42, 43");
        lottoMachine.buyLottoManual("2, 13, 22, 32, 38, 45");
        lottoMachine.buyLottoManual("23, 25, 33, 36, 39, 41");
        lottoMachine.buyLottoManual("1, 3, 5, 14, 22, 45");
        lottoMachine.buyLottoManual("5, 9, 38, 41, 43, 44");
        lottoMachine.buyLottoManual("2, 8, 9, 18, 19, 21");
        lottoMachine.buyLottoManual("13, 14, 18, 21, 23, 35");
        lottoMachine.buyLottoManual("17, 21, 29, 37, 42, 45");
        lottoMachine.buyLottoManual("3, 8, 27, 30, 35, 44");
        
        assertThat(lottoMachine.getResult(winningTicket).returnRate).isEqualTo(0.35);
    } 
}

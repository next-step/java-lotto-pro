package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.Amount;
import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoRanks;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoRankDto;
import step3.dto.LottoRanksDto;

public class LottoRanksDtoTest {

    // @Test
    // @DisplayName("'3개 일치 (5000원)- 1개' 메시지 출력 테스트")
    // void lottoRanksDtoTest() {
    //     // given
    //     int[] winNumbers = {10, 20, 30, 1, 2, 3};
    //     Amount amount = new Amount(10000); // 주문가격
    //     NumbersStrategy winnerLottoNumbers = generateNumberStrategy(winNumbers);
    //     LottoNumbersBundle lottoNumbersBundle = getLottoNumbersBundle(); // 3개 일치 - 로또티켓 일치 갯수 1개 생성
    //     LottoNumbers winLottoNumbers = new LottoNumbers(winnerLottoNumbers.getNumbers()); // 지난주 우승 로또 번호
    //     LottoRanks lottoRanks = lottoNumbersBundle.lottoRanksOf(winLottoNumbers); // 랭킹 비교
    //
    //     // then
    //     LottoRanksDto lottoRanksDto = LottoRanksDto.of(lottoRanks, amount); // 출력 DTO 생성
    //
    //     // then
    //     LottoRankDto lottoRankDto = new LottoRankDto(1, 3, 5000L);
    //     assertThat(lottoRanksDto.toString().contains(lottoRankDto.toString())).isTrue();
    // }

    private LottoNumbersBundle getLottoNumbersBundle() {
        LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();
        lottoNumbersBundle.addLottoNumbers(generateNumberStrategy(new int[] {1, 2, 3, 4, 5, 6}));
        lottoNumbersBundle.addLottoNumbers(new RandomLottoNumbers());
        lottoNumbersBundle.addLottoNumbers(new RandomLottoNumbers());
        return lottoNumbersBundle;
    }

    private NumbersStrategy generateNumberStrategy(int[] numbers) {
        return new NumbersStrategy() {
            @Override
            public int[] getNumbers() {
                return numbers;
            }
        };
    }

}

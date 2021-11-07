package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import step3.domain.Amount;
import step3.domain.LottoRank;
import step3.domain.LottoService;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoBonusNumberRequestDto;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.dto.LottoWinNumbersRequestDto;
import step3.service.LottoServiceImpl;

public class LottoServiceImplTest {

    @ParameterizedTest
    @CsvSource(value = {
        "1000:1",
        "5000:5",
    }, delimiter = ':')
    @DisplayName("투자금에 맞는 로또 구매갯수 검증")
    void buyLotto_구매된_로또갯수(int amount, int expected) {
        // given
        LottoBuyRequestDto lottoBuyRequestDto = new LottoBuyRequestDto(amount); // 로또구매 금액 입력받기

        // when
        LottoService lottoService = new LottoServiceImpl();
        LottoBuyResponseDto lottoBuyResponseDto = lottoService.buyLotto(lottoBuyRequestDto,
            new RandomLottoNumbers());// 로또구매

        // then
        int buyLottoSize = lottoBuyResponseDto.getBuyLottoList().size(); // 구매된 로또 갯수
        assertThat(buyLottoSize).isEqualTo(expected); // 비교
    }

    @ParameterizedTest
    @MethodSource("getResultStatisticsGenerateData")
    @DisplayName("구입한 로또번호, 지난주 로또번호, 보너스번호를 입력받고, 로또출력(LottoResultDto) 리턴객체 일치 검증")
    void getResultStatistics(
        NumbersStrategy numbersStrategy,
        int[] winLottoNumbers,
        LottoBonusNumberRequestDto lottoBonusNumberRequestDto,
        LottoResultDto expectedLottoResultDto
    ) {
        // given
        Amount amount = new Amount(1000); // 한개에대한 테스트 이므로 1000 고정입니다.
        LottoBuyRequestDto lottoBuyRequestDto = new LottoBuyRequestDto(amount.getAmount());

        // when
        LottoService lottoService = new LottoServiceImpl();
        lottoService.buyLotto(lottoBuyRequestDto, numbersStrategy); // 로또 구매
        LottoWinNumbersRequestDto lottoWinNumbersRequestDto = new LottoWinNumbersRequestDto(winLottoNumbers,
            amount.getAmount()); // 지난주 로또번호 입력받기
        LottoStatisticsResponseDto lottoStatisticsResponseDto = lottoService.getResultStatistics(
            lottoWinNumbersRequestDto, lottoBonusNumberRequestDto); // 통계 결과 객체 리턴

        // then
        List<LottoResultDto> lottoResultDtos = lottoStatisticsResponseDto.getLottoResultDtos();
        assertThat(lottoResultDtos).contains(expectedLottoResultDto); // 예상 통계결과 객체 확인

    }

    private static Stream<Arguments> getResultStatisticsGenerateData() {
        return Stream.of(
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), // 구매될 로또 넘버 6자리
                parseNumbers("1,2,3,4,5,6"), // 지난 주 당첨 로또 번호
                new LottoBonusNumberRequestDto(45), // 보너스 번호
                new LottoResultDto(6, 2000000000, LottoRank.FIRST.name(), 1)), // 비교할 당첨 결과 비교 객체
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), parseNumbers("1,2,3,4,5,7"),
                new LottoBonusNumberRequestDto(45), new LottoResultDto(5, 1500000, LottoRank.THIRD.name(), 1)),
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), parseNumbers("1,2,3,4,5,7"),
                new LottoBonusNumberRequestDto(6), new LottoResultDto(5, 30000000, LottoRank.SECOND.name(), 1)),
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), parseNumbers("11,12,13,14,15,17"),
                new LottoBonusNumberRequestDto(6), new LottoResultDto(0, 0, LottoRank.NONE.name(), 1))
        );
    }

    private static NumbersStrategy getNumbersStrategy(String buyNumbersStr) {
        return new NumbersStrategy() {
            @Override
            public int[] getNumbers() {
                return parseNumbers(buyNumbersStr);
            }
        };
    }

    private static int[] parseNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}

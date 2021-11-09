package step3;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import step3.domain.LottoRank;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoResultDto;

public class LottoServiceImplTest {

    // Todo 수익률 계산은 LottoRanks로 이동함
    // @ParameterizedTest
    // @CsvSource(value = {
    //     "1000:1",
    //     "5000:5",
    // }, delimiter = ':')
    // @DisplayName("투자금에 맞는 로또 구매갯수 검증")
    // void buyLotto_구매된_로또갯수(int amount, int expected) {
    //     // given
    //     LottoBuyRequestDto lottoBuyRequestDto = new LottoBuyRequestDto(amount); // 로또구매 금액 입력받기
    //
    //     // when
    //     LottoService lottoService = new LottoServiceImpl();
    //     LottoBuyResponseDto lottoBuyResponseDto = lottoService.buyAutoLotto(lottoBuyRequestDto,
    //         new RandomLottoNumbers());// 로또구매
    //
    //     // then
    //     int buyLottoSize = lottoBuyResponseDto.getBuyLottoListToString().size(); // 구매된 로또 갯수
    //     assertThat(buyLottoSize).isEqualTo(expected); // 비교
    // }

    // Todo 다시 만들기
    // @ParameterizedTest
    // @MethodSource("getResultStatisticsGenerateData")
    // @DisplayName("구입한 로또번호, 지난주 로또번호, 보너스번호를 입력받고, 로또출력(LottoResultDto) 리턴객체 일치 검증")
    // void getResultStatistics(
    //     NumbersStrategy numbersStrategy,
    //     int[] winLottoNumbers,
    //     int bonusNumber,
    //     LottoResultDto expectedLottoResultDto
    // ) {
    //     // given
    //     int amount = 1000;
    //     LottoBuyRequestDto lottoBuyRequestDto = new LottoBuyRequestDto(amount);
    //
    //     // when
    //     LottoService lottoService = new LottoServiceImpl();
    //     LottoBuyResponseDto lottoBuyResponseDto = lottoService.buyLotto(lottoBuyRequestDto, numbersStrategy);
    //
    //     LottoStatisticsRequestDto lottoStatisticsRequestDto = new LottoStatisticsRequestDto();
    //
    //     WinningLotto winningLotto = WinningLotto.of(winLottoNumbers, bonusNumber);
    //     lottoStatisticsRequestDto.mapAmount(new Amount(amount));
    //     lottoStatisticsRequestDto.mapWinningLotto(winningLotto);
    //     lottoStatisticsRequestDto.mapBuyLottoList(lottoBuyResponseDto.getBuyLottoList());
    //
    //     LottoStatisticsResponseDto lottoStatisticsResponseDto = lottoService.getResultStatistics(
    //         lottoStatisticsRequestDto);
    //
    //     // then
    //     List<LottoResultDto> lottoResultDtos = lottoStatisticsResponseDto.getLottoResultDtos();
    //     assertThat(lottoResultDtos).contains(expectedLottoResultDto); // 예상 통계결과 객체 확인
    // }

    private static Stream<Arguments> getResultStatisticsGenerateData() {
        return Stream.of(
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), // 구매될 로또 넘버 6자리
                parseNumbers("1,2,3,4,5,6"), // 지난 주 당첨 로또 번호
                45, // 보너스 번호
                new LottoResultDto(6, 2000000000, LottoRank.FIRST.name(), 1)), // 비교할 당첨 결과 비교 객체
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), parseNumbers("1,2,3,4,5,7"),
                45, new LottoResultDto(5, 1500000, LottoRank.THIRD.name(), 1)),
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), parseNumbers("1,2,3,4,5,7"),
                6, new LottoResultDto(5, 30000000, LottoRank.SECOND.name(), 1)),
            Arguments.of(
                getNumbersStrategy("1,2,3,4,5,6"), parseNumbers("11,12,13,14,15,17"),
                6, new LottoResultDto(0, 0, LottoRank.NONE.name(), 1))
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

package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.LottoRank;
import step3.domain.LottoService;
import step3.domain.WinningLotto;
import step3.domain.strategy.numbers.ManualLottoNumbers;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.service.LottoServiceImpl;

public class LottoServiceImplTest {

    @ParameterizedTest
    @MethodSource("getResultStatisticsGenerateData")
    @DisplayName("구입한 로또번호, 지난주 로또번호, 보너스번호를 입력받고, 로또출력(LottoResultDto) 리턴객체 일치 검증")
    void getResultStatistics(
        List<NumbersStrategy> numbersStrategy,
        int[] winLottoNumbers,
        int bonusNumber,
        LottoResultDto expectedLottoResultDto
    ) {
        // given
        int amount = 2000;
        // when
        LottoService lottoService = new LottoServiceImpl();
        lottoService.registerBuyAmount(amount);
        lottoService.registerManualLottoBuy(numbersStrategy);
        lottoService.buyAutoLotto();
        lottoService.winningLottoNumber(new ManualLottoNumbers(winLottoNumbers), bonusNumber);

        LottoStatisticsResponseDto lottoStatisticsResponseDto = lottoService.resultStatistics();

        // then
        List<LottoResultDto> lottoResultDtos = lottoStatisticsResponseDto.getLottoResultDtos();
        assertThat(lottoResultDtos).contains(expectedLottoResultDto); // 예상 통계결과 객체 확인
    }

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
                6, new LottoResultDto(0, 0, LottoRank.NONE.name(), 2))
        );
    }

    private static List<NumbersStrategy> getNumbersStrategy(String buyNumbersStr) {
        List<NumbersStrategy> result = new ArrayList<>();
        result.add(new NumbersStrategy() {
            @Override
            public int[] getNumbers() {
                return parseNumbers(buyNumbersStr);
            }
        });
        return result;
    }

    private static int[] parseNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}

package step3.view;

import java.math.BigDecimal;
import java.util.List;

import step3.domain.Amount;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsResponseDto;

public class ResultView {
    public static final String BONUS_RANK_NAME = "SECOND";
    public static final String TITLE = "당첨 통계\n";
    public static final String DIVIDE = "---------\n";
    public static final String LOTTO_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s입니다";
    public static final String LOTTO_RANK_FORMAT = "%s개 일치 (%d원)- %d개";
    public static final String LOTTO_RANK_BONUS_SECOND_FORMAT = "%s개 일치, 보너스 볼 일치(%s원) - %s개";
    private static final String WINNER_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String BUY_COUNT_MESSAGE = "%d 개를 구매했습니다.";
    private static final String TOTAL_LOTTO_BUY_COUNT_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final BigDecimal LOSS = BigDecimal.valueOf(1);
    private static final Integer MIN_RANK_NUMBER = 3;

    private ResultView() {
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void amountRequestPrintln() {
        println(AMOUNT_REQUEST_MESSAGE);
    }

    public static void buyCountPrintln(int size) {
        println(String.format(BUY_COUNT_MESSAGE, size));
    }

    public static void winnerRequestPrintln() {
        println(WINNER_NUMBER_REQUEST_MESSAGE);
    }

    public static void lottoBuyListPrint(LottoBuyResponseDto manualLottoBuyResponseDto,
        LottoBuyResponseDto lottoBuyResponseDto) {

        println(String.format(
            TOTAL_LOTTO_BUY_COUNT_MESSAGE,
            manualLottoBuyResponseDto.size(),
            lottoBuyResponseDto.size()));

        printLottoNumbers(lottoBuyResponseDto);
        printLottoNumbers(manualLottoBuyResponseDto);

        buyCountPrintln(lottoBuyResponseDto.getBuyLottoListToString().size());
    }

    private static void printLottoNumbers(LottoBuyResponseDto lottoBuyResponseDto) {
        for (String numbers : lottoBuyResponseDto.getBuyLottoListToString()) {
            println(numbers);
        }
    }

    public static void statisticsPrint(LottoStatisticsResponseDto lottoStatisticsResponseDto, Amount amount) {
        List<LottoResultDto> lottoResultDtos = lottoStatisticsResponseDto.getLottoResultDtos();

        statisticsHeaderPrint();

        for (LottoResultDto lottoResultDto : lottoResultDtos) {
            lottoResultPrint(lottoResultDto);
        }

        yieldPrint(lottoStatisticsResponseDto.getYield(amount));
    }

    private static void statisticsHeaderPrint() {
        print(TITLE);
        print(DIVIDE);
    }

    private static void lottoResultPrint(LottoResultDto lottoResultDto) {
        String format = LOTTO_RANK_FORMAT;
        if (lottoResultDto.getRankName().equals(BONUS_RANK_NAME)) {
            format = LOTTO_RANK_BONUS_SECOND_FORMAT;
        }

        if (lottoResultDto.getMatchNumber() >= MIN_RANK_NUMBER) {
            println(String.format(
                format,
                lottoResultDto.getMatchNumber(),
                lottoResultDto.getPrize(),
                lottoResultDto.getMatchCount()
            ));
        }
    }

    private static void yieldPrint(BigDecimal yield) {
        String result = String.format(
            YIELD_MESSAGE_FORMAT,
            yield
        );
        result += lossPrintln(yield);

        println(result);
    }

    private static String lossPrintln(BigDecimal yield) {
        int compareResult = yield.compareTo(LOSS);

        if (compareResult < 0) {
            return LOTTO_LOSS_MESSAGE;
        }

        return "";
    }

    public static void bonusNumberRequestPrintln() {
        println(BONUS_NUMBER_REQUEST_MESSAGE);
    }
}

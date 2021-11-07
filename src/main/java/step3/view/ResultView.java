package step3.view;

import java.math.BigDecimal;
import java.util.List;

import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsResponseDto;

public class ResultView {
    public static final String TITLE = "당첨 통계\n";
    public static final String DIVIDE = "---------\n";
    public static final String LOTTO_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s입니다";

    public static final String LOTTO_RANK_FORMAT = "%s개 일치 (%d원)- %d개";
    private static final String WINNER_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String BUY_COUNT_MESSAGE = "%d 개를 구매했습니다.";
    private static final BigDecimal LOSS = BigDecimal.valueOf(1);

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

    public static void buyCutPrintln(int size) {
        println(String.format(BUY_COUNT_MESSAGE, size));
    }

    public static void winnerRequestPrintln() {
        println(WINNER_NUMBER_REQUEST_MESSAGE);
    }

    public static void lottoBuyListPrint(LottoBuyResponseDto lottoBuyResponseDto) {
        for (String numbers : lottoBuyResponseDto.getBuyLottoList()) {
            println(numbers);
        }

        buyCutPrintln(lottoBuyResponseDto.getBuyLottoList().size());
    }

    public static void statisticsPrint(LottoStatisticsResponseDto lottoStatisticsResponseDto) {
        List<LottoResultDto> lottoResultDtos = lottoStatisticsResponseDto.getLottoResultDtos();

        statisticsHeaderPrint();

        for (LottoResultDto lottoResultDto : lottoResultDtos) {
            lottoResultPrint(lottoResultDto);
        }

        yieldPrint(lottoStatisticsResponseDto);

    }

    private static void statisticsHeaderPrint() {
        print(TITLE);
        print(DIVIDE);
    }

    private static void lottoResultPrint(LottoResultDto lottoResultDto) {
        if (lottoResultDto.getMatchNumber() >= 3) {
            println(String.format(
                LOTTO_RANK_FORMAT,
                lottoResultDto.getMatchNumber(),
                lottoResultDto.getPrize(),
                lottoResultDto.getMatchCount()
            ));
        }
    }

    private static void yieldPrint(LottoStatisticsResponseDto lottoStatisticsResponseDto) {
        String result = String.format(
            YIELD_MESSAGE_FORMAT,
            lottoStatisticsResponseDto.getYield()
        );

        result += lossPrintln(lottoStatisticsResponseDto.getYield());

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

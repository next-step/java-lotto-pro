package step3.view;

import java.math.BigDecimal;
import java.util.List;

import step3.dto.LottoBoughtListResponse;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsResponseDto;

public class ResultView {
    private ResultView() {
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void buyCountPrintln(int size) {
        println(String.format(ViewConstant.BUY_COUNT_MESSAGE, size));
    }

    public static void bonusNumberRequestPrintln() {
        println(ViewConstant.BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public static void boughtLottoView(LottoBoughtListResponse lottoBoughtListResponse) {
        ResultView.println(
            String.format(
                ViewConstant.TOTAL_LOTTO_BUY_COUNT_MESSAGE,
                lottoBoughtListResponse.getManualSize(),
                lottoBoughtListResponse.getAutoSize()));

        for (String numbers : lottoBoughtListResponse.getManualLottoList()) {
            println(numbers);
        }
    }

    public static void statisticsPrint(LottoStatisticsResponseDto lottoStatisticsResponseDto) {
        List<LottoResultDto> lottoResultDtos = lottoStatisticsResponseDto.getLottoResultDtos();

        statisticsHeaderPrint();

        for (LottoResultDto lottoResultDto : lottoResultDtos) {
            lottoResultPrint(lottoResultDto);
        }

        yieldPrint(lottoStatisticsResponseDto.getYield());
    }

    private static void statisticsHeaderPrint() {
        print(ViewConstant.TITLE);
        print(ViewConstant.DIVIDE);
    }

    private static void lottoResultPrint(LottoResultDto lottoResultDto) {
        String format = ViewConstant.LOTTO_RANK_FORMAT;
        if (lottoResultDto.getRankName().equals(ViewConstant.BONUS_RANK_NAME)) {
            format = ViewConstant.LOTTO_RANK_BONUS_SECOND_FORMAT;
        }

        if (lottoResultDto.getMatchNumber() >= ViewConstant.MIN_RANK_NUMBER) {
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
            ViewConstant.YIELD_MESSAGE_FORMAT,
            yield
        );
        result += lossPrintln(yield);

        println(result);
    }

    private static String lossPrintln(BigDecimal yield) {
        int compareResult = yield.compareTo(ViewConstant.LOSS);

        if (compareResult < 0) {
            return ViewConstant.LOTTO_LOSS_MESSAGE;
        }

        return "";
    }

}

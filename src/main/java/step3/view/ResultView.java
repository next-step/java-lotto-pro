package step3.view;

import java.util.List;

import step3.dto.LottoListDto;
import step3.dto.LottoRanksDto;

public class ResultView {
    private static final String WINNER_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_MESSAGE = "%d 개를 구매했습니다.";

    private ResultView() {
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void winnerRequestPrintln() {
        println(WINNER_NUMBER_REQUEST_MESSAGE);
    }

    public static void amountRequestPrintln() {
        println(AMOUNT_REQUEST_MESSAGE);
    }

    public static void buyCutPrintln(int size) {
        println(String.format(BUY_COUNT_MESSAGE, size));
    }

    public static void printLottoList(LottoListDto lottoListDto) {
        List<String> lottoList = lottoListDto.getLottoList();
        for (String lotto : lottoListDto.getLottoList()) {
            println(lotto);
        }

        buyCutPrintln(lottoList.size());
    }

    public static void lottoResultPrint(LottoRanksDto lottoRanksDto) {
        println(lottoRanksDto.toString());
    }

}

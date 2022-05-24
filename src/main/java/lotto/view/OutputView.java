package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.dto.LottoGameDTO;
import lotto.dto.LottoLineDTO;
import lotto.dto.LottoPaymentDTO;

public class OutputView {

    private static final int DEFAULT_MATCH_COUNT = 0;
    private static final String LINE_BREAK = "\n";
    private static final String LOTTO_PAYMENT_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_STRING_PREFIX = "\n당첨 통계\n---------";
    private static final String RESULT_MESSAGE_PREFIX_NO_BONUS = "%d개 일치 (";
    private static final String RESULT_MESSAGE_PREFIX_BONUS = "%d개 일치, 보너스 볼 일치(";
    private static final String RESULT_MESSAGE_POSTFIX = "%s%d원)- %d개";
    private static final String LOTTO_EARNING_RATE_STRING_START = "총 수익률은 ";
    private static final String LOTTO_EARNING_RATE_STRING_END = "입니다.";
    private static final String LOTTO_EARNING_RATE_STRING_REFERENCE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printPayment(LottoGameDTO lottoGameDTO) {
        System.out.println(lottoGameDTO.size() + LOTTO_PAYMENT_COUNT_MESSAGE);
        System.out.println(getLottoGameString(lottoGameDTO));
    }

    public String getLottoGameString(LottoGameDTO lottoGameDTO) {
        List<String> lottoGameString = lottoGameDTO.getLottoGameDTO()
            .stream()
            .map(LottoLineDTO::toString)
            .collect(Collectors.toList());
        return String.join(LINE_BREAK, lottoGameString);
    }

    public void printLottoResult(String result) {
        System.out.println(LOTTO_RESULT_STRING_PREFIX);
        System.out.println(result);
    }

    public String getLottoResultString(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        for (LottoRank lottoRank : LottoRank.values()) {
            sb = appendWithoutZeroMatch(lottoRank, lottoResult, sb);
        }
        return sb.toString();
    }

    private StringBuilder appendWithoutZeroMatch(LottoRank lottoRank, LottoResult lottoResult,
        StringBuilder sb) {
        if (lottoRank.getMatchCount() > DEFAULT_MATCH_COUNT) {
            sb.append(chooseMessage(lottoRank, lottoResult))
                .append(LINE_BREAK);
        }
        return sb;
    }

    private String choosePrefixMessage(LottoRank lottoRank) {
        if (lottoRank == LottoRank.SECOND) {
            return String.format(RESULT_MESSAGE_PREFIX_BONUS,
                lottoRank.getMatchCount());
        }
        return String.format(RESULT_MESSAGE_PREFIX_NO_BONUS,
            lottoRank.getMatchCount());
    }

    private String chooseMessage(LottoRank lottoRank, LottoResult lottoResult) {
        return String.format(RESULT_MESSAGE_POSTFIX,
            choosePrefixMessage(lottoRank), lottoRank.getPrize(),
            lottoResult.getMatchCount(lottoRank));
    }

    public void printEarningRate(String earningRate) {
        System.out.println(earningRate);
    }

    public String getEarningRateString(LottoPaymentDTO payment, LottoPaymentDTO prize) {
        float earningRate = (float) prize.getTotalPayment() / payment.getTotalPayment();
        StringBuilder sb = new StringBuilder();
        sb.append(LOTTO_EARNING_RATE_STRING_START)
            .append(earningRate)
            .append(LOTTO_EARNING_RATE_STRING_END);
        if (earningRate < LottoConstant.EARNING_RATE_STANDARD) {
            sb.append(LOTTO_EARNING_RATE_STRING_REFERENCE);
        }
        return sb.toString();
    }
}

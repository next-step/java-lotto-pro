package lotto.view;

import static lotto.constant.LottoConstant.LINE_BREAK;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.constant.Message;
import lotto.domain.LottoPayment;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.dto.LottoGameDTO;
import lotto.dto.LottoLineDTO;
import lotto.dto.LottoPaymentDTO;

public class OutputView {

    public void printPayment(LottoGameDTO lottoGameDTO){
        System.out.println(lottoGameDTO.size() + Message.LOTTO_PAYMENT_COUNT);
        System.out.println(getLottoGameString(lottoGameDTO));
    }

    public String getLottoGameString(LottoGameDTO lottoGameDTO){
        List<String> lottoGameString = lottoGameDTO.getLottoGameDTO()
            .stream()
            .map(LottoLineDTO::toString)
            .collect(Collectors.toList());
        return String.join(LINE_BREAK, lottoGameString);
    }

    public void printLottoResult(String result){
        System.out.println(result);
    }

    public String getLottoResultString(LottoResult lottoResult){
        StringBuilder sb = new StringBuilder();
        for(LottoRank lottoRank : LottoRank.values()){
            sb = appendWithoutZeroMatch(lottoRank, lottoResult, sb);
        }
        return sb.toString();
    }

    private StringBuilder appendWithoutZeroMatch(LottoRank lottoRank, LottoResult lottoResult, StringBuilder sb){
        if(lottoRank.getMatchCount() > LottoConstant.DEFAULT_MATCH_COUNT){
            sb.append(lottoRank.getMatchCount())
                .append(Message.LOTTO_RESULT_STRING_START)
                .append(lottoRank.getPrize())
                .append(Message.LOTTO_RESULT_STRING_MIDDLE)
                .append(lottoResult.getMatchCount(lottoRank.getMatchCount()))
                .append(Message.LOTTO_RESULT_STRING_END);
        }
        return sb;
    }

    public void printEarningRate(String earningRate){
        System.out.println(earningRate);
    }

    public String getEarningRateString(LottoPaymentDTO payment, LottoPaymentDTO prize){
        float earningRate = (float) prize.getTotalPayment() / payment.getTotalPayment();
        StringBuilder sb = new StringBuilder();
        sb.append(Message.LOTTO_EARNING_RATE_STRING_START)
            .append(earningRate)
            .append(Message.LOTTO_EARNING_RATE_STRING_END);
        if(earningRate < LottoConstant.EARNING_RATE_STANDARD){
            sb.append(Message.LOTTO_EARNING_RATE_STRING_REFERENCE);
        }
        return sb.toString();
    }
}

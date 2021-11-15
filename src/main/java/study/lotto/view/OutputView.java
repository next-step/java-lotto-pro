package study.lotto.view;

import study.lotto.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static study.lotto.view.MessageUtil.*;

public class OutputView {

    public static void requestInputMoney() {
        System.out.println(REQUEST_MONEY_INPUT_MSG);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(String.format(PURCHASE_COUNT_OUPUT_MSG, count));
    }

    public static void printLottoNumbersGroup(LottoNumbersGroup group) {
        for(LottoNumbers lottoNumbers : group.getLottoNumbersList()){
            System.out.println(makeLottoNumbersPrintFormat(lottoNumbers));
        }
    }
    private static String makeLottoNumbersPrintFormat(LottoNumbers lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            sb.append(lottoNumber.getNumber() +", ");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append(']');
        return sb.toString();
    }

    public static void requestWinningLottoNumberGroup() {
        System.out.println(REQUEST_WINNING_LOTTO_NUMBER_INPUT_MSG);
    }

    public static void printStatics(Statics statics) {
        System.out.println("당첨통계");
        System.out.println("---------");

        Arrays.asList(Rank.values())
                .stream()
                .sorted(Collections.reverseOrder())
                .forEach(rank -> {
                    printAboutOneRank(statics, rank);
                });

        System.out.println(String.format("총 수익률은 %.2f입니다.", statics.getProfitRate()));
    }

    private static void printAboutOneRank(Statics statics, Rank rank) {
        Map<Rank, Count> matchCounter = statics.getMatchCounter();
        int correctCount = matchCounter.get(rank).getCount();
        int winningMoney = rank.getWinningMoney();
        int countOfMatch = rank.getCountOfMatch();
        if(Rank.SECOND == rank)
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", countOfMatch, winningMoney, correctCount));
        if(Rank.MISS != rank && Rank.SECOND != rank)
            System.out.println(String.format("%d개 일치 (%d원)- %d개", countOfMatch, winningMoney, correctCount));
    }

    public static void requestBonusBall() {
        System.out.println(REQUEST_BONUS_BALL_INPUT_MSG);
    }
}

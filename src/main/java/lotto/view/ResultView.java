package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.type.LottoRank;
import lotto.utils.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    public static final double ROUND_DIGIT_VALUE = 100d;
    private static final int LOTTO_RANK_MIN_VALUE = 3;
    private static final int LOTTO_PURCHASE_PRICE = 1000;

    private final static String NEW_LINE = "\n";
    private final static String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private final static String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private final static String LOTTO_RANK_MESSAGE = "%d개 일치 (%d원)- %d개%s";
    private final static String LOTTO_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.%s";

    public void printPurchaseLottoCount(int purchaseCount) {
        System.out.printf(PURCHASE_LOTTO_COUNT_MESSAGE, purchaseCount);
    }

    public void printIssuedLottoNumber(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            final List<Integer> lottoNumbers = lotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(lottoNumbers);
        });
    }
}

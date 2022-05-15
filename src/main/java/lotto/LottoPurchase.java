package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoPurchase {
    private final static int LOTTO_PURCHASE_PRICE_VALUE = 1000;
    private final static int LOTTO_ONE_RANK_PROFIT_VALUE = 2000000000;
    private final static int LOTTO_TWO_RANK_PROFIT_VALUE = 1500000;
    private final static int LOTTO_THREE_RANK_PROFIT_VALUE = 50000;
    private final static int LOTTO_FOUR_RANK_PROFIT_VALUE = 5000;
    private final static int LOTTO_NON_RANK_PROFIT_VALUE = 0;
    private final static int LOTTO_ONE_RANK_COUNT_VALUE = 6;
    private final static int LOTTO_TWO_RANK_COUNT_VALUE = 5;
    private final static int LOTTO_THREE_RANK_COUNT_VALUE = 4;
    private final static int LOTTO_FOUR_RANK_COUNT_VALUE = 3;

    private final List<LottoNumber> lottoNumbers;

    public LottoPurchase(int purchaseCount) {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            this.lottoNumbers.add(new LottoNumber());
        }
    }

    public LottoPurchase(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int issuedLottoCount() {
        if (isNullLottoNumbers()) {
            return 0;
        }
        return this.lottoNumbers.size();
    }

    public int issueLottoPurchasePrice() {
        return issuedLottoCount() * LOTTO_PURCHASE_PRICE_VALUE;
    }

    public int calculateWinningLottoTotalPrice(List<Integer> answerNumbers) {
        List<Integer> winningCountList = calculateWinningCountList(answerNumbers);
        return winningCountList.stream().mapToInt(this::calculateWinningLottoPrice).sum();
    }

    private List<Integer> calculateWinningCountList(List<Integer> answerNumbers) {
        return this.lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.winningCount(answerNumbers))
                .collect(Collectors.toList());
    }

    private Integer calculateWinningLottoPrice(int winningCount) {
        if (isEqualNumber(winningCount, LOTTO_ONE_RANK_COUNT_VALUE))
            return LOTTO_ONE_RANK_PROFIT_VALUE;
        if (isEqualNumber(winningCount, LOTTO_TWO_RANK_COUNT_VALUE))
            return LOTTO_TWO_RANK_PROFIT_VALUE;
        if (isEqualNumber(winningCount, LOTTO_THREE_RANK_COUNT_VALUE))
            return LOTTO_THREE_RANK_PROFIT_VALUE;
        if (isEqualNumber(winningCount, LOTTO_FOUR_RANK_COUNT_VALUE))
            return LOTTO_FOUR_RANK_PROFIT_VALUE;

        return LOTTO_NON_RANK_PROFIT_VALUE;
    }

    private boolean isEqualNumber(int number1, int number2) {
        return number1 == number2;
    }

    private boolean isNullLottoNumbers() {
        return !Optional.ofNullable(this.lottoNumbers).isPresent();
    }
}

package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.*;

public class LottoMachine {
    private static final List<LottoNo> lottoNumbers = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(new LottoNo(number));
        }
    }

    private int money;

    public LottoMachine(String input) {
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 액수입니다.");
        }

        if (isInvalidMoney(money)) {
            throw new IllegalArgumentException("유효하지 않은 액수입니다.");
        }
    }

    public LottoMachine(long input) {
        this(String.valueOf(input));
    }

    public PurchasedLotto purchaseLotto(LottoQuantity automaticQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < automaticQuantity.getQuantity(); i++) {
            lottoList.add(generateLotto());
        }
        return new PurchasedLotto(lottoList);
    }

    public PurchasedLotto purchaseLotto() {
        int lottoQuantity = calculatePurchaseLottos();
        return purchaseLotto(new LottoQuantity(lottoQuantity));
    }

    private Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNo> lottoNoList = lottoNumbers.stream()
                .limit(LottoConstant.LOTTO_SIZE)
                .collect(Collectors.toList());
        return new Lotto(lottoNoList);
    }

    public static BigDecimal calculateWinningMoney(LottoResult lottoResult) {
        List<Ranking> rankingList = lottoResult.getRankingList();
        return rankingList.stream()
                .mapToInt(Ranking::getReward)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateWinningProfit(LottoResult lottoResult) {
        BigDecimal winningMoney = calculateWinningMoney(lottoResult);
        BigDecimal divisor = new BigDecimal(money);
        return winningMoney.divide(divisor).setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isInvalidMoney(long money) {
        return money < LOTTO_PRICE;
    }

    public long getMoney() {
        return money;
    }

    public int calculatePurchaseLottos() {
        return money / LOTTO_PRICE;
    }

    public void minusMoney(LottoQuantity manualQuantity) {
        money -= LOTTO_PRICE * manualQuantity.getQuantity();
    }
}

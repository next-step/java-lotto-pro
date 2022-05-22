package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int ZERO = 0;
    private static final List<Number> NUMBERS = IntStream.rangeClosed(1, 45).mapToObj(Number::new).collect(Collectors.toList());
    private static final int SALE_PRICE = 1000;
    private static final int DECIMAL_PLACES = 100;

    public static List<Number> getRandomNumbers() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(0, 6);
    }

    public Lottos buy(int price) {
        int quantity = getQuantity(price);
        return new Lottos(quantity);
    }

    private int getQuantity(int price) {
        if (!isCorrect(price)) {
            throw new IllegalArgumentException("금액이 올바르지 않습니다.");
        }
        return price / SALE_PRICE;
    }

    private boolean isCorrect(int price) {
        return price > ZERO && price % SALE_PRICE == ZERO;
    }

    public double getProfitRate(int price, List<Rank> ranks) {
        double profitRate = (double) getMoneySum(ranks) / price;
        return Math.floor(profitRate * DECIMAL_PLACES) / DECIMAL_PLACES;
    }

    private int getMoneySum(List<Rank> ranks) {
        return ranks.stream().mapToInt(Rank::getWinningMoney).sum();
    }

}

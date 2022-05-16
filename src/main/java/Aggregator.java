import java.math.BigDecimal;

public class Aggregator {
    private final long totalPrice;
    private final Ranks ranks;

    public Aggregator(Ranks ranks) {
        this.totalPrice = (long) ranks.size() * Vendor.LOTTO_PRICE;
        this.ranks = ranks;
    }

    public long countGroupBy(Prize prize) {
        if (!this.ranks.contains(prize))
            return 0;

        return this.ranks.count(prize);
    }

    public BigDecimal yield() {
        return BigDecimal.valueOf((double) this.ranks.totalPrize() / (double) totalPrice);
    }
}

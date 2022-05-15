import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Aggregator {
    private final long totalPrice;
    private final List<Prize> prizes;

    public Aggregator(ContainCounts containCounts) {
        this.totalPrice = (long) containCounts.size() * Vendor.LOTTO_PRICE;
        this.prizes = StreamSupport.stream(containCounts.spliterator(), false)
                .map(ContainCount::find)
                .collect(Collectors.toList());
    }

    public long countGroupBy(Prize prize) {
        return prizes.stream().filter(prize::equals).count();
    }

    public boolean has(Prize prize) {
        return prizes.contains(prize);
    }

    public BigDecimal yield() {
        return BigDecimal.valueOf((double) Prize.prizeMoney(this) / (double) totalPrice);
    }
}

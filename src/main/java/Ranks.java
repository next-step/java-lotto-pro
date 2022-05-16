import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ranks implements Iterable<Prize> {
    private final List<Prize> prizes;

    public Ranks() {
        this.prizes = new ArrayList<>();
    }

    public void add(Prize prize) {
        this.prizes.add(prize);
    }

    public boolean contains(Prize prize) {
        return this.prizes.contains(prize);
    }

    public int size() {
        return this.prizes.size();
    }

    public long count(Prize prize) {
        return this.prizes.stream().filter(prize::equals).count();
    }

    public long totalPrize() {
        return this.prizes.stream().distinct().mapToLong(Prize::prize).sum();
    }

    @Override
    public Iterator<Prize> iterator() {
        return this.prizes.iterator();
    }
}

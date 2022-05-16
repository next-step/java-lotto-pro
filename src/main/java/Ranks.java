import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ranks implements Iterable<Rank> {
    private final List<Rank> ranks;

    public Ranks() {
        this.ranks = new ArrayList<>();
    }

    public void add(Rank rank) {
        this.ranks.add(rank);
    }

    public boolean contains(Rank rank) {
        return this.ranks.contains(rank);
    }

    public int size() {
        return this.ranks.size();
    }

    public long count(Rank rank) {
        return this.ranks.stream().filter(rank::equals).count();
    }

    public long totalMoney() {
        return this.ranks.stream().distinct().mapToLong(Rank::money).sum();
    }

    @Override
    public Iterator<Rank> iterator() {
        return this.ranks.iterator();
    }
}

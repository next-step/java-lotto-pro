import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContainCounts implements Iterable<ContainCount> {
    private final List<ContainCount> containCounts;

    public ContainCounts() {
        this.containCounts = new ArrayList<>();
    }

    public void add(ContainCount containCount) {
        this.containCounts.add(containCount);
    }

    public int size() {
        return this.containCounts.size();
    }

    @Override
    public Iterator<ContainCount> iterator() {
        return this.containCounts.iterator();
    }
}

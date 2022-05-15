import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ContainCounts implements Iterable<ContainCount> {
    private final List<ContainCount> containCounts;

    public ContainCounts() {
        this.containCounts = new ArrayList<>();
    }

    public void add(ContainCount containCount) {
        this.containCounts.add(containCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ContainCounts))
            return false;
        ContainCounts that = (ContainCounts) o;
        return containCounts.containsAll(that.containCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containCounts);
    }

    @Override
    public Iterator<ContainCount> iterator() {
        return this.containCounts.iterator();
    }
}

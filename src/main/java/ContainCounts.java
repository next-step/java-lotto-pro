import java.util.*;

public class ContainCounts {
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
}

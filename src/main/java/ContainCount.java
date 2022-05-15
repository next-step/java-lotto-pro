import java.util.Objects;

public class ContainCount {
    private final int containCount;

    public Prize find() {
        return Prize.find(this.containCount);
    }

    public ContainCount(int containCount) {
        if (containCount < 0)
            throw new RuntimeException();

        if (containCount > LottoNumbers.SIZE)
            throw new RuntimeException();

        this.containCount = containCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ContainCount))
            return false;
        ContainCount that = (ContainCount) o;
        return containCount == that.containCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(containCount);
    }

}

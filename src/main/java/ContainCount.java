import java.util.Objects;

public class ContainCount {
    private final int containCount;

    public Prize find() {
        return Prize.find(this.containCount);
    }

    public ContainCount(int containCount) {
        if (containCount < 0)
            throw new RuntimeException("당첨 번호의 수는 음수가 될 수 없습니다.");

        if (containCount > LottoNumbers.SIZE)
            throw new RuntimeException("당첨 번호의 수는 로또 번호 자리수 이상이 될 수 없습니다.");

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

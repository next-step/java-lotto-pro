package camp.nextstep.edu.step3;

import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.step3.IssuedMode.Manual;

public class IssuedInformation implements Comparable<IssuedInformation>{
    private final List<Lotto> issuedLotto;
    private final IssuedMode mode;

    public IssuedInformation(final IssuedMode mode, final List<Lotto> issuedLotto) {

        validation(mode, issuedLotto);
        this.mode = mode;
        this.issuedLotto = issuedLotto;
    }


    @Override
    public int compareTo(IssuedInformation information) {
        return information.compareBy(this.mode);
    }

    private int compareBy(final IssuedMode destination) {
        return this.mode.compareTo(destination);
    }

    private void validation(IssuedMode mode, List<Lotto> issuedLotto) {
        if (Objects.isNull(mode) || Objects.isNull(issuedLotto) || issuedLotto.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedInformation that = (IssuedInformation) o;
        return Objects.equals(issuedLotto, that.issuedLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuedLotto);
    }

    @Override
    public String toString() {
        return String.format("%s으로 %d%s",mode,issuedLotto.size(), mode == Manual ? "장" : "개");
    }
}

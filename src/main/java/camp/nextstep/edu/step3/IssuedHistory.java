package camp.nextstep.edu.step3;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class IssuedHistory {
    private final Set<IssuedInformation> information = new TreeSet<>();

    public IssuedHistory(List<IssuedInformation> information) {
        validation(information);
        this.information.addAll(information);
    }

    private void validation(List<IssuedInformation> information) {
        if (Objects.isNull(information) || information.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedHistory that = (IssuedHistory) o;
        return Objects.equals(information, that.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(information);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IssuedInformation issued : information) {
            stringBuilder.append(String.format("%s, ", issued));
        }
        String message = stringBuilder.toString();
        return String.format("%s를 구매했습니다.", message.substring(0, message.lastIndexOf(',')));
    }
}

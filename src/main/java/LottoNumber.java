import java.util.Collections;
import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber() {
        this.number = getLottoNumber();
    }

    public LottoNumber(String number) {
        if (isValidNumber(number)) {
            this.number = Integer.parseInt(number);
        }
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getLottoNumber() {
        Collections.shuffle(LottoGame.numbers);
        return LottoGame.numbers.get(0);
    }

    public boolean isValidNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]{1}$|^[1-3]{1}[0-9]{1}$|$4{1}[0-5]{1}$");
        if (pattern.matcher(number).matches()) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR]1부터 45사이 숫자를 입력하세요.");
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.getNumber()) {
            return 1;
        }
        if (this.number < o.getNumber()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }
}

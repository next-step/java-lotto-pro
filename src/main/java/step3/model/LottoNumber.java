package step3.model;

public class LottoNumber implements Comparable<LottoNumber> {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber number) {
        if (this.number > number.number) {
            return 1;
        }
        if (this.number < number.number) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}

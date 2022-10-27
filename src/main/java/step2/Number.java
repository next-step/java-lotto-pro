package step2;

import java.util.Objects;

class Number {
    private int num = 0;

    public Number() {

    }

    public Number(int num) {
        this.num = num;
    }

    public Number(String text) {
        this.num = convertNumber(text);
    }

    private int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException(ErrorMessageConstant.NOT_NUMBER);
        }
        if (result < 0) throw new RuntimeException(ErrorMessageConstant.NEGATIVE_NUMBER);
        return result;
    }

    public void plus(Number otherNumber) {
        this.num += otherNumber.num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}

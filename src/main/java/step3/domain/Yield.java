package step3.domain;

public class Yield {
    private final double element;

    public Yield(double element) {
        this.element = element;
    }

    public double get() {
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Yield yield = (Yield) o;

        return Double.compare(yield.element, element) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(element);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Yield{" +
                "element=" + element +
                '}';
    }
}

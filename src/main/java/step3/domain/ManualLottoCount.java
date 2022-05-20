package step3.domain;

public class ManualLottoCount {
    private final int element;

    public ManualLottoCount(int element) {
        this.element = element;
    }

    public int get() {
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

        ManualLottoCount that = (ManualLottoCount) o;

        return element == that.element;
    }

    @Override
    public int hashCode() {
        return element;
    }

    @Override
    public String toString() {
        return "manualLottoCount{" +
                "element=" + element +
                '}';
    }
}

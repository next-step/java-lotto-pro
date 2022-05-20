package step3.domain;

public class ManualLottoCount {
    private final int element;

    public ManualLottoCount(int element) {
        validate(element);
        this.element = element;
    }

    private void validate(int manualLottoCount) {
        if(manualLottoCount < 0) {
            throw new IllegalArgumentException("수동로또 구매 개수는 0 이상으로 입력해주세요.");
        }
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

package study.lotto.domain;

public class Count {
    private int count;

    public Count increase() {
        this.count++;
        return this;
    }

    public int getCount() {
        return this.count;
    }
}

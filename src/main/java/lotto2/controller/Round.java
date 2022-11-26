package lotto2.controller;

public class Round {
    private int count;

    public Round(int count) {
        this.count = count;
    }

    public boolean hasNext() {
        return 0 < count;
    }

    public void goNext() {
        --count;
    }
}

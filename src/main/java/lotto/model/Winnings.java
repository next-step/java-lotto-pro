package lotto.model;

import java.util.List;

public class Winnings {
    private final List<Winning> data;

    public Winnings(List<Winning> data) {
        this.data = data;
    }

    public int size() {
        return data.size();
    }
}

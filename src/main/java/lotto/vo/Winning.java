package lotto.vo;

import java.util.List;

public class Winning {
    private List<Result> results;

    public Winning(List<Result> results) {
        this.results = results;
    }

    public List<Result> list() {
        return results;
    }

    public int sum() {
        int sum = 0;
        for (Result result : results) {
            sum += result.sum();
        }
        return sum;
    }
}

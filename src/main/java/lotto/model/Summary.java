package lotto.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Summary {
    private final List<Result> results;

    public Summary(List<Result> results) {
        this.results = new LinkedList<>(results);
    }

    public List<Result> list() {
        return Collections.unmodifiableList(results);
    }

    public long sum() {
        long sum = 0;
        for (Result result : results) {
            sum += result.sum();
        }
        return sum;
    }
}

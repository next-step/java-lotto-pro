package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Prints {

    private final List<String> prints;

    public Prints() {
        this.prints = new ArrayList<>();
    }

    public List<String> getPrints() {
        return prints;
    }

    public void append(String print) {
        prints.add(print);
    }

    public void append(Prints print) {
        prints.addAll(print.prints);
    }
}

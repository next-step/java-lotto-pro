package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        if (lotto == null) {
            return;
        }

        this.lottos.add(lotto);
    }

    public int count() {
        return lottos.size();
    }

    public void print(Consumer<String> consumer) {
        this.lottos.forEach(lotto ->
                consumer.accept(lotto.toString()));
    }

    public Stream<Lotto> stream() {
        return this.lottos.stream();
    }
}

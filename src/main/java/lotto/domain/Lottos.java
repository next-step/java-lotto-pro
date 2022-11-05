package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> content;

    public Lottos(Collection<Lotto> content) {
        this.content = new ArrayList<>(content);
    }

    public Statistics contains(WinningLotto winningLotto) {
        List<Rank> ranks = content.stream()
            .map(winningLotto::confirm)
            .collect(toList());
        return new Statistics(ranks);
    }

    public List<Lotto> content() {
        return content;
    }

    public int size() {
        return content.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) o;
        return Objects.equals(content, lottos.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}

package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        lottos = createLotto(count);
    }

    public Lottos(Lotto[] lottoArgs) {
        lottos = Arrays.asList(lottoArgs);
    }

    public Lottos(List<Lotto> lottoList) {
        lottos = lottoList;
    }

    public void merge(Lottos mergeTarget) {
        lottos = Stream.concat(lottos.stream(), mergeTarget.allGames().stream()).collect(Collectors.toList());
    }

    public List<Lotto> allGames() {
        return lottos;
    }

    private List<Lotto> createLotto(int count) {
        List<Lotto> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(new Lotto());
        }
        return results;
    }
}

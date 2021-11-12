package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Games {

    private List<Game> list;

    public Games(final int gameCount, final List<LottoNumbers> manualGames) {
        list = new ArrayList<>();
        list.addAll(addManualGames(manualGames));
        list.addAll(addAutoGames(gameCount - manualGames.size()));
    }

    private List<Game> addManualGames(final List<LottoNumbers> manualGames) {
        return manualGames
                .stream()
                .map(Game::new)
                .collect(Collectors.toList());
    }

    private List<Game> addAutoGames(final int gameCount) {
        return IntStream.rangeClosed(0, gameCount - 1)
                .boxed()
                .map(index -> new Game())
                .collect(Collectors.toList());
    }

    public List<Game> getList() {
        return list;
    }

}

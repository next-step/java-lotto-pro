package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Games {

    private List<Game> list;

    public Games(final int gameCount, final List<LottoNumbers> manualGames) {
        list = new ArrayList<>();
        addManualGames(manualGames);
        addAutoGames(gameCount - manualGames.size());
    }

    private void addManualGames(final List<LottoNumbers> manualGames) {
        manualGames.forEach(manualGame -> {
            list.add(new Game(manualGame));
        });
    }

    private void addAutoGames(final int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            list.add(new Game());
        }
    }

    public List<Game> getList() {
        return list;
    }

}

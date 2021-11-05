package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Games {

    private List<Game> list;

    public Games(final int gameCount) {
        list = new ArrayList<>();

        for (int i = 0; i < gameCount; i++) {
            list.add(new Game());
        }
    }

    public List<Game> getList() {
        return list;
    }

}

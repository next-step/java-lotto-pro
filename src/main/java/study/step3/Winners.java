package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Winner> winnerList;

    public Winners() {
        this.winnerList = new ArrayList<>();
    }

    public void add(Winner winner) {
        winnerList.add(winner);
    }

    public int nThPrizeSize(int nTh) {
        return winnerList.stream()
                .filter(winner -> winner.getCorrectNumber() == nTh)
                .collect(Collectors.toList())
                .size();
    }
}

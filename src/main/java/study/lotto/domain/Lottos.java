package study.lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final WinStats stats;

    public Lottos(List<List<Integer>> allNumbersFromStore) {
        addLottos(allNumbersFromStore);
        stats = new WinStats(lottos.size());
    }

    private void addLottos(List<List<Integer>> allNumbersFromStore) {
        allNumbersFromStore.forEach((numbers) -> {
            lottos.add(new Lotto(numbers));
        });
    }

    public WinStats drawLots(WinningNumbers winningNumbers) {
        return winningNumbers.drawLots(this.lottos, stats);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        lottos.forEach((lotto) -> {
            buffer.append(lotto.toString() + "\n");
        });
        return buffer.toString();
    }
}

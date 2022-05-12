package lottoauto.wrapper;

import java.util.ArrayList;

public class LottoList {
    private Lotto lotto;
    private ArrayList<ArrayList<Integer>> lottos = new ArrayList<>();

    public ArrayList<Integer> getLotto(int index) {
        return lottos.get(index);
    }

    public void addLotto(ArrayList<Integer> lotto) {
        lottos.add(lotto);
    }

    public void printAllLottos() {
        lottos.stream().forEach(System.out::println);
    }

    public int size() {
        return lottos.size();
    }

}

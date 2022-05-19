import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<LottoNumbers> {
    private final List<LottoNumbers> lotto;

    private Lotto() {
        this.lotto = new ArrayList<>();
    }

    public static Lotto empty() {
        return new Lotto();
    }

    public static Lotto addAll(Lotto lotto) {
        Lotto newLotto = new Lotto();

        for(LottoNumbers lottoNumbers: lotto) {
            newLotto.add(lottoNumbers);
        }

        return newLotto;
    }

    public void add(LottoNumbers lottoNumbers) {
        this.lotto.add(lottoNumbers);
    }

    public int size() {
        return this.lotto.size();
    }

    @Override
    public Iterator<LottoNumbers> iterator() {
        return this.lotto.iterator();
    }
}

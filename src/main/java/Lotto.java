import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<LottoNumbers> {
    private final List<LottoNumbers> lotto;

    public Lotto() {
        this.lotto = new ArrayList<>();
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

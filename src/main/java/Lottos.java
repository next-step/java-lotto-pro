import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<LottoNumbers> {
    private final List<LottoNumbers> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(LottoNumbers lottoNumbers) {
        this.lottos.add(lottoNumbers);
    }

    public int size() {
        return this.lottos.size();
    }

    @Override
    public Iterator<LottoNumbers> iterator() {
        return this.lottos.iterator();
    }
}

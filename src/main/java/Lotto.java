import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Lotto implements Iterable<LottoNumbers> {
    private final List<LottoNumbers> lotto;

    private Lotto() {
        this.lotto = new ArrayList<>();
    }

    private Lotto(Lotto lotto) {
        this.lotto = StreamSupport.stream(lotto.spliterator(), false).collect(Collectors.toList());
    }

    public static Lotto empty() {
        return new Lotto();
    }

    public static Lotto of(Lotto lotto) {
        return new Lotto(lotto);
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

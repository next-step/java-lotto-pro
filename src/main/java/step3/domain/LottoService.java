package step3.domain;

import java.util.List;

public interface LottoService {
    public List<String> buyLotto(int purchaseCost);

    String toLottoReport(int[] winNumbers);
}

package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자를 입력할 수 없습니다.";
    public static final int MAX_SIZE = 6;

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            add(lottoNumber);
        }
    }

    public void add(int lottoNumber) {
        validateLottoNumbers(lottoNumber);
        this.lottos.add(new Lotto(lottoNumber));
    }

    private void validateLottoNumbers(int lottoNumber) {
        for (Lotto lotto : this.lottos) {
            validateDuplicateNumber(lottoNumber, lotto);
        }
        validateMaxSize();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void validateMaxSize() {
        if (this.lottos.size() >= MAX_SIZE) {
            throw new IllegalArgumentException(MAX_SIZE + "를 초과할 수 없습니다.");
        }
    }

    private static void validateDuplicateNumber(int lottoNumber, Lotto lotto) {
        if (new Lotto(lottoNumber).equals(lotto)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}

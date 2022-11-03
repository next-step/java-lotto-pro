package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자를 입력할 수 없습니다.";
    public static final int MAX_SIZE = 6;


    private List<Lotto> lottos = new ArrayList<>();

    protected Lottos() {
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        validate(lotto);
        this.lottos.add(lotto);
    }

    private void validate(Lotto lotto) {
        for (Lotto value : this.lottos) {
            validateDuplicate(lotto, value);
        }
        validateMaxSize();
    }

    private void validateMaxSize() {
        if (this.lottos.size() >= MAX_SIZE) {
            throw new IllegalArgumentException(MAX_SIZE + "를 초과할 수 없습니다.");
        }
    }

    private static void validateDuplicate(Lotto lotto, Lotto value) {
        if (value.equals(lotto)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}

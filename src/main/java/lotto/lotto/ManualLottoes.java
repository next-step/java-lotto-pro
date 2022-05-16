package lotto.lotto;

import lotto.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class ManualLottoes {

    private static final ManualLottoes EMPTY = new ManualLottoes(Collections.emptyList());

    private final List<String> rawLottoes;

    private ManualLottoes(List<String> lottoes) {
        this.rawLottoes = requireNonNull(lottoes, "lottoes");
    }

    public static ManualLottoes of(List<String> lottoes) {
        return CollectionUtils.isEmpty(lottoes) ? EMPTY : new ManualLottoes(lottoes);
    }

    public static ManualLottoes empty() {
        return EMPTY;
    }

    public List<String> lottoes() {
        return Collections.unmodifiableList(rawLottoes);
    }

    public int size() {
        return rawLottoes.size();
    }

    public boolean isPurchase() {
        return rawLottoes.isEmpty();
    }
}

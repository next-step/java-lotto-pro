package lotto.domain;

import generic.Money;
import java.util.Objects;

public class PurchaseLottos {
    private final Lottos manuals;
    private final Lottos autos;
    private final Lottos totals;

    private PurchaseLottos(final Lottos manuals, final Lottos autos) {
        this.manuals = manuals;
        this.autos = autos;
        this.totals = manuals.addAll(autos);
    }

    public static PurchaseLottos of(final Lottos manuals, final Lottos autos) {
        return new PurchaseLottos(manuals, autos);
    }

    public Money purchasePrice() {
        return totals.purchasePrice();
    }

    public LottoWinResultGroup draw(final WinningNumbers winningNumbers) {
        return totals.draw(winningNumbers);
    }

    public Lottos totalLottos() {
        return totals;
    }

    public int manualSize() {
        return manuals.size();
    }

    public int autoSize() {
        return autos.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseLottos)) {
            return false;
        }
        final PurchaseLottos that = (PurchaseLottos) o;
        return Objects.equals(manuals, that.manuals) && Objects.equals(autos, that.autos)
                && Objects.equals(totals, that.totals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manuals, autos, totals);
    }

    @Override
    public String toString() {
        return "PurchaseLottos{" +
                "manuals=" + manuals +
                ", autos=" + autos +
                ", totals=" + totals +
                '}';
    }
}

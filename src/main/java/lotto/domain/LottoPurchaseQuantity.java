package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LottoPurchaseQuantity {
    public static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";

    public static final String PRINT_QUANTITY_FORMAT_MANUAL_AUTO = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";

    private final int quantity;

    private LottoPurchaseQuantity(int quantity) {
        this.quantity = quantity;
        validNegative();
    }

    public static LottoPurchaseQuantity of(int quantity) {
        return new LottoPurchaseQuantity(quantity);
    }

    private void validNegative() {
        if (quantity < 0) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_NEGATIVE_NUMBER);
        }
    }

    public static LottoPurchaseQuantity manualQuantity(String inputQuantity) {
        try {
            return new LottoPurchaseQuantity(Integer.parseInt(inputQuantity));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        }
    }

    public LottoPurchaseQuantity calculateAutoQuantity(int purchaseQuantity) {
        int autoQuantity = purchaseQuantity - this.quantity;
        if (autoQuantity < 0) {
            throw new IllegalArgumentException(String.format(OutputView.ERROR_MESSAGE_FORMAT_MANUAL_LOTTO_EXCEED_QUANTITY, purchaseQuantity));
        }
        return new LottoPurchaseQuantity(autoQuantity);
    }

    public LottoLottery toLottoLottery(LottoNumberGenerator lottoNumberGenerator) {
        List<LottoNumbers> lottoLottery = new ArrayList<>();
        for (int i = 0; i < this.quantity; i++) {
            lottoLottery.add(LottoNumbers.of(lottoNumberGenerator));
        }
        return new LottoLottery(lottoLottery);
    }

    public LottoLottery toAutoLottoLottery() {
        return LottoLottery.of(this, new AutoNumberGenerator());
    }

    public Optional<LottoLottery> toManualLottoLottery() {
        if (isNonePurchase()) {
            return Optional.empty();
        }

        return Optional.of(addInputManualNumbers());
    }

    private boolean isNonePurchase() {
        return this.quantity == 0;
    }

    private LottoLottery addInputManualNumbers() {
        List<LottoNumbers> manualNumbersList = new ArrayList<>();
        for (int i = 0; i < this.quantity; i++) {
            manualNumbersList.add(LottoNumbers.of(new ManualNumberGenerator(InputView.inputManualNumbers())));
        }
        return new LottoLottery(manualNumbersList);
    }

    public String history() {
        return String.format(PRINT_QUANTITY_FORMAT, this.quantity);
    }

    public static String history(LottoPurchaseQuantity manualQuantity, LottoPurchaseQuantity autoQuantity) {
        return String.format(PRINT_QUANTITY_FORMAT_MANUAL_AUTO, manualQuantity.quantity, autoQuantity.quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchaseQuantity that = (LottoPurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}

package step3.model;

import step3.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static step3.constant.Message.Error.UNDER_MIN_PRICE;
import static step3.constant.Message.System.MANUAL_LOTTO_NUMBER_INPUT_MESSAGE;
import static step3.utils.CommonUtils.commonCheckEmpty;
import static step3.utils.CommonUtils.commonStringToNumber;

public class LottoGenerator {
    public static final int EACH_LOTTO_PRICE = 1000;

    private int purchasePrice;
    private int purchaseCount;
    private int manualCount;
    private Lottos lottos;

    public Lottos getLottos() {
        return lottos;
    }

    public int getPurchasedCount() {
        return purchaseCount;
    }
    public int getManualCount() { return manualCount; }

    public void setPurchasePriceAndManualCount(String price, String manualCount) {
        this.purchasePrice = validatePrice(price);
        this.manualCount = validateSelfCount(manualCount);
    }

    public void generateLottos() {
        calculatePurchaseCount();
        addLottos();
    }

    public void addLottos() {
        InputView.inputStringNoReply(MANUAL_LOTTO_NUMBER_INPUT_MESSAGE);
        List<Lotto> manualLottos = generateManualLottos();
        List<Lotto> autoLottos = generateAutoLottos();
        mergeManualAndAuto(manualLottos, autoLottos);
    }

    public void mergeManualAndAuto(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        List<Lotto> mergedList = Stream.of(manualLottos, autoLottos)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        lottos = new Lottos(mergedList);
    }

    private List<Lotto> generateManualLottos() {
        List<Lotto> manualLottoList = new ArrayList<>();
        IntStream.range(0, manualCount).forEach(r -> {
            manualLottoList.add(new Lotto(validateManualLottoNumbers()));
        });
        return manualLottoList;
    }

    public List<Lotto> generateAutoLottos() {
        List<Lotto> autoLottoList = new ArrayList<>();
        int restCount = purchaseCount - manualCount;
        for (int i = 0; i < restCount; i++) {
            autoLottoList.add(new Lotto());
        }
        return autoLottoList;
    }

    private String[] validateManualLottoNumbers() {
        return new Lotto().validateInputStringLottoNumber(InputView.getNextLineString());
    }


    private int validatePrice(String price) {
        commonCheckEmpty(price);
        int integerPrice = commonStringToNumber(price);
        checkPriceMinLimit(integerPrice);
        return integerPrice;
    }

    private int validateSelfCount(String selfCount) {
        commonCheckEmpty(selfCount);
        int integerCount = commonStringToNumber(selfCount);
        return integerCount;
    }

    public void calculatePurchaseCount() {
        purchaseCount = purchasePrice / EACH_LOTTO_PRICE;
    }

    private void checkPriceMinLimit(int price) {
        if (price < EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_MIN_PRICE);
        }
    }
}

package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbersGroup {
    private final List<LottoNumbers> lottoNumbersGroup;
    private final LottoNumbers prizeLottoNumbers;

    public LottoNumbersGroup(BuyAmount buyAmount, LottoNumbers prizeLottoNumbers) {
        this.lottoNumbersGroup = generateRandomLottoNumbers(buyAmount.getAmount());
        this.prizeLottoNumbers = prizeLottoNumbers;
    }

    public LottoNumbersGroup(String[] myLottoNumbersList, LottoNumbers prizeLottoNumbers) {
        this.lottoNumbersGroup = generateManualLottoNumbers(myLottoNumbersList);
        this.prizeLottoNumbers = prizeLottoNumbers;
    }

    public LottoNumbersGroup(List<LottoNumbers> myLottoNumbersList, LottoNumbers prizeLottoNumbers) {
        this.lottoNumbersGroup = myLottoNumbersList;
        this.prizeLottoNumbers = prizeLottoNumbers;
    }

    private List<LottoNumbers> generateManualLottoNumbers(String[] myLottoNumbersList) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for(String myLottoNumbers : myLottoNumbersList) {
            lottoNumbersList.add(new LottoNumbers(myLottoNumbers));
        }

        return lottoNumbersList;
    }

    public List<LottoNumbers> generateRandomLottoNumbers(int amount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoNumbersList.add(new LottoNumbers());
        }
        return lottoNumbersList;
    }

    public LottoResults getLottoResults() {
        List<LottoResult> lottoResultsList = new ArrayList<>();
        for (LottoNumbers lottoNumbers: lottoNumbersGroup) {
            LottoResult lottoResult = lottoNumbers.getLottoResult(prizeLottoNumbers);
            lottoResultsList.add(lottoResult);
        }

        return new LottoResults(lottoResultsList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbersGroup that = (LottoNumbersGroup) o;
        return Objects.equals(lottoNumbersGroup, that.lottoNumbersGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbersGroup);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LottoNumbers lottoNumbers : lottoNumbersGroup) {
            result.append(lottoNumbers)
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}

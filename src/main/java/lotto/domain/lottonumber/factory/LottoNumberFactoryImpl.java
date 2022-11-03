package lotto.domain.lottonumber.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.validation.DefaultNumberValidator;
import lotto.domain.validation.NumberValidator;

public class LottoNumberFactoryImpl implements LottoNumberFactory {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45 + MIN_LOTTO_NUMBER;
    private static List<Integer> lottoNumber;

    static {
        lottoNumber = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER; i++) {
            lottoNumber.add(i);
        }
    }

    @Override
    public LottoNumber createLottoNumber() {
        Collections.shuffle(lottoNumber);
        List<Integer> randomLottoNumber = new ArrayList<>(lottoNumber.subList(0, 6));
        Collections.sort(randomLottoNumber);
        return new LottoNumber(randomLottoNumber);
    }

    @Override
    public List<LottoNumber> createManualLottoNumbers(List<String> manualLottoNumbers) {
        validateAutoLottoNumbers(manualLottoNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        manualLottoNumbers.forEach(autoLottoNumber -> addLottoNumbers(lottoNumbers, autoLottoNumber));
        return lottoNumbers;
    }

    private void addLottoNumbers(List<LottoNumber> lottoNumbers, String manualLottoNumber) {
        String[] splitNumbers = manualLottoNumber.split(",");
        List<Integer> lottoNumber = new ArrayList<>();
        Stream.of(splitNumbers).forEach(number -> {
            lottoNumber.add(Integer.parseInt(number.trim()));
        });
        lottoNumbers.add(new LottoNumber(lottoNumber));
    }

    private void validateAutoLottoNumbers(List<String> autoLottoNumbers) {
        NumberValidator validator = new DefaultNumberValidator();
        autoLottoNumbers.forEach(validator::validate);
    }
}

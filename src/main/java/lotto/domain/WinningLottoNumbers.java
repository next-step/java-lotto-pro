package lotto.domain;

import lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLottoNumbers {

    private static final String DELIMITER = ",";
    private static final Pattern LOTTO_COMMA_PATTERN
            = Pattern.compile("^(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+$");

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNumbers(String lottoNumbers) {
        validNullOrEmpty(lottoNumbers);
        checkLottoPattern(lottoNumbers);
    }

    public WinningLottoNumbers(String lottoNumbers, LottoNumber bonusNumber) {
        validNullOrEmpty(lottoNumbers);
        checkLottoPattern(lottoNumbers);
        List<Integer> lottoNumberList = convertToIntegerList(lottoNumbers);
        checkDuplicatedBonusNumber(lottoNumberList, bonusNumber.getNumber());
        this.lottoNumbers = new LottoNumbers(lottoNumberList);
        this.bonusNumber = bonusNumber;
    }


    private void validNullOrEmpty(String lottoNumbers) {
        if (StringUtils.isNullOrEmpty(lottoNumbers)) {
            throw new IllegalArgumentException("지난주 당첨 번호를 입력해주세요.");
        }
    }

    private void checkLottoPattern(String lottoNumbers) {
        Matcher matcher = LOTTO_COMMA_PATTERN.matcher(lottoNumbers);
        if (!matcher.find()) {
            throw new IllegalArgumentException("로또 번호 형식이 올바르지 않습니다.");
        }
    }

    private void checkDuplicatedBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨된 로또 번호와 보너스 번호는 일치할 수 없습니다.");
        }
    }

    private List<Integer> convertToIntegerList(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.replaceAll("\\s","").split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}

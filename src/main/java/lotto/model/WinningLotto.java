package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRank;
import lotto.constant.LottoRoleConst;

public class WinningLotto {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<String> winningNumberWords, LottoNumber bonusNumber) {
        List<LottoNumber> winningNumbers = convertLottoNumbers(winningNumberWords);
        validateWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private List<LottoNumber> convertLottoNumbers(List<String> winningNumberWords) {
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        for (String winningNumberWord : winningNumberWords){
            winningLottoNumbers.add(new LottoNumber(winningNumberWord));
        }
        return winningLottoNumbers;
    }

    private void validateWinningNumbers(List<LottoNumber> winningNumbers,LottoNumber bonusNumber) {
        validateNumbersSize(winningNumbers);
        validateDuplication(winningNumbers,bonusNumber);
    }

    private void validateNumbersSize(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != LottoRoleConst.LOTTO_NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NON_SIX_NUMBERS);
        }
    }

    private void validateDuplication(List<LottoNumber> winningNumbers,LottoNumber bonusNumber) {
        Set<LottoNumber> deleteDuplicationNumber = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != deleteDuplicationNumber.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_BONUS);
        }
    }

    public LottoGameResult compareLottos(Lottos lottos) {
        EnumMap<LottoRank, Integer> resultRank = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank lottoRank = lotto.matchRank(toList(), bonusNumber);
            resultRank.put(lottoRank, resultRank.getOrDefault(lottoRank, 0) + 1);
        }
        return new LottoGameResult(resultRank);
    }

    private List<Integer> toList(){
        return winningNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

}

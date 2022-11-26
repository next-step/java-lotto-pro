package lotto2.model;

import lotto2.model.constant.LottoConstant;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkDuplicateNumberInList(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkDuplicateNumberInList(List<LottoNumber> winningLottoNumbers) throws IllegalArgumentException {
        final Set<LottoNumber> duplicateCheck = new HashSet<>(winningLottoNumbers);
        if (duplicateCheck.size() != LottoConstant.COUNT_OF_NUMBER_IN_LOTTO) {
            throw new IllegalArgumentException("최종적으로 당첨 번호는 반드시 6 개가 되어야 합니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount(Lotto other) {
        final List<LottoNumber> otherNumbers = other.lottoNumbers();
        int matchCount = 0;
        for (LottoNumber lottoNumber : otherNumbers) {
            if (lottoNumbers.contains(lottoNumber)) {
                ++matchCount;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        final List<LottoNumber> listToPrint = new ArrayList<>(lottoNumbers);
        Collections.sort(listToPrint, Comparator.comparingInt(LottoNumber::value));
        return listToPrint.toString();
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Constants;
import lotto.util.IntUtil;
import lotto.util.LottoNumberComparator;
import lotto.util.Validator;

public class LottoGenerator implements LottoInterface{
    private static final String ERR_SIX_NUMBERS = "여섯 개의 숫자를 입력해 주세요.";

    @Override
    public List generate(String str) {
        return generateLottoNumbers(str);
    }

    private List<LottoNumber> generateLottoNumbers(String str) {
        if(str.contains(Constants.COMMA)) {
            return generateLottoNumbersManual(str);
        }
        
        if(str.equals(Constants.AUTO_TICKET_KEY)) {
            return generateLottoNumbersAuto();
        }
        
        throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
    }
    
    private List<LottoNumber> generateLottoNumbersAuto(){
        List<Integer> candidateNumbers = IntStream
                .rangeClosed(Constants.MIN_LOTTO_TICKET_NUM, Constants.MAX_LOTTO_TICKET_NUM).boxed()
                .collect(Collectors.toList());

        Collections.shuffle(candidateNumbers);
        
        List<LottoNumber> tmpNumbers = new ArrayList<>();
        
        IntStream.range(0, Constants.MAX_LOTTO_NUM).forEach(i -> {
            LottoNumber tmpNumber = new LottoNumber(candidateNumbers.get(i));
            tmpNumbers.add(tmpNumber);
        });
        
        Collections.sort(tmpNumbers, new LottoNumberComparator());

        return tmpNumbers;
    }
    
    private List<LottoNumber> generateLottoNumbersManual(String numbers) {
        List<LottoNumber> tmpNumbers = new ArrayList<>();
        String[] numberArray = numbers.split(Constants.COMMA);
        
        validateLottoNumberSize(numberArray);
        validateLottoNumberDuplicate(numberArray);

        Arrays.stream(numberArray).forEach(i -> {
            i = i.trim();
            
            Validator.validateLottoNumberBoundary(i);
            LottoNumber tmpNumber = new LottoNumber(i);
            
            tmpNumbers.add(tmpNumber);
        });

        Collections.sort(tmpNumbers, new LottoNumberComparator());
        
        return tmpNumbers;
    }
    
    public void validateLottoNumberSize(String[] numberArray) {
        if (numberArray.length != Constants.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ERR_SIX_NUMBERS);
        }
    }    
    
    private void validateLottoNumberDuplicate(String[] numberArray) {
        Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(numberArray));

        if (lottoNumberSet.size() != numberArray.length) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }    
}

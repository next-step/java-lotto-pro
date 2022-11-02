package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Constants;
import lotto.util.LottoNumberComparator;
import lotto.util.Validator;

public class LottoNumbers {
    private static final String COMMA = ",";
    
    public final List<LottoNumber> numbers;
    
    public LottoNumbers() {
        this.numbers = generateLottoNumbers();
    }
    
    public LottoNumbers(String LottoNumber) {
        this.numbers = generateLottoNumbers(LottoNumber);
    }
    
    public int getCountOfMatch(LottoNumbers cmpNumbers) {
        int countOfMatch = 0;
        
        for(LottoNumber lottoNumber : cmpNumbers.numbers) {
            countOfMatch += Boolean.compare(isNumberContains(lottoNumber), false);
        }

        return countOfMatch;
    }
    
    public boolean isNumberContains(LottoNumber cmpNumber) {
        if (this.numbers.contains(cmpNumber)) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return this.numbers.toString();
    }
    
    private List<LottoNumber> generateLottoNumbers() {
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
    
    private List<LottoNumber> generateLottoNumbers(String number) {
        Validator.validateIsNull(number);
        
        String[] numberArray = number.split(COMMA);
        List<LottoNumber> tmpNumbers = new ArrayList<>();
        
        Validator.validateLottoNumberSize(numberArray);
        validateLottoNumberDuplicate(numberArray);

        Arrays.stream(numberArray).forEach(s -> {
            Validator.validateLottoNumberBoundary(s.trim());
            
            int i = Integer.parseInt(s.trim());
            LottoNumber tmpNumber = new LottoNumber(i);
            
            tmpNumbers.add(tmpNumber);
        });

        Collections.sort(tmpNumbers, new LottoNumberComparator());
        
        return tmpNumbers;
    }
    
    private void validateLottoNumberDuplicate(String[] lottoNumberArray) {
        Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(lottoNumberArray));

        if (lottoNumberSet.size() != lottoNumberArray.length) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }
}

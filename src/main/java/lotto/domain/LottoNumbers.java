package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Constants;
import lotto.util.Validator;

public class LottoNumbers {
    private static final int TICKET_MIN_LOTTO_NUM = 1;
    private static final int TICKET_MAX_LOTTO_NUM = 45;
    private static final String COMMA = ",";
    
    public final Integer[] numbers;
    
    public LottoNumbers() {
        this.numbers = generateLottoNumbers();
    }
    
    public LottoNumbers(String LottoNumberStr) {
        this.numbers = validateLottoNumberStr(LottoNumberStr);
    }
    
    private Integer[] generateLottoNumbers() {
        List<Integer> candidateNumbers = IntStream
                .rangeClosed(TICKET_MIN_LOTTO_NUM, TICKET_MAX_LOTTO_NUM).boxed()
                .collect(Collectors.toList());

        Collections.shuffle(candidateNumbers);
        
        Integer[] tmpNumbers = new Integer[Constants.MAX_LOTTO_NUM];
        
        IntStream.range(0, Constants.MAX_LOTTO_NUM).forEach(i -> {
            tmpNumbers[i] = candidateNumbers.get(i);
        });

        Arrays.sort(tmpNumbers);
        
        return tmpNumbers;
    }
    
    public int getCountOfMatch(LottoNumbers cmpNumbers) {
        int cnt = 0;

        for (int i : cmpNumbers.numbers) {
            cnt += Boolean.compare(isNumberContains(i), false);
        }

        return cnt;
    }
    
    public boolean isNumberContains(int num) {
        if (Arrays.asList(this.numbers).contains(num)) {
            return true;
        }
        
        return false;
    }
    
    private Integer[] validateLottoNumberStr(String numberStr) {
        Validator.validateIsNull(numberStr);
        
        String[] numberStrArray = numberStr.split(COMMA);
        Integer[] tmpNumbers = new Integer[Constants.MAX_LOTTO_NUM];
        
        Validator.validateLottoNumberSize(numberStrArray);
        validateLottoNumberNumberDuplicate(numberStrArray);

        AtomicInteger index = new AtomicInteger();
        Arrays.stream(numberStrArray).forEach(s -> {
            Validator.validateLottoNumberBoundary(s.trim());
            tmpNumbers[index.getAndIncrement()] = Integer.parseInt(s.trim());
        });
        
        return tmpNumbers;
    }
    
    private void validateLottoNumberNumberDuplicate(String[] lottoNumberStrArray) {
        Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(lottoNumberStrArray));

        if (lottoNumberSet.size() != lottoNumberStrArray.length) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }
}

package calculator.domain;

import calculator.util.Constants;

public class Result {
    private final String[] numberStrArr;
    
    public Result(String[] numberStrArr) {
        this.numberStrArr = numberStrArr;
    }
    
    public int sum() {
        int result = Constants.NULL_VALUE_INT;
        
        if(numberStrArr == null) throw new RuntimeException(Constants.ERR_VALUE_NOT_VALID);
        
        for(String e : this.numberStrArr) {
            result += validateNumber(e);
        }
        
        return result;
    }
    
    private int validateNumber(String numstr){
        int num = Constants.NULL_VALUE_INT;
        
        try {
            num = Integer.parseInt(numstr);
        }catch(NumberFormatException e) {
            throw new RuntimeException(Constants.ERR_VALUE_NOT_VALID);
        }
        
        if(num < 0) throw new RuntimeException(Constants.ERR_NEGATIVE_VALUE);
        
        return num;
    }
}

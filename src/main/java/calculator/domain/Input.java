package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import calculator.util.Constants;
import calculator.util.StringUtil;

public class Input {
    private String inputStr;
    private String delimiter;
    
    public Input(String str) {
        this.inputStr = str;
        this.delimiter = Constants.DEFAULT_DELIMITER;
        
        validateInput(str);
    }
    
    public String[] split() {
        return inputStr.split(delimiter);
    }

    private void validateInput(String str) {
        if(StringUtil.isNullOrEmpty(str)) {
            this.inputStr = Constants.NULL_VALUE_STR;
            return;
        }
        
        Matcher m = Pattern.compile(Constants.CUSTOM_DELIMITER_REGEX).matcher(str);
        
        if(m.find()) {
            this.delimiter = m.group(1);
            this.inputStr = m.group(2);
        }
    }
    
}

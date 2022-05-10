package calculator.utils;

public class StringSplitter {

    private static final String DEFAULT_SPLIT_DELIMITER_REGEX = "[,:]";

    private StringSplitter(){
        throw new AssertionError();
    }

    public static String[] split(String text){
        if(StringUtils.isEmpty(text)){
            return new String[]{};
        }
        return text.split(DEFAULT_SPLIT_DELIMITER_REGEX);
    }
}

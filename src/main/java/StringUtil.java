import java.util.Objects;

public class StringUtil {

    public static String[] splitString(String str){
        return str.split(",");
    }
    public static String[] splitString(String str, String delimiter){

        return str.split(delimiter);
    }

    public static String removeParenthesis(String str){
        return str.substring(1, str.length() - 1 );
    }

    public static String findCharUseIndex(int index){
        String abc = "abc";
        return Character.toString(abc.charAt(index));
    }

    public static boolean isNullOrEmpty(String str){
        if(Objects.isNull(str)) return true;
        if(str.isEmpty()) return true;
        return false;
    }

    public static boolean isOneNumber(String str){
        if(str.length() == 1) return true;
        return false;
    }
}

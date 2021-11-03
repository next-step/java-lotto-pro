public class StringUtil {

    public static String[] splitString(String str){
        return str.split(",");
    }

    public static String removeParenthesis(String str){
        return str.substring(1, str.length() - 1 );
    }

    public static String findCharUseIndex(int index){
        String abc = "abc";
        return Character.toString(abc.charAt(index));
    }
}

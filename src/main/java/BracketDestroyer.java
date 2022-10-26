public class BracketDestroyer {

    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final int INDEX_NOT_FOUND = -1;
    private static final int INCLUDE_INDEX_OFFSET = 1;
    private final int endIndex;
    private final String str;

    public BracketDestroyer(String str) {
        this.endIndex = str.length();
        this.str = destroyBracket(str);
    }

    private String destroyBracket(String str) {
        int indexOfOpenBracket = findIndexOfOpenBracket(str);
        int indexOfCloseBracket = findIndexOfCloseBracket(str);
        return str.substring(indexOfOpenBracket, indexOfCloseBracket);
    }

    private int findIndexOfOpenBracket(String str) {
        return str.indexOf(OPEN_BRACKET) + INCLUDE_INDEX_OFFSET;
    }

    private int findIndexOfCloseBracket(String str) {
        int index = str.lastIndexOf(CLOSE_BRACKET);
        if (index == INDEX_NOT_FOUND) {
            return endIndex;
        }
        return index;
    }

    @Override
    public String toString() {
        return str;
    }
}

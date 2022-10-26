package domain;

import java.util.Objects;

public class SafeString {
    private final String safeString;

    private SafeString(String s) {
        this.safeString = s;
    }

    public static SafeString of(String s) {
        if(Objects.isNull(s)){
            return new SafeString("0");
        }
        if(s.trim().isEmpty()){
            return new SafeString("0");
        }
        return new SafeString(s);
    }

    @Override
    public String toString() {
        return safeString;
    }
}

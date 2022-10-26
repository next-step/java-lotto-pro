package domain;

import java.util.Objects;

public class SafeString {
    private String safeString;

    private SafeString(String s) {
        this.safeString = s;
    }

    public static SafeString of(String s) {
        if(Objects.isNull(s) || s.isEmpty()){
            return new SafeString("0");
        }
        return new SafeString(s);
    }

    @Override
    public String toString() {
        return safeString;
    }
}

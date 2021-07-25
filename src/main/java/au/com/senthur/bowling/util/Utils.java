package au.com.senthur.bowling.util;

import java.util.Objects;

public abstract class Utils {

    public static int getNum(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return 0;
        }

        try {
            return Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

}

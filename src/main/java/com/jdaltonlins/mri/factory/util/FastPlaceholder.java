package com.jdaltonlins.mri.factory.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FastPlaceholder {

    public static String __replace(String copy, Function<String, String> replace, char startChar, char endChar) {
        if (copy == null || copy.length() <= 2)
            return copy;
        List<Integer> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder(copy);
        boolean lastSkip = false;
        for (int i = 0; i < buffer.length(); i++) {
            char lastChar = buffer.charAt(i);
            if (lastChar == startChar) {
                if (!lastSkip) list.add(i);
                else {
                    buffer.delete(i - 1, i);
                    lastSkip = false;
                }
            } else if (buffer.charAt(i) == endChar && !list.isEmpty()) {
                if (lastSkip) {
                    buffer.delete(i - 1, i);
                    lastSkip = false;
                    continue;
                }
                Integer dupla = list.remove(list.size() - 1);

                String tag = buffer.substring(dupla + 1, i);
                String mat;
                try {
                    mat = replace.apply(tag);
                } catch (Throwable e) {
                    mat = "&cerro&r";
                }
                if (mat == null) mat = "";

                int sizeOld = buffer.length();
                buffer.replace(dupla, i + 1, mat);

                i -= sizeOld - buffer.length();
            } else if (lastChar == '\\') {
                lastSkip = !lastSkip;
                if (!lastSkip) buffer.delete(i - 1, i++);
            } else if (lastSkip) lastSkip = false;
        }
        return buffer.toString();
    }

}

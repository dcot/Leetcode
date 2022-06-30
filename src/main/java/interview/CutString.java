package interview;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class CutString {
    public String cutString (String original, int count) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (!isChinese(original.charAt(i))) {
                if (--count >= 0) {
                    sb.append(original.charAt(i));
                }
                else {
                    break;
                }
            }
            else {
                count-=2;
                if (count >= 0) {
                    sb.append(original.charAt(i));
                }
                else {
                    break;
                }
            }
        }
        return sb.toString();
    }
    public boolean isChinese(char c){
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
}

package DFSAndStack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    String[] keys = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> combs = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return combs;
        dfs(digits,0);
        return combs;
    }
    public void dfs(String digits, int index) {
        if (stringBuilder.length() == digits.length()) {
            combs.add(stringBuilder.toString());
            return;
        }
        char digit = digits.charAt(index);
        String key = keys[digit-'0'];
        for (int j = 0; j < key.length(); j++) {
            char ch = key.charAt(j);
            stringBuilder.append(ch);
            dfs(digits,index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

}

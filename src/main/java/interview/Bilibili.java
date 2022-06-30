package interview;

public class Bilibili {
    public int check(String input, int rule_cnt, String rules) {

        return 0;
    }
    public String reorder(String a, String b) {
        char[] target = a.toCharArray();
        char[] pattern = b.toCharArray();
        int[] mark = new int[a.length()];
        for (int i = 0; i < target.length; i++) {
            int index = b.indexOf(target[i]);
            if(index != -1) {
                mark[index] = 1;
            }
        }
        for (int i = 0,j = 0; i < target.length; i++) {
            if(mark[i] == 1) {
                target[i] = pattern[j++];
            }
        }
        return new String(target);
    }
}


package interview;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        String res = "";
        String[] words;
        words = s.split(" ");
        for (int i = 0; i < k; i++) {
            res = res + words[i] + " ";
        }
        res = res.substring(0,res.length()-1);
        System.out.println(res);
        return res;
    }
}

package String;

public class CountSegments {
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] words = s.split(" ");
        int cnt = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) cnt--;
        }
        return cnt;
    }
}

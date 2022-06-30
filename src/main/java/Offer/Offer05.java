package Offer;

public class Offer05 {
    public String replaceSpace(String s) {
        char[] s1 = new char[30000];
        int j = 0;
        for (int i = 0; i < s.length(); i++,j++) {
            if (s.charAt(i) == ' '){
                s1[j] = '%';
                s1[j+1] = '2';
                s1[j+2] = '0';
                j+=2;
            }
            else {
                s1[j] = s.charAt(i);
            }
        }
        return new String(s1,0,j);
    }
}

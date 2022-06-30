package Array;

public class practice09 {

    //判断回文 用<即可 而不是<=
    public boolean isPalindrome(String s) {
        boolean res = true;
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(!Character.isLetterOrDigit(s.charAt(i))&&i<j) i++;
            while(!Character.isLetterOrDigit(s.charAt(j))&&i<j) j--;
            if (s.charAt(i)!=Character.toLowerCase(s.charAt(j))&&
                    s.charAt(i)!=Character.toUpperCase(s.charAt(j))&&
                        s.charAt(i)!=s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return  res;
    }
}

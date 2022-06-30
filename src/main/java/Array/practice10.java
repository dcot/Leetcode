package Array;

public class practice10 {
    public String reverseVowels(String s) {
        char[] buffer = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        char temp;
        while(i<j){
            while(!isVowels(buffer[i])&&i<j) i++;
            while(!isVowels(buffer[j])&&i<j) j--;
            temp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = temp;
            i++;
            j--;
        }
        return new String(buffer);
    }
    public boolean isVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
        c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
            return true;
        }
        else return false;
    }
}

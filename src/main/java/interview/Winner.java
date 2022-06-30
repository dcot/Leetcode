package interview;

public class Winner {

    public static boolean contains(int[] s, int start, int end, int[] t) {
        boolean res = false;
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = start; j < end; j++) {
                if (t[i] == s[j]) {
                    count++;
                    break;
                }
            }
        }
        if (count == t.length) res = true;
        return res;
    }
//1,2,5,4,3,4,7,1,4,9,3,1
//        3,1,4
//        5
    public static int winner(int[] s, int[] t) {
        int sLength = s.length;
        int tLength = t.length;
        int ans = 0;
        int i = 0;
        int j = tLength;
        int minLength = sLength;
        int minIndex = sLength;
        for (; i < j && j < s.length; ) {
            //s从i到j是否包含t
            if (j - i < minLength) {
                if (contains(s, i, j, t)) {
                    minLength = j - i;
                    minIndex = i;
                    ans = minIndex;
                    i++;
                    continue;
                } else {
                    j++;
                }
            } else {
                i++;
            }
        }
        return ans == 0 ? 0 : ans + 1;
    }
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        String[]values=line.split(",");
//        int[]s=new int[values.length];
//        for(int i=0;i<values.length;i++){
//            s[i] = Integer.parseInt(values[i]);
//        }
//
//        line = scanner.nextLine();
//        values=line.split(",");
//        int[]t=new int[values.length];
//        for(int i=0;i<values.length;i++){
//            t[i] = Integer.parseInt(values[i]);
//        }
//        res = winner(s, t);
//        System.out.println(String.valueOf(res));
//    }

}

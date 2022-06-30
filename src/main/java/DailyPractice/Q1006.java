package DailyPractice;

public class Q1006 {
    //* / + -
    //0 1 2 3
    public int clumsy(int N) {
        int res = N;

        for (int i = N-1,j = 0; i > 0; i--,j++) {
            switch (j%4){
                case 0: res = res*i; break;
                case 1: res = res/i; break;
                case 2: res = res+i; break;
                case 3: res = res-i; break;
            }
        }
        return res;
    }
}

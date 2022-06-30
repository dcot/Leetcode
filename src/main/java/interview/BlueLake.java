package interview;

public class BlueLake {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == chars[i + 1] && chars[i + 1] == chars[i + 2]) {
                chars[i] = '0';
                cnt++;
            }
        }
        char[] str = new char[s.length() - cnt];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                str[j++] = chars[i];
            }
        }
        return new String(str);
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dirs = {
                {-1, -1}, {0, -1}, {1, -1},
                {-1, 0},           {1, 0},
                {-1, 1},  {0, 1},  {1, 1}
        };

        for (int[] dir : dirs) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            int step = 1;
            while (isValid(x,y)) {
                if (step == 1) {
                    if (color == board[x][y] || board[x][y] == '.') break;
                }
                else {
                    if (board[x][y] == '.') break;
                    if (board[x][y] == color) return true;
                }
                x = x + dir[0];
                y = y + dir[1];
                step++;
            }
        }
        return false;
    }

    public boolean isValid(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) return true;
        else return false;
    }
}

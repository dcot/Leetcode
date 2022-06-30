package interview;

import java.util.Scanner;

public class Ali {
    public  void compressString() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line += " ";
            StringBuilder res = new StringBuilder();
            int cnt = 1;
            for (int i = 0; i < line.length()-1; i++) {
                if (line.charAt(i) == line.charAt(i+1)) {
                    cnt++;
                }
                else {
                    if (cnt > 1) {
                        res.append(cnt);
                        res.append(line.charAt(i));
                    }
                    else {
                        res.append(line.charAt(i));
                    }
                    cnt = 1;
                }
            }
            System.out.println(res.toString());
        }
    }
}

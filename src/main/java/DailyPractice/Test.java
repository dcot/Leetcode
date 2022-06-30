package DailyPractice;

import java.util.*;

public class Test {
//        0123456
//        a-b 3:0
//        b-a 1:1
        public static void main(String[] args) {
                String line;
                Scanner in = new Scanner(System.in);
                while(in.hasNextLine()){
                        line = in.nextLine();
                        System.out.println(line);
                        if(line.equals("")||line.contains(" ")) break;
                }
        }
}
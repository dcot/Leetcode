package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindRepeatedDnaSequences {
    //    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> list = new LinkedList<>();
//        int length = s.length();
//        if (length <= 10) return list;
//        StringBuilder pattern = new StringBuilder(s.substring(0,10));
//        StringBuilder target = new StringBuilder(s.substring(1,length));
//        for (int i = 0; i < length - 10; i++) {
//            boolean flag = false;
//            int index = 0;
//            for (int j = 0; j < 10; j++) {
//                char ch = pattern.charAt(j);
//                if (ch != 'A' && ch != 'C' && ch != 'G' && ch != 'T') {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                continue;
//            }
//            if (target.toString().contains(pattern.toString()) && !list.contains(pattern.toString())) list.add(pattern.toString());
//            pattern.deleteCharAt(0);
//            pattern.append(s.charAt(i+10));
//            target.deleteCharAt(0);
//        }
//        return list;
//    }
//    public List<String> findRepeatedDnaSequences(String s) {
//
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        List<String> list = new LinkedList<>();
//        for (int i = 0; i <= s.length() - 10; i++) {
//            String pattern = s.substring(i, i + 10);
//            int cnt = hashMap.getOrDefault(pattern, 0);
//            hashMap.put(pattern, cnt + 1);
//            if (cnt + 1 == 2) {
//                list.add(pattern);
//            }
//        }
//        return list;
//    }
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hashSet = new HashSet<>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String pattern = s.substring(i,i+10);
            if (hashSet.contains(pattern) && !list.contains(pattern)) {
                list.add(pattern);
            }
            else {
                hashSet.add(pattern);
            }
        }
        return list;
    }
}

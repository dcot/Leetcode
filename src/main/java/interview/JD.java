package interview;

import java.util.*;

public class JD {
    public void factory() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>(n);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                arrayList.add(temp);
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
                if (hashMap.get(temp) > max) max = hashMap.get(temp);
            }
            ArrayList<Integer> remain = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == max) {
                    remain.add(entry.getKey());
                }
            }
            int s = 0;
            int e = n - 1;
            for (int i = 0; i < remain.size(); i++) {
                int start = arrayList.indexOf(remain.get(i));
                int end = arrayList.lastIndexOf(remain.get(i));
                if ((end - start) < (e - s)) {
                    s = start;
                    e = end;
                }
            }
            s++;
            e++;
            System.out.println(s + " " + e);
        }
    }

    public void pipes(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int cnt = 1;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            for (int i = 0; i < n-1; i++) {
                float dist = Math.abs(nums[i+1] - nums[i]);
                if (dist > x) {
                    if (dist/2 <= x && k > 0) {
                        k--;
                    }
                    else {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}

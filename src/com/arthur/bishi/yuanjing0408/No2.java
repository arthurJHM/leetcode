package com.arthur.bishi.yuanjing0408;

import java.util.*;
import java.util.zip.CheckedOutputStream;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/4/8 19:34
 * @Version 1.0
 */
public class No2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String name = sc.next();
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String followed = sc.next();
                String follower = sc.next();
                if (!map.containsKey(followed)) {
                    List<String> list = new ArrayList<>();
                    list.add(follower);
                    map.put(followed, list);
                } else {
                    map.get(followed).add(follower);
                }
            }
            HashSet<String> set = new HashSet<>();
            System.out.println(calc(name, map, set));
        }
        sc.close();
    }


    private static int calc(String followed, Map<String, List<String>> map, HashSet<String> set) {
        if (!map.containsKey(followed)) {
            return 0;
        } else if (!set.contains(followed)) {
            set.add(followed);
            List<String> followers = map.get(followed);
            int count = 0;
            for (String follower : followers) {
                if(!set.contains(follower)) {
                    count++;
                }
                count += calc(follower, map, set);
            }
            return count;
        }
        return 0;
    }
}

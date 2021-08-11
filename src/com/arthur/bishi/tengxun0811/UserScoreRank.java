package com.arthur.bishi.tengxun0811;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import sun.security.krb5.internal.tools.Klist;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/11 20:53
 * @modifiedBy：
 * @version: 1.0
 */
public class UserScoreRank {
    public static final int kThreshold = 10;

    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, UserScore> map = new HashMap<>();

    //根据比赛结果，批量更新玩家信息
    public int updateUserScoreRank(List<UserScore> src) {
        for (UserScore userScore : src) {
            if (map.containsKey(userScore.getId())) {
                UserScore user = map.get(userScore.getId());
                user.setCount(userScore.count);
                user.setScores(userScore.scores);
            } else {
                list.add(userScore.getId());
                map.put(userScore.getId(), userScore);
            }
        }
        list.sort(( o1, o2) -> {
            if (map.get(o1).getScores() == map.get(o2).getScores()) {
                if (map.get(o1).getCount() == map.get(o2).getCount()) {
                    return map.get(o1).getId() - map.get(o2).getId();
                } else {
                    return map.get(o1).getScores() - map.get(o2).getScores();
                }
            } else {
                return map.get(o1).getScores() - map.get(o2).getScores();
            }
        });
        return 0;
    }
//
//    //  二分 没实现
//    private int find(UserScore userScore) {
//        return list.indexOf(userScore);
//    }

    //输入名次的上限和下限 ，给出玩家排行列表（包含上下界)
    public List<UserScore> getUserScoreRank(int low_bound, int up_bound) {
        ArrayList<UserScore> res = new ArrayList<>();
        for (int i = low_bound; i <= up_bound; i++) {
            res.add(map.get(list.get(i)));
        }
        return res;
    }

    //从排行榜删除特定的玩家
    public int deleleUserRankByIds(List<Integer> ids) {
        for (Integer id : ids) {
            list.remove(map.get(id));
            map.remove(id);
        }
        list.sort(( o1, o2) -> {
            if (map.get(o1).getScores() == map.get(o2).getScores()) {
                if (map.get(o1).getCount() == map.get(o2).getCount()) {
                    return map.get(o1).getId() - map.get(o2).getId();
                } else {
                    return map.get(o1).getScores() - map.get(o2).getScores();
                }
            } else {
                return map.get(o1).getScores() - map.get(o2).getScores();
            }
        });
        return 0;
    }


    public class UserScore {
        public int id;
        public int scores;
        public int count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScores() {
            return scores;
        }

        public void setScores(int scores) {
            this.scores = scores;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}



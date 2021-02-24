package com.arthur.leetcode;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @title: No621
 * @Author ArthurJi
 * @Date: 2021/2/24 23:40
 * @Version 1.0
 */
public class No621 {
    public static void main(String[] args) {
        System.out.println(new No621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] counts = new int[26];
        for (int i = 0; i < len; i++) {
            counts[tasks[i] - 'A']++;
        }
        Arrays.sort(counts);
        int max = 1;
        int i = 25;
        while(i != 0 && counts[i] == counts[i - 1]) {
            i--;
            max++;
        }

        return Math.max((counts[25] - 1) * (n + 1) + max, len);
    }
}
/*
参考「桶思想」，详细说明各种情况
        建立大小为 n+1 的桶子，个数为任务数量最多的那个任务，比如下图，等待时间 n=2，A 任务个数 6 个，我们建立 6 桶子，每个容量为 3：
        我们可以把一个桶子看作一轮任务



        先从最简单的情况看起，现在就算没有其他任务，我们完成任务 A 所需的时间应该是 (6-1)*3+1=16，因为最后一个桶子，不存在等待时间。


        接下来我们添加些其他任务


        可以看到 C 其实并没有对总体时间产生影响，因为它被安排在了其他任务的冷却期间；而 B 和 A 数量相同，这会导致最后一个桶子中，我们需要多执行一次 B 任务，现在我们需要的时间是 (6-1)*3+2=17

        前面两种情况，总结起来：总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数

        当冷却时间短，任务种类很多时


        比如上图，我们刚好排满了任务，此时所需时间还是 17，如果现在我还要执行两次任务 F，该怎么安排呢？



        此时我们可以临时扩充某些桶子的大小，插进任务 F，对比一下插入前后的任务执行情况：
        插入前：ABC | ABC | ABD | ABD | ABD | AB
        插入后：ABCF | ABCF | ABD | ABD | ABD | AB
        我们在第一个、第二个桶子里插入了任务F，不难发现无论再继续插入多少任务，我们都可以类似处理，而且新插入元素肯定满足冷却要求
        继续思考一下，这种情况下其实每个任务之间都不存在空余时间，冷却时间已经被完全填满了。
        也就是说，我们执行任务所需的时间，就是任务的数量

        这样剩下就很好处理了，我们只需要算两个数：

        记录最大任务数量 N，看一下任务数量并列最多的任务有多少个，即最后一个桶子的任务数 X，计算 NUM1=(N-1)*(n+1)+x
        NUM2=tasks.size()
        输出其中较大值即可
        因为存在空闲时间时肯定是 NUM1 大，不存在空闲时间时肯定是 NUM2>=NUM1

        int leastInterval(vector<char>& tasks, int n) {
        int len=tasks.size();
        vector<int> vec(26);
        for(char c:tasks) ++vec[c-'A'];
        sort(vec.begin(),vec.end(),[](int& x,int&y){return x>y;});
        int cnt=1;
        while(cnt<vec.size()&&vec[cnt]==vec[0]) cnt++;
        return max(len,cnt+(n+1)*(vec[0]-1) );
        }
        时间复杂度 O(nlogn)，空间复杂度 O(1)

        作者：popopop
        链接：https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

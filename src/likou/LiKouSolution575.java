package likou;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*575. 分糖果 I
* 题目及分析笔记https://blog.csdn.net/ancysh/article/details/121081386?spm=1001.2014.3001.5501
* */
class LiKouSolution575 {
    public static int distributeCandies1(int[] candyType) {
        //能否被2除尽
        //int flag= (candyType.length%2==0? 1: -1);
        //if(flag>0){
            //记录妹妹获得的糖果种类
            ArrayList sister_candy = new ArrayList();
            for(int a:candyType){
                if(!sister_candy.contains(a)){
                    sister_candy.add(a);
                }
            }
            int a=(sister_candy.size()>(candyType.length/2)?candyType.length/2:sister_candy.size());
            return a;
            // }
       // return 0;
    }

    public static int distributeCandies2(int[] candyType) {
        Set<Integer> set = new HashSet<>(100000);
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }


    public static void main(String[] args) {
        int[] candyType={1,1,2,2,3,3};
        //自己的
        System.out.println(distributeCandies1(candyType));
        //学习后优化
        System.out.println(distributeCandies2(candyType));
    }
}


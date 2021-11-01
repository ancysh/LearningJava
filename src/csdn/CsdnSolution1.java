package csdn;

import java.util.Random;
/*数组元素统计
     定义一个长度为5的数组arr1，用于存放5个1~9的随机整数（范围包含1和9），
     再定义一个长度为2的数组arr2，统计arr1中的元素对2求余等于0的个数,保存到arr2[0],
     统计arr1中的元素对3求余等于0的个数,保存到arr2[1],在控制台打印输出arr2的所有元素
 I*/
class CsdnSolution1 {
        public static void main(String[] args) {
            int arr1[] = new int[5];
            System.out.print("start:");
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = new Random().nextInt(9) + 1;
                System.out.print(arr1[i]+",");
            }
            System.out.print("end\n");
            int i2 = 0;
            int j3 = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] % 2 == 0) {
                    i2++;
                }
                if (arr1[i] % 3 == 0) {
                    j3++;
                }
            }
            int arr2[] = new int[2];
            arr2[0] = i2;
            arr2[1] = j3;
            for (int i = 0; i < arr2.length; i++) {
                System.out.println(arr2[i]);
            }
        }
    }

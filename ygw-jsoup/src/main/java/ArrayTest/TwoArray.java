package ArrayTest;

import java.util.Arrays;

/**
 * Created by weiyg on 2017/9/26.
 */
public class TwoArray {
    public static void main(String[] args) {
        //声明的3行4列的二维数组
        int[][] num = new int[3][4];
        /**已声明并初始化的4行二维数组，第一行为：1,2,3,4
         * 第二行为：11,22,33
         * 第三行为：111,222,333,444
         * 第四行为：1111,2222,3333,4444
         */
        int[][] dd = {{1, 2, 3, 4}, {11, 22, 33}, {111, 222, 333, 444}, {1111, 2222, 3333, 4444}};

        /**
         * for循环遍历向二维数组中写入数据
         * java二维数组遍历方法，第一层for为行，第二层for为列
         * 通过for遍历一个二维数组并复制给新空二维数值
         * i 表示行，j 表示列
         */
        for (int i = 0; i < num.length; i++) {
            System.out.println();
            for (int j = 0; j < dd[i].length; j++) {
                System.out.print((num[i][j] = dd[i][j]) + "\t");
            }
        }


        System.out.println("==============================");
        /**java自带数组数据复制方法
         * arraycopy参数说明：
         * 1、dd 为创建并初始化的二维数组
         * 2、0 为从dd二维数组开始复制的起始行坐标
         * 3、num 为声明好准备储存数据二维数组
         * 4、3 为复制数据的总行数
         * dd.length();显示的是dd二维数组的总行数
         * 需要查看行的列数，则例如 dd[0].length()显示的是 dd 二维数组第一行的总列数
         */
        System.arraycopy(dd, 0, num, 0, 3);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print((num[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}

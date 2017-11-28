package ArrayTest;

import java.util.Arrays;

public class TestArrayCopy {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO 自动生成方法存根

        String[] s1 = {"中国","山西","太原","TYUT","zyy","加拿大","不知道哪个州","不知道哪个市","不知道哪个学校","yxf"};
        String[] s2 = new String[10];
//
//        //参数一 输入数组（需要拷贝的数组）
//        //参数二 输入数组的起始位置 （拷贝的起始位置）
//        //参数三 输出数组 （新数组）
//        //参数4 输出数组的起始位置 （新数组的起始位置）
//        //参数五 拷贝个数
//        System.arraycopy(s1, 0, s2, 0, 3);
//        s2[6] = "假设蒙大拿州";
//        s2[7] = "假设蒙特利尔市";
//        s2[8] = "假设Montreal商学院";
//
//        System.out.println("This is s1");
//        for(int i = 0;i < s1.length ;i++){
//            System.out.print(s1[i] + ",");
//        }
//
//        System.out.println("\nThis is s2");
//
//        System.out.println(Arrays.toString(s2));
//        for(int i = 0;i < s2.length ;i++){
//            System.out.print(""+s2[i] + ",");
//        }
        System.out.println("<<<<<<<<<<==================================>>>>>>");
        String[][] s3 = {{"中国","山西","太原","TYUT","zyy"},{"加拿大","不知道哪个州","不知道哪个市","不知道哪个学校","yxf"}};
        String[][] s4 = new String[s3.length][s3[0].length];
        String [][] s5= new String[2][5];
        System.out.println(Arrays.toString(s5));
        System.arraycopy(s3, 0, s4, 0, s3.length);

        System.out.println("\nThis is original s3");
        for(int i = 0;i < s3.length ;i++){
            for(int j = 0; j< s3[0].length ;j++){
                System.out.print(s3[i][j] + ",");
            }
        }
//
//        s4[1][1] = "假设蒙大拿州";
//        s4[1][2] = "假设蒙特利尔市";
//        s4[1][3] = "假设Montreal商学院";
//
//        System.out.println("\nThis is s3 after s4 has changed.");
//        for(int i = 0;i < s3.length ;i++){
//            for(int j = 0; j< s3[0].length ;j++){
//                System.out.print(s3[i][j] + ",");
//            }
//        }
//
//        System.out.println("\nThis is s4");
//        for(int i = 0;i < s4.length ;i++){
//            for(int j = 0; j < s4[0].length ; j++){
//                System.out.print(s4[i][j] + ",");
//            }
//
//        }
//    }

}}
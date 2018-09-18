package zheda.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        int[] in  = new int[K];
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(" ");
        for (int i = 0; i < K; i++) {
            in[i] = Integer.parseInt(stringArray[i]);
        }

        int[] out5 = fun5(in, K);
        System.out.print(out5[0] + " ");
        System.out.print(out5[1] + " ");
        System.out.println(out5[2]);
//
//        System.out.println("fun1:" + fun1(in, K));
//        System.out.println("fun2:" + fun2(in, K));
//        System.out.println("fun3:" + fun3(in, K));
//        System.out.println("fun4:" + fun4(in, K));
//        System.out.println("fun5:" + Arrays.toString(fun5(in, K)));

    }

    private static int fun1(int[] in, int K) {
        int maxNum = 0;
        int thisNum;
        for (int i = 0; i < K; i++) {
            for (int j = i; j < K; j++) {
                thisNum = 0;
                for (int k = i; k < j; k++) {
                    thisNum += in[k];
                }
                if (thisNum > maxNum) {
                    maxNum = thisNum;
                }
            }
        }
        return maxNum;
    }

    private static int fun2(int[] in, int K) {
        int maxNum = 0;
        int thisNum = 0;
        for (int i = 0; i < K; i++) {
            thisNum = 0;
            for (int j = i; j < K; j++) {
                thisNum += in[j];
                if (thisNum > maxNum) {
                    maxNum = thisNum;
                }
            }
        }
        return maxNum;
    }

    private static int fun3( int List[], int N )
    { /* 保持与前2种算法相同的函数接口 */
        return DivideAndConquer( List, 0, N-1 );
    }

    private static int Max3( int A, int B, int C )
    { /* 返回3个整数中的最大值 */
        return A > B ? A > C ? A : C : B > C ? B : C;
    }

    private static int DivideAndConquer(int List[], int left, int right)
    { /* 分治法求List[left]到List[right]的最大子列和 */
        int MaxLeftSum, MaxRightSum; /* 存放左右子问题的解 */
        int MaxLeftBorderSum, MaxRightBorderSum; /*存放跨分界线的结果*/

        int LeftBorderSum, RightBorderSum;
        int center, i;

        if( left == right )  { /* 递归的终止条件，子列只有1个数字 */
            if( List[left] > 0 )  return List[left];
            else return 0;
        }

        /* 下面是"分"的过程 */
        center = ( left + right ) / 2; /* 找到中分点 */
        /* 递归求得两边子列的最大和 */
        MaxLeftSum = DivideAndConquer( List, left, center );
        MaxRightSum = DivideAndConquer( List, center+1, right );

        /* 下面求跨分界线的最大子列和 */
        MaxLeftBorderSum = 0; LeftBorderSum = 0;
        for( i=center; i>=left; i-- ) { /* 从中线向左扫描 */
            LeftBorderSum += List[i];
            if( LeftBorderSum > MaxLeftBorderSum )
                MaxLeftBorderSum = LeftBorderSum;
        } /* 左边扫描结束 */

        MaxRightBorderSum = 0; RightBorderSum = 0;
        for( i=center+1; i<=right; i++ ) { /* 从中线向右扫描 */
            RightBorderSum += List[i];
            if( RightBorderSum > MaxRightBorderSum )
                MaxRightBorderSum = RightBorderSum;
        } /* 右边扫描结束 */

        /* 下面返回"治"的结果 */
        return Max3( MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum );
    }

    private static int fun4(int[] in, int K) {
        int maxNum = 0;
        int thisNum = 0;
        for (int i = 0; i < K; i++) {
            thisNum += in[i];
            if (thisNum > maxNum) {
                maxNum = thisNum;
            } else if (thisNum < 0) {
                thisNum = 0;
            }
        }
        return maxNum;
    }

    private static int[] fun5(int in[], int K) {
        int maxNum = Integer.MIN_VALUE;
        int thisNum = 0;
        int[] result;
        int startTemp = 0;
        int startIndex = 0;
        int endIndex = K - 1;
        for (int i = 0; i < K; i++) {
            thisNum += in[i];
            if (thisNum >= 0) {
                if (thisNum > maxNum) {
                    maxNum = thisNum;
                    if (startIndex != startTemp) {
                        startIndex = startTemp;
                    }
                    endIndex = i;
                }
            }
            else {
                thisNum = 0;
                startTemp = i + 1;
            }
        }
        if (maxNum < 0) { // 全为负
            maxNum = 0;
            startIndex = 0;
            endIndex = K - 1;
        }
        result = new int[]{maxNum, in[startIndex], in[endIndex]};
        return result;
    }




}


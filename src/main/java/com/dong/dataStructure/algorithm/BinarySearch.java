package com.dong.dataStructure.algorithm;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @return
 * @Description 二分查找  区间[L,R]
 * 前提条件：1.顺序存储结构  2.必须以关键字大小顺序排列
 * 时间复杂度：O(h)=O(log2n) 以2为底 n的对数
 * @Author dongjian 2020/12/30 13:37
 **/
public class BinarySearch {

    public static void main(String[] args) {
        // 1.顺序存储的数组
        int[] arr = {1,2,3,5,7,9};
        int bs1 = bs1(arr, 7);
        System.out.println("------------普通二分查找区间[L,R]------------\n"+bs1);
        int bs2 = bs2(arr,7);
        System.out.println("------------普通二分查找区间[L,R)-----------\n"+bs2);
    }

    /**
     * @return int4
     * @Description  普通写法
     * @Author dongjian 2020/12/30 13:38
     * @Param [arr, key]
     **/
    public static int bs1(int[] arr, int key) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        //数组中没有要查找的元素则返回-1
        return -1;
    }
    /*
     * @return int
     * @Description 区间 [L,R) 左闭右开
     * @Author dongjian 2020/12/30 14:00
     * @Param [arr, key]
     **/
    static int bs2(int[] arr, int key) {
        int L = 0;
        int R = arr.length;// 右开 取不到所以不用减1
        int mid = 0;
        while (L < R) {
            mid = L + (R - L) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }
    static int bs3(int[] arr, int key) {
        return -1;
    }
}

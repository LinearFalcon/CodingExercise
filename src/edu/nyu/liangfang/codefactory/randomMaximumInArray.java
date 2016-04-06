package edu.nyu.liangfang.codefactory;

import java.util.Random;

/*
 给你一个array，返回array里面最大数字的index，但是必须是最大数字里面随机的一个index。
 比如[2,1,2,1,5,4,5,5]必须返回[4,6,7]中的随机的一个数字，要求O(1)space。
 */
public class randomMaximumInArray {
    public int randomMax(int[] arr) {
        if (arr.length == 0) return -1;

        int count = 0;
        int ret = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count = 1;
                ret = i;
            } else if (arr[i] == max) {
                count++;
                Random rd = new Random();
                if (rd.nextInt(count) == count - 1) {
                    ret = i;
                }
            }
        }
        return ret;
    }

	/*
	 * Reservoir Sampling
	 * 根据题目所给例子，碰到第一个5，返回index 4的概率是1，
	 * 碰到第二个5，返回index 6概率是 1/2，返回index 4的概率是 1 * 1/2 = 1/2。
	 * 碰到第三个5，返回index 7概率是 1/3，返回index 6概率变为 1/2 * 2/3 = 1/3，同理得index 4概率也是 1/2 * 2/3 = 1/3
	 * 因为在处理第三个5之前，ret各有一半概率是4 或者 6
	 */
}

package com.baizhi.corejava;

import org.junit.Test;

import java.util.Arrays;

public class TestExport {

    @Test
    public void test1() {
        int i = -8;
        int j = i >> 1;
        System.out.println(j);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3};
        int[] arr2 = new int[arr.length << 1];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;

        for (int i : arr) {
            System.out.println(i);
        }
    }
    @Test
    public void test3() {
        int[] arr = {1, 2, 3};
        int[] arr2 = new int[arr.length << 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        arr = arr2;

        for (int i : arr) {
            System.out.println(i);
        }
    }
    @Test
    public void test4() {
        int[] arr = {1, 2, 3};
        arr = Arrays.copyOf(arr, arr.length << 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

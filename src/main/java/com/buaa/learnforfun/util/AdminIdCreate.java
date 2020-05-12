package com.buaa.learnforfun.util;

public class AdminIdCreate {

    public static String create(int num) {
        if (num == 0) return "00000000";
        int len = 1;
        int temp = num;
        while (temp > 0) {
            len++;
            temp /= 10;
        }
        String ans = "";
        for (int i = 0; i <= 8 - len; i++) {
            ans += "0";
        }
        ans += String.valueOf(num);
        return ans;
    }

}

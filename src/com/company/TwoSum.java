package com.company;

import java.util.HashMap;

/**
 * Created by ggorantla on 11/14/2014.
 */
public class TwoSum {

    public int[] twoSum(int[] num, int target){
        int[] result = new int[2];
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            int other = target - num[i];
            if(myMap.get(other) !=  null){
                result[0] = myMap.get(other);
                result[1] = i;
                break;
            }
            myMap.put(num[i], i);
        }
        for (int i = 0; i < result.length; i++ )System.out.print(result[i] + " ");
        return result;
    }
    /*
    public static void main(String[] args){
        int[] num = {1, 2, 4};
        TwoSum ob = new TwoSum();
        System.out.println(ob.twoSum(num, 3));
    }
    */

}








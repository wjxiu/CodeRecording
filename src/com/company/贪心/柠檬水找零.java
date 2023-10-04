package com.company.贪心;

/**
 * @author xiu
 * @create 2023-07-18 15:23
 */
public class 柠檬水找零 {
    public static void main(String[] args) {
        System.out.println(new 柠檬水找零().lemonadeChange1(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill==5) five++;
            if (bill==10){
                if (five==0) return false;
                else five--;
                ten++;
            }
            if (bill==20){
                if (ten>0&&five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


    public boolean lemonadeChange1(int[] bills) {
        int five=0;
        int ten=0;
        for(int bill:bills){
            System.out.println(five+"  "+ten);
            if(bill==20){
                if(ten>0&&five>0){
                    ten--;
                    five--;
                }else if (five>=3){
                    five-=3;
                }else return false;
            }else if(bill==10){
                if(five>0){
                    ten++;
                    five--;
                }else return false;
            }else{
                five++;
            }
        }
        return true;
    }
}

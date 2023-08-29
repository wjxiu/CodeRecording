package com.company.测试;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xiu
 * @create 2023-08-12 20:42
 */
public class Person {
   private List<Integer> arr;
   private BigDecimal money;
   private String name;
   private String degree;

    @Override
    public String toString() {
        return "Person{" +
                "arr=" + arr +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    public static   builder builder(){
       return new builder();
   }


   public  static class builder{
        List<Integer> arr;
        BigDecimal money;
        String name;
        String degree;

        public  builder() {
        }

        public builder arr(List<Integer> arr){
            this.arr=arr;
            return this;
        }


       public builder money(BigDecimal m){
            this.money=m;
            return this;
        }
      public   builder degree(String degree){
            this.degree=degree;
            return this;
        }

      public   Person build(){
            Person person = new Person();
            person.arr=arr;
            person.degree=degree;
            person.money=money;
            person.name=name;
            return person;
        }
    }

    public List<Integer> getArr() {
        return arr;
    }

    public void setArr(List<Integer> arr) {
        this.arr = arr;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}

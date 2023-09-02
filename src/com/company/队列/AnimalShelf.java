package com.company.队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author xiu
 * @create 2023-09-02 21:51
 */
public class AnimalShelf {
    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[]{0,0});
        animalShelf.enqueue(new int[]{1,0});
        System.out.println(Arrays.toString(animalShelf.dequeueCat()));
        System.out.println(Arrays.toString(animalShelf.dequeueDog()));
        System.out.println(Arrays.toString(animalShelf.dequeueAny()));
    }
     LinkedList<int[]> queue;

    public AnimalShelf() {
        queue=new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        queue.offer(animal);
    }

    public int[] dequeueAny() {
        if (queue.isEmpty()) return new int[]{-1,-1};
        return queue.pop();
    }

    public int[] dequeueDog() {
        if (queue.isEmpty()) return new int[]{-1,-1};
        Iterator<int[]> iterator = queue.iterator();
        while (iterator.hasNext()){
            int[] next = iterator.next();
            if (next[1]==1){
                queue.remove(next);
                return next;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        if (queue.isEmpty()) return new int[]{-1,-1};
        Iterator<int[]> iterator = queue.iterator();
        while (iterator.hasNext()){
            int[] next = iterator.next();
            if (next[1]==0){
                queue.remove(next);
                return next;
            }
        }
        return new int[]{-1,-1};
    }
}

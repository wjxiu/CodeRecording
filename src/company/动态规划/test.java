package company.动态规划;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xiu
 * @create 2023-07-23 14:58
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
    }


}
class at implements Runnable {
   volatile   boolean f = false;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("subThread change flag to:" + f);
            f = true;

        }
    }
}
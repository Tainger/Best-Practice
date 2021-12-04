package com.yg.edu.atomic.unsafe;

import java.util.concurrent.locks.StampedLock;

/**
 * @author jiazhiyuan
 * @date 2021/10/31 12:27 上午
 */
public class loadFenceDemo {

    static public  class  Point{

        private double x, y;

        private final StampedLock stampedLock = new StampedLock();

        void move(double deltax, double deltay) {
            long stamp = stampedLock.writeLock();
            try {
               x += deltax;
               y += deltay;
            }finally {
                stampedLock.unlock(stamp);
            }
        }


        double distanceFromOrigin() {
            long stamp = stampedLock.tryOptimisticRead();
            double currentX = x;
            double currentY = y;

            if(!stampedLock.validate(stamp)) {
                stamp = stampedLock.readLock();

                try {
                    currentX = x;
                    currentY = y;
                }finally {
                    stampedLock.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }
    }


}



    

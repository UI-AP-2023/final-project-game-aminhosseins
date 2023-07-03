package com.example.clashofclans.control.thread;

public class BuildingThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("sleep start");
            Thread.sleep(18000);
            System.out.println("sleep end");
        } catch (InterruptedException e) {
            System.out.println("error building thread");
        }
        synchronized (this){
            System.out.println("notifyAll");
            for (HeroThread ht:HeroThread.getAllHero()){
                ht.myNotify();
            }
        }
    }
}

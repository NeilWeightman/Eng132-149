package com.sparta.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> intList = new ArrayList<>();

        ListPopulator pop1 = new ListPopulator();
        ListPopulator pop2 = new ListPopulator();
        pop1.setTheList(intList);
        pop2.setTheList(intList);
        Thread t1 = new Thread(() -> pop1.addValues(500));
        Thread t2 = new Thread(() -> pop2.addValues(500));

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println(intList.size());
    }
}
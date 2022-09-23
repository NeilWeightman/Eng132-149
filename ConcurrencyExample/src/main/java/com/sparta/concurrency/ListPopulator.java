package com.sparta.concurrency;

import java.util.List;
import java.util.Random;

public class ListPopulator {
    public List<Integer> getTheList() {
        return theList;
    }

//    public void run() {
//        addValues(500);
//    }

    public void setTheList(List<Integer> theList) {
        this.theList = theList;
    }

    private List<Integer> theList;
    private Random rand = new Random();

    public void addValues(int numValues) {
        for (int i = 0; i < numValues; i++) {
            synchronized (theList) {
                theList.add(rand.nextInt(1000));
            }
        }
    }
}

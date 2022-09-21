package org.sparta.collections;

public class Holder<T extends Employee> {
    private T theInstance;

    public T getTheInstance() {
        return theInstance;
    }

    public void setTheInstance(T theInstance) {
        this.theInstance = theInstance;
    }

    @Override
    public String toString() {
        return "The Holder contains " + theInstance;
    }
}

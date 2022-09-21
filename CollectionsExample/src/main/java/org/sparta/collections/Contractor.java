package org.sparta.collections;

public class Contractor extends Employee {
    public int dailyRate;
    public Contractor(String firstName, String lastName, String department, int dailyRate) {
        super(firstName, lastName, department);
        this.dailyRate = dailyRate;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }
}

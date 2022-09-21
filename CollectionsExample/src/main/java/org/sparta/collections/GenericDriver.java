package org.sparta.collections;

public class GenericDriver {
    public static void main(String[] args) {
        Holder<Contractor> stringHolder = new Holder<>();
        stringHolder.setTheInstance(
                new Contractor("Astha","Shaw",
                        "Training", 3000));
        System.out.println(stringHolder.getTheInstance().getDepartment());
    }
}

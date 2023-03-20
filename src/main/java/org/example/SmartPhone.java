package org.example;

public class SmartPhone extends Product {
    private String manufacturer;

    public SmartPhone (int smartphoneId,String smartphoneName, String smartphoneManufacturer){
        super.id= smartphoneId;
        super.name = smartphoneName;
        this.manufacturer = smartphoneManufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.manufacturer.contains(search);
    }
}
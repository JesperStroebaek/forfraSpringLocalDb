package com.example.forfraspringlocaldb.model;

public class Cars {

    private int carId;
    private String carBrand;
    private String carModel;

    // tom constructor - ?
    public Cars(){

    }

    public Cars(int carId,String carBrand,String carModel){
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}

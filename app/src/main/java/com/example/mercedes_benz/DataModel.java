package com.example.mercedes_benz;

/**
 * Created by KARIZsystem on 20/04/2018.
 */

public class DataModel {

    private String carName;
    private String carDescription;
    private int BtnShare,Btnwallpaper;
    private int ImgCar;


    public DataModel() {
    }

    public DataModel(String carName, String carDescription, int btnShare, int btnwallpaper, int imgCar) {
        this.carName = carName;
        this.carDescription = carDescription;
        BtnShare = btnShare;
        Btnwallpaper = btnwallpaper;
        ImgCar = imgCar;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public int getBtnShare() {
        return BtnShare;
    }

    public int getBtnwallpaper() {
        return Btnwallpaper;
    }

    public int getImgCar() {
        return ImgCar;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public void setBtnShare(int btnShare) {
        BtnShare = btnShare;
    }

    public void setBtnwallpaper(int btnwallpaper) {
        Btnwallpaper = btnwallpaper;
    }

    public void setImgCar(int imgCar) {
        ImgCar = imgCar;
    }
}

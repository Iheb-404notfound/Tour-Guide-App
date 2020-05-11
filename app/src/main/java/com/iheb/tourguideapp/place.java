package com.iheb.tourguideapp;

public class place {
    private String Sammary;
    private int Phone;
    private int imgResId;
    private String Name;

    public place(String name, int phone, int imgResId, String sammary) {
        Sammary = sammary;
        Phone = phone;
        this.imgResId = imgResId;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getSammary() {
        return Sammary;
    }

    public int getPhone() {
        return Phone;
    }
}

package com.example.lind.portalberita.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lind on 04/03/2018.
 */

public class BeritaModel {
    @SerializedName("deskripsi")//ini menconvert kan nama agar sama seperti di json
            @Expose
    String isiberita;
    @SerializedName("judul") @Expose String judulberita;
    @SerializedName("gambar")
    @Expose
    String gambarberita;
    //membuat construcktor

    public BeritaModel( String judulberita,String isiberita, String gambarberita) {
        this.isiberita = isiberita;
        this.judulberita = judulberita;
        this.gambarberita = gambarberita;
    }

    public BeritaModel() {

    }

    //membuat get setter


    public String getIsiberita() {
        return isiberita;
    }

    public void setIsiberita(String isiberita) {
        this.isiberita = isiberita;
    }

    public String getJudulberita() {
        return judulberita;
    }

    public void setJudulberita(String judulberita) {
        this.judulberita = judulberita;
    }

    public String getGambarberita() {
        return gambarberita;
    }

    public void setGambarberita(String gambarberita) {
        this.gambarberita = gambarberita;
    }
}

package com.example.lind.portalberita.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lind on 04/03/2018.
 */

public class ListBeritaModel {
    @SerializedName("berita") @Expose
    ArrayList<BeritaModel> databerita = new ArrayList<>();

    public ArrayList<BeritaModel> getDataberita() {
        return databerita;
    }

    public void setDataberita(ArrayList<BeritaModel> databerita) {
        this.databerita = databerita;
    }
}

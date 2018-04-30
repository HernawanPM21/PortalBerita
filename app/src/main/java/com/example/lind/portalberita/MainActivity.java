package com.example.lind.portalberita;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lind.portalberita.Model.BeritaModel;
import com.example.lind.portalberita.Model.ListBeritaModel;
import com.example.lind.portalberita.retrofit.ApiClient;
import com.example.lind.portalberita.retrofit.ApiServices;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class MainActivity extends AppCompatActivity {


    ArrayList<BeritaModel> listData = new ArrayList<>();
    @BindView(R.id.recyler)
    RecyclerView recyler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //butterknife
        // hal hal penting yang harus ada saat di recyler view
        //1. dataset
        //array list-> perlu bikin model yang terlebih dahulu
//                            BeritaModel berita1 = new BeritaModel("judu _berita", "isiberita", "https://1.bp.blogspot.com/-unityc2wsCc/V6LTs4pGkSI/AAAAAAAAA5o/slWA1cq7qCkF9297-ZplSvWPUOuPtrjOACLcB/s1600/g.png");
//                            listData.add(berita1);
//                            BeritaModel berita2 = new BeritaModel();
//                            berita2.setGambarberita("https://1.bp.blogspot.com/-unityc2wsCc/V6LTs4pGkSI/AAAAAAAAA5o/slWA1cq7qCkF9297-ZplSvWPUOuPtrjOACLcB/s1600/g.png");
//                            berita2.setIsiberita("isiberita2");
//                            berita2.setJudulberita("judulberita2");
//                            listData.add(berita2);
        //diatas jika manual atau pakai dummy
        //dibawah pakai data online
        getDataOnline ();
        //2. adapter
        BeritaAdapter adapter = new BeritaAdapter(MainActivity.this,listData);
        recyler.setAdapter(adapter);
        //3. layout manager
        recyler.setLayoutManager(new LinearLayoutManager(MainActivity.this));//jika pakai grid setelah context di tambah jumlah yang mau di bagi
    }

    private void getDataOnline() {
        final ProgressDialog progres = new ProgressDialog(MainActivity.this);
        progres.setTitle("Sabar Ya ...");
        progres.setMessage("Ini Cobaan ");
        progres.show();
        Call<ListBeritaModel> ambil = ApiClient.getApiServices().ambilberita();// menyamakan sama yang ada di api services
        ambil.enqueue(new Callback<ListBeritaModel>() {
            @Override
            public void onResponse(Call<ListBeritaModel> call, Response<ListBeritaModel> response) {

                if (response.isSuccessful()){
                    progres.dismiss();
                    listData = response.body().getDataberita();//mengambil

                    BeritaAdapter adapter = new BeritaAdapter(MainActivity.this,listData);
                    recyler.setAdapter(adapter);
                }
                else {
                    Toast.makeText(MainActivity.this, "Respon Di Tolak", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListBeritaModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

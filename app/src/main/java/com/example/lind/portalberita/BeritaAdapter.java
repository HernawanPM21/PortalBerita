package com.example.lind.portalberita;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lind.portalberita.Model.BeritaModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Lind on 04/03/2018.
 */

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.MyViewHolder> {
    Context context;
    ArrayList<BeritaModel> list= new ArrayList<>();

    public BeritaAdapter(Context context, ArrayList<BeritaModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //1.untuk menyambungkan layout item /inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView =inflater.inflate(R.layout.item_berita,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //3.untuk mengesetnya di sini
        holder.tvjudul.setText(list.get(position).getJudulberita());
        Picasso.with(context).load("http://172.17.5.140/serverberitabaru/foto_berita/"+
                list.get(position).getGambarberita()).into(holder.ivgambar);//jika online pakai picasaoo jika ofline bisa pakai get image ressource
//            Picasso.with(context).load(list.get(position).getGambarberita()).into(holder.ivgambar); jika offline
        holder.ivgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "kmu mencet gambar", Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "kamu mencet item", Toast.LENGTH_SHORT).show();
                Intent pindah = new Intent(context,DetailActivity.class);
//                pindah.putExtra("detail",holder.tvisi.setText(list.get(position).getIsiberita());
                pindah.putExtra("judul",list.get(position).getJudulberita());
                pindah.putExtra("isi",list.get(position).getIsiberita());
                pindah.putExtra("gambar",list.get(position).getGambarberita());
//                pindah.putExtra("gambar",);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        //4.menghintung jumlah list nya

        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //2.find view nya
        TextView tvjudul;
        TextView tvisi;
        ImageView ivgambar;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvjudul = itemView.findViewById(R.id.judul);
//            tvisi = itemView.findViewById(R.id.isi);
            ivgambar = itemView.findViewById(R.id.gambar);
        }
    }
    //bikin construktor dulu
    //baru biki extend
    //di alt enter sampai merah nya hilang
    //1.create classa dulu
    //2.implement menthod
    //3.minta My view holder untuk di extends reclyver view
    //.4buat construktor

}

package com.android1.applaboratorio11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.MiViewholder>  {

    private Context miCtext;
    private List<Productos> productosList;
    public AdapterProductos(Context miCtext, List<Productos> productosList) {
        this.miCtext = miCtext;
        this.productosList = productosList;
    }

    @NonNull
    @Override
    public MiViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(miCtext);
        View view=inflater.inflate(R.layout.listarofertas,null);

        return new MiViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewholder holder, int position) {

        Productos productos = productosList.get(position);

        Glide.with(miCtext)
                .load(productos.getImagen())
                .into(holder.img);
        holder.tvCod.setText("Codigo: "+productos.getCodigo());
        holder.tvNom.setText(""+productos.getNombre());
        holder.tvStock.setText("Stock: "+productos.getStock());
        holder.tvPrec.setText("Precio_Compra: "+productos.getPrecio_compra());
        holder.tvPrev.setText("Precio_Venta: "+productos.getPrecio_venta());


    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    class MiViewholder extends RecyclerView.ViewHolder{

        TextView tvCod,tvNom,tvStock,tvPrec,tvPrev;
        ImageView img;

        public MiViewholder(@NonNull View itemView) {
            super(itemView);

            tvCod=itemView.findViewById(R.id.tvCod);
            tvNom=itemView.findViewById(R.id.tvNom);
            tvStock=itemView.findViewById(R.id.tvStock);
            tvPrec=itemView.findViewById(R.id.tvPrec);
            tvPrev=itemView.findViewById(R.id.tvPrev);
            img=itemView.findViewById(R.id.img);


        }
    }

}



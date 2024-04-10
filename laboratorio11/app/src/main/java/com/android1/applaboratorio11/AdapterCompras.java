package com.android1.applaboratorio11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCompras extends RecyclerView.Adapter<AdapterCompras.MiViewholder> {

    private Context miCtext;
    private List<Compras> comprasList;


    public AdapterCompras(Context miCtext, List<Compras> comprasList) {
        this.miCtext = miCtext;
        this.comprasList = comprasList;
    }


    @Override
    public AdapterCompras.MiViewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(miCtext);
        View view=inflater.inflate(R.layout.listarcompra,null);

        return new AdapterCompras.MiViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCompras.MiViewholder holder, int position) {
        Compras compras = comprasList.get(position);


        holder.lblCod.setText(compras.getCodigo());
        holder.lblCli.setText(compras.getCliente());
        holder.lblDes.setText(compras.getDescripcion());
        holder.lblFec.setText(compras.getFecha());
        holder.lblCan.setText(compras.getCantidad());
        holder.lblPre.setText(compras.getPrecio());
        holder.lblMon.setText(compras.getMonto());
    }

    @Override
    public int getItemCount() {
        return comprasList.size();
    }

    class MiViewholder extends RecyclerView.ViewHolder{

        TextView lblCod,lblCli,lblDes,lblFec,lblCan,lblPre,lblMon;


        public MiViewholder(@NonNull View itemView) {
            super(itemView);

            lblCod=itemView.findViewById(R.id.lblCod);
            lblCli=itemView.findViewById(R.id.lblCli);
            lblDes=itemView.findViewById(R.id.lblDes);
            lblFec=itemView.findViewById(R.id.lblFec);
            lblCan=itemView.findViewById(R.id.lblCan);
            lblPre=itemView.findViewById(R.id.lblPrecio);
            lblMon=itemView.findViewById(R.id.lblMon);


        }
    }
}

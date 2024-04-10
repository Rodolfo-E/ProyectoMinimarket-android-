package com.android1.applaboratorio11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDeudas extends RecyclerView.Adapter<AdapterDeudas.MiViewholder> {

    private Context miCtext;
    private List<Deudas> deudasList;


    public AdapterDeudas(Context miCtext, List<Deudas> deudasList) {
        this.miCtext = miCtext;
        this.deudasList = deudasList;
    }


    @Override
    public AdapterDeudas.MiViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(miCtext);
        View view=inflater.inflate(R.layout.listardeudas,null);

        return new AdapterDeudas.MiViewholder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterDeudas.MiViewholder holder, int position) {
        Deudas deudas= deudasList.get(position);


        holder.lblCod.setText(deudas.getCodigo());
        holder.lblCli.setText(deudas.getCliente());
        holder.lblDeu.setText(deudas.getDeuda());
        holder.lblFec.setText(deudas.getFecha());

    }

    @Override
    public int getItemCount() {
        return deudasList.size();
    }

    class MiViewholder extends RecyclerView.ViewHolder{

        TextView lblCod,lblCli,lblDeu,lblFec;


        public MiViewholder(@NonNull View itemView) {
            super(itemView);

            lblCod=itemView.findViewById(R.id.lblCod);
            lblCli=itemView.findViewById(R.id.lblCli);
            lblDeu=itemView.findViewById(R.id.lblDeu);
            lblFec=itemView.findViewById(R.id.lblFec);




        }
    }
}

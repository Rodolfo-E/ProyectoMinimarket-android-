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

public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.MiViewholder>{

    private Context miCtext;
    private List<Clientes> clientesList;


    public AdapterClientes(Context miCtext, List<Clientes> clientesList) {
        this.miCtext = miCtext;
        this.clientesList = clientesList;
    }

    @NonNull
    @Override
    public AdapterClientes.MiViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(miCtext);
        View view=inflater.inflate(R.layout.listarcliente,null);

        return new AdapterClientes.MiViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClientes.MiViewholder holder, int position) {

        Clientes clientes = clientesList.get(position);


        holder.lblCod.setText(clientes.getCodigo());
        holder.lblNom.setText(clientes.getNombre());
        holder.lblApe.setText(clientes.getApellido());
        holder.lblDir.setText(clientes.getDireccion());
        holder.lblCorr.setText(clientes.getCorreo());
        holder.lblCel.setText(clientes.getCelular());
        holder.lblDis.setText(clientes.getDistrito());


    }

    @Override
    public int getItemCount() {
        return clientesList.size();
    }

    class MiViewholder extends RecyclerView.ViewHolder{

        TextView lblCod,lblNom,lblApe,lblDir,lblCorr,lblCel,lblDis;


        public MiViewholder(@NonNull View itemView) {
            super(itemView);

            lblCod=itemView.findViewById(R.id.lblCod);
            lblNom=itemView.findViewById(R.id.lblNom);
            lblApe=itemView.findViewById(R.id.lblApellido);
            lblDir=itemView.findViewById(R.id.lblDireccion);
            lblCorr=itemView.findViewById(R.id.lblCorreo);
            lblCel=itemView.findViewById(R.id.lblCelular);
            lblDis=itemView.findViewById(R.id.lblDistrito);


        }
    }
}

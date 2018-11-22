package com.tecnologia.gestint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ProductoViewHolder> {

    private ArrayList<Producto> productos;
    private OnProductoClickListener clickListener;

    public AdaptadorProducto(ArrayList<Producto> productos, OnProductoClickListener clickListener){
        this.productos = productos;
        this.clickListener = clickListener;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);
        return new ProductoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ProductoViewHolder holder, int position) {
        final Producto p = productos.get(position);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        storageReference.child(p.getFoto()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(holder.foto);

            }
        });
        holder.id.setText(p.getId());
        holder.nombre.setText(p.getNombre());
        holder.tipo.setText(p.getTipo());
        holder.cantidad.setText(p.getCantidad());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onProductoClick(p);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView id;
        private TextView nombre;
        private TextView tipo;
        private TextView cantidad;
        private View v;

        public ProductoViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            id = v.findViewById(R.id.lblID);
            nombre = v.findViewById(R.id.lblNombre);
            tipo = v.findViewById(R.id.lblTipo);
            cantidad = v.findViewById(R.id.lblCantidad);


        }

    }

    public interface OnProductoClickListener{
        void onProductoClick(Producto p);
    }
}
package com.tecnologia.gestint;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class datos {

    private static String db = "Productos";

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public static ArrayList<Producto> listap = new ArrayList();

    public static void agregar(Producto p){
        databaseReference.child(db).child(String.valueOf(p.getId())).setValue(p);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setProductos(ArrayList<Producto> personas){
        datos.listap = personas;
    }

    public static ArrayList<Producto> obtener (){
        return listap;
    }

    public static void eliminar (Producto p){
        databaseReference.child(db).child(String.valueOf(p.getId())).removeValue();
    }

    public static void editar (Producto p){
        databaseReference.child(db).child(String.valueOf(p.getId())).setValue(p);
    }

}

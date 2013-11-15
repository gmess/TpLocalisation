package com.example.tplocalisation;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.webService.amis.Amis;

public class AmisAdapter extends ArrayAdapter<Amis>{

    Context context;
    int layoutResourceId;   
    List <Amis>listeAmis =null;
   // Amis data[] = null;
   
    public AmisAdapter(Context context, int layoutResourceId,/* Amis[] data*/ List <Amis>listeAmis) {
        super(context, layoutResourceId, listeAmis);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        //this.data = data;
        this.listeAmis= listeAmis;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AmisHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new AmisHolder();
            holder.nom = (TextView)row.findViewById(R.id.nom);
            holder.prenom = (TextView)row.findViewById(R.id.prenom);
            holder.user = (TextView)row.findViewById(R.id.user);
            holder.psw = (TextView)row.findViewById(R.id.psw);
            holder.statut = (TextView)row.findViewById(R.id.statut);
           
            row.setTag(holder);
        }
        else
        {
            holder = (AmisHolder)row.getTag();
        }
       
        Amis amis = listeAmis.get(position);//data[position];
        holder.nom.setText(amis.nom);
        holder.prenom.setText(amis.prenom);
        holder.user.setText(amis.user);
        holder.psw.setText(amis.psw);
        holder.statut.setText(amis.statut);
       
        return row;
    }
   
    static class AmisHolder
    {
        
        TextView nom;
        TextView prenom;
        TextView user;
        TextView psw;
        TextView statut;
    }
}
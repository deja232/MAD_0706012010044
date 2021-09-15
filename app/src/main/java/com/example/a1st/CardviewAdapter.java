package com.example.a1st;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.array;
import model.card;

public class CardviewAdapter extends RecyclerView.Adapter<CardviewAdapter.UserViewHolder> {

    public static ArrayList<card> listCard ;
    private Context context;


    public CardviewAdapter(ArrayList<card> listCard) {

        this.listCard = listCard;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
        context = parent.getContext();
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.inputannama.setText(listCard.get(position).getNama());
        holder.unputanumur.setText(String.valueOf(listCard.get(position).getUmur()));
        holder.inputanalamat.setText(listCard.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return listCard.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView inputannama, unputanumur, inputanalamat;
        private ImageView imageView2;
        private CardView cardView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            inputannama = itemView.findViewById(R.id.inputannama);
            inputanalamat = itemView.findViewById(R.id.inputanalamat);
            unputanumur = itemView.findViewById(R.id.unputanumur);
            imageView2 = itemView.findViewById(R.id.imageView2);
            cardView = itemView.findViewById(R.id.cardview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String iname,iadd;
                    int iage;
                    iname = inputannama.getText().toString().trim();
                    iage = Integer.parseInt(unputanumur.getText().toString().trim());
                    iadd = inputanalamat.getText().toString().trim();
                    Intent bodo = new Intent(v.getContext(),UserDetails.class);
                    card hai = new card(iname,iage,iadd);
                    bodo.putExtra("mental",hai);
                    bodo.putExtra("oi",getAdapterPosition());
                    v.getContext().startActivity(bodo);
                }
            });
        }
    }
}
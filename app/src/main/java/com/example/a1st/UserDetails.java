package com.example.a1st;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.card;

public class UserDetails extends AppCompatActivity {

    private ImageView editt, deletee, kembali;
    private TextView terimanama, terimaumur, terimaalamat;
    final Loadlog loadingdialog = new Loadlog(UserDetails.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        card terima = getIntent().getParcelableExtra("mental");
        int hold = getIntent().getIntExtra("oi", -1);
        setContentView(R.layout.activity_user_details);
        getSupportActionBar().hide();

        editt = findViewById(R.id.editt);
        deletee = findViewById(R.id.deletee);
        terimanama = findViewById(R.id.namauser);
        terimaumur = findViewById(R.id.umuruser);
        terimaalamat = findViewById(R.id.alamatuser);
        kembali = findViewById(R.id.kembali);

        terimanama.setText(terima.getNama());
        terimaalamat.setText(terima.getAlamat());
        terimaumur.setText(String.valueOf(terima.getUmur()));


        editt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dit = new Intent(getBaseContext(), AddUser.class);
                String anama = terimanama.getText().toString().trim();
                int aumur = Integer.parseInt(terimaumur.getText().toString().trim());
                String aalamat = terimaalamat.getText().toString().trim();
                card on = new card(anama, aumur, aalamat);
                dit.putExtra("AddOrEdit", "edit");
                dit.putExtra("edituser", on);
                dit.putExtra("ambilini", hold);
                startActivity(dit);
                finish();
            }
        });
        deletee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingdialog.dialogalert();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ListUser.dataUser.remove(hold);
                        ListUser.adapter.notifyDataSetChanged();
                        finish();
                    }
                }, 300);

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}

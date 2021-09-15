package com.example.a1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import model.card;

public class AddUser extends AppCompatActivity {

    private EditText nama, umur, alamat,enama,eumur,ealamt;
    private Button save,eedt;
    private Boolean yes = false, yess = false, yesss = false ;
    private ImageView bek,ebek;
    private String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent indexx = getIntent();
        h = indexx.getStringExtra("AddOrEdit");
        if (h.equalsIgnoreCase("add")) {
            setContentView(R.layout.activity_add_user);
            getSupportActionBar().hide();

            nama = findViewById(R.id.nama);
            umur = findViewById(R.id.umur);
            alamat = findViewById(R.id.alamat);
            save = findViewById(R.id.savee);
            bek = findViewById(R.id.bek1);

            save.setEnabled(false);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = nama.getText().toString().trim();
                    int age = Integer.parseInt(umur.getText().toString().trim());
                    String address = alamat.getText().toString().trim();
                    card temp = new card(name, age, address);
                    final Loadlog loadingdialog = new Loadlog(AddUser.this);
                    loadingdialog.dialogalert();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingdialog.gone();
                            Intent intent = new Intent(getBaseContext(), ListUser.class);
                            intent.putExtra("newUser", temp);
                            setResult(200, intent);
                            finish();
                        }
                    }, 300);
                }
            });
            bek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), ListUser.class);
                    startActivity(intent);
                    finish();
                }
            });
            nama.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    String addnama = nama.getText().toString().trim();
                    if (!addnama.isEmpty()) {
                        yes = true;
                        if (yes == true && yess == true && yesss == true) {
                            save.setEnabled(true);
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            umur.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    String addumur = umur.getText().toString().trim();
                    if (!addumur.isEmpty()) {
                        yess = true;
                        if (yes == true && yess == true && yesss == true) {
                            save.setEnabled(true);
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            alamat.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    String addalamat = alamat.getText().toString().trim();
                    if (!addalamat.isEmpty()) {
                        yesss = true;
                        if (yes == true && yess == true && yesss == true) {
                            save.setEnabled(true);
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        } else {
            setContentView(R.layout.activity_edit_user);
            getSupportActionBar().hide();

            Intent take = getIntent();
            card bro = take.getParcelableExtra("edituser");
            int rill = take.getIntExtra("ambilini",-1);

            enama = findViewById(R.id.namaa);
            eumur = findViewById(R.id.umurr);
            ealamt = findViewById(R.id.alamatt);
            eedt = findViewById(R.id.editbutton);
            ebek = findViewById(R.id.bek2);

            enama.setText(bro.getNama());
            eumur.setText(String.valueOf(bro.getUmur()));
            ealamt.setText(bro.getAlamat());

            eedt.setEnabled(true);

            eedt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String namee = enama.getText().toString().trim();
                    int agee = Integer.parseInt(eumur.getText().toString().trim());
                    String addresse = ealamt.getText().toString().trim();
                    card temp = new card(namee, agee, addresse);
                    final Loadlog loadingdialog = new Loadlog(AddUser.this);
                    loadingdialog.dialogalert();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingdialog.gone();
                            ListUser.dataUser.set(rill,temp);
                            ListUser.adapter.notifyDataSetChanged();
//                            Intent intent = new Intent(getBaseContext(), ListUser.class);
//                            intent.putExtra("newUserr", temp);
//                            intent.putExtra("trakhir",rill);
//                            setResult(500, intent);
                            finish();

                        }
                    }, 300);
                }
            });
            ebek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    card boo = ListUser.dataUser.get(rill);
                    Intent cv = new Intent(getBaseContext(),UserDetails.class);
                    cv.putExtra("mental",boo);
                    cv.putExtra("oi",rill);
                    startActivity(cv);
                    finish();
                }
            });
        }
    }
}


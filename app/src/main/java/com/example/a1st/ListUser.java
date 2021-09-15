package com.example.a1st;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import model.array;
import model.card;

public class ListUser extends AppCompatActivity {

    private FloatingActionButton add;
    private RecyclerView recyclerrView;
    private TextView notext;
    public static ArrayList<card> dataUser;
    static CardviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        initView();
        setupRecyclerView();
        setListener();
        getSupportActionBar().hide();
    }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1) {
                if (resultCode == 200) {
                    card yey = data.getParcelableExtra("newUser");
                    dataUser.add(yey);
                    adapter.notifyDataSetChanged();
                    if (!dataUser.isEmpty()) {
                        notext.setVisibility(View.GONE);
                    }

//                }else {
//                    card yey = data.getParcelableExtra("newUserr");
//                    int x = data.getIntExtra("trakhir",0);
//                    dataUser.set(x,yey);
//                    adapter.notifyDataSetChanged();
//                    if (!dataUser.isEmpty()) {
//                        notext.setVisibility(View.GONE);
//                    }
                }
                }
        }


    private void setListener() {
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(), AddUser.class);
                        intent.putExtra("AddOrEdit", "add");
                        startActivityForResult(intent,1);
                    }
                });
            }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerrView.setLayoutManager(manager);
        recyclerrView.setAdapter(adapter);
    }

    private void initView() {
        recyclerrView = findViewById(R.id.recyclerView);
        dataUser = new ArrayList<card>();
        adapter = new CardviewAdapter(dataUser);
        notext = findViewById(R.id.textView2);
        add = findViewById(R.id.add);
        Intent intent=getIntent();
        int gay = intent.getIntExtra("baru",0);
//        if(array.User != null){
//            dataUser = array.User;
//        }else{
//            dataUser = new ArrayList<>();
//        }

    }
}

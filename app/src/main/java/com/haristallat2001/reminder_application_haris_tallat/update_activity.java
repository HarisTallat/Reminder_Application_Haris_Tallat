package com.haristallat2001.reminder_application_haris_tallat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class update_activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter3;
    ArrayList<list_data> main_input1;
    ImageView ivback_add_update;
    Button btsaved_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activity);
        recyclerView=findViewById(R.id.update_list);
        btsaved_update=findViewById(R.id.btsaved_update);
        ivback_add_update=findViewById(R.id.ivback_add_update);




        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        main_input1=new ArrayList<>();
        main_input1.add(new list_data("Moniter"));
        main_input1.add(new list_data("Mouse"));
        main_input1.add(new list_data("Keyboard"));



        myAdapter3=new item_adopter(this,main_input1);

        recyclerView.setAdapter(myAdapter3);

        btsaved_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(update_activity.this,"DATA Has been Updated Successfully",Toast.LENGTH_LONG).show();
            }
        });

        ivback_add_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(update_activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
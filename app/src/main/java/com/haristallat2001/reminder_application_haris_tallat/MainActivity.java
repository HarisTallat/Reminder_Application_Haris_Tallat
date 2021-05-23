package com.haristallat2001.reminder_application_haris_tallat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  final_adoptorr.clicked {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter1;
    ArrayList<class_main> main_input;
    final int KEY1=2,KEY3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.shopping_list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        main_input=new ArrayList<>();


        main_input.add(new class_main("School","2:01 pm","Pen Eraser Bag van "));
        main_input.add(new class_main("Computer","1:00 pm"," Moniter Mouse Keyboard "));



        myAdapter1=new final_adoptorr(this, main_input);

        recyclerView.setAdapter(myAdapter1);
        recyclerView=findViewById(R.id.list);
        FloatingActionButton fab = findViewById(R.id.add_main);

     fab.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
               Intent intentmain= new Intent(MainActivity.this,add_reminders.class);

              startActivityForResult(intentmain,KEY1);


            }
      });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==KEY1)
        {
            if(resultCode== RESULT_OK){

                String inserted_time1=data.getStringExtra("inserted_time");
                String inserted_list_name1=data.getStringExtra("inserted_list_name");
                String inserted_inner_date1=data.getStringExtra("inserted_inner_date");
                Toast.makeText(MainActivity.this,inserted_list_name1,Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,"Data Has Been Successfully ADDED",Toast.LENGTH_LONG).show();
                main_input.add(new class_main(inserted_list_name1,inserted_time1,"Bat Ball Helemt"));
                myAdapter1.notifyDataSetChanged();

            }
            else if (resultCode== RESULT_CANCELED)
            {
                Toast.makeText(MainActivity.this,"DATA NOT FOUND",Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    public void clickedItem(int index) {
        Intent intent3= new Intent(MainActivity.this,update_activity.class);


        startActivity(intent3);



    }
}
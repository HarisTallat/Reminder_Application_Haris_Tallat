package com.haristallat2001.reminder_application_haris_tallat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class input_user_item_list extends AppCompatActivity {
    EditText insert;
    Button back;
    TextView display1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user_item_list);
        insert=findViewById(R.id.insert);
        back=findViewById(R.id.back);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=insert.getText().toString().trim();
                Intent intenti=new Intent();
                //Toast.makeText(input_user_item_list.this,items, LENGTH_LONG).show();
                intenti.putExtra("inserted_items",name);

                setResult(RESULT_OK,intenti);
                finish();

            }
        });

    }
}
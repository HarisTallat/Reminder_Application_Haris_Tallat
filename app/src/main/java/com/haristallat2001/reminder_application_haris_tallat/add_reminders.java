package com.haristallat2001.reminder_application_haris_tallat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class add_reminders extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private ImageView ivdate, ivtime,ivback_add,ivinput,ivadd;
    private Button btsaved;
    final int KEY=1;
TextView tvData;
    String aMPM;
    TextView show_date, show_time,tvadd,etlistname,iv_input;
    ImageView ivrepeat,ivrepeat2;
RecyclerView recyclerView;
RecyclerView.LayoutManager layoutManager;
RecyclerView.Adapter myAdapter2;
ArrayList<list_data> input_Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminders);
        initDatePicker();
        recyclerView=findViewById(R.id.list);
        ivdate = findViewById(R.id.ivdate);
        show_date = findViewById(R.id.show_date_update);
        show_time = findViewById(R.id.show_time_update);
        ivtime = findViewById(R.id.ivtime);
        ivrepeat=findViewById(R.id.ivrepeat_update);
        ivinput=findViewById(R.id.ivinput);
        ivadd=findViewById(R.id.ivadd);
        tvadd=findViewById(R.id.tvadd);
        ivrepeat2=findViewById(R.id.ivrepeat2_update);
        btsaved=findViewById(R.id.btsaved_update);
        ivback_add=findViewById(R.id.ivback_add_update);
        tvData=findViewById(R.id.tvData);


        etlistname=findViewById(R.id.etlistname);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        input_Items=new ArrayList<>();
        myAdapter2=new item_adopter(this, input_Items);

        recyclerView.setAdapter(myAdapter2);

ivinput.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ivadd.setVisibility( View.GONE);
        tvadd.setVisibility( View.GONE);
        Intent intent1= new Intent(add_reminders.this,input_user_item_list.class);
      startActivityForResult(intent1,KEY);

    }
});


        btsaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file="Haris_Tallat_reminder.txt";
                String time=show_time.getText().toString().trim();
                String list_name=etlistname.getText().toString().trim();
                String inner_data=show_date.getText().toString().trim();
                Toast.makeText(add_reminders.this,time,Toast.LENGTH_LONG).show();
                FileOutputStream f = null;
             //   String data =  name1 + "\n" + age1 + "\n" + gender1 + "\n" + weight + "\n" + height + "\n" +result_show  + "\n";
//                try {
//                    f= openFileOutput(file, Context.MODE_APPEND);
//                    try {
//                        f.write(data.getBytes());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
            }
        });
        ivback_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=show_time.getText().toString().trim();
                String list_name=etlistname.getText().toString().trim();
                String inner_data=show_date.getText().toString().trim();

                Toast.makeText(add_reminders.this,"okkkkkkkkkkkk",Toast.LENGTH_LONG).show();
                Intent intenthai=new Intent();
                Toast.makeText(add_reminders.this,time,Toast.LENGTH_LONG).show();
                intenthai.putExtra("inserted_time",time);
                intenthai.putExtra("inserted_list_name",list_name);
                intenthai.putExtra("inserted_inner_date",inner_data);

                setResult(RESULT_OK,intenthai);
                finish();
            }
        });


        ivrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivrepeat.setVisibility(View.GONE);
                ivrepeat2.setVisibility(View.VISIBLE);


            }
        });
      ivrepeat2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              ivrepeat.setVisibility(View.VISIBLE);
              ivrepeat2.setVisibility(View.GONE);
          }
      });
        show_date.setText(getTodaysDate());

        SimpleDateFormat time = new SimpleDateFormat("hh:mm a");
        String timee = time.format(new Date());
        show_time.setText(timee);
        ivtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(add_reminders.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 12)
                            aMPM = "PM";
                        else
                            aMPM = "AM";
                        show_time.setText(String.format("%02d:%02d", hourOfDay , minute) +" "+ aMPM);
                    }
                }, hour, min,false);
                timePickerDialog.show();
            }


        });


    }
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        month=month+1;
        int day= cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date= makeDateString(day,month,year);
                show_date.setText(date);

            }

        };
        Calendar cal = Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);
        int hour= cal.get(Calendar.HOUR_OF_DAY);
        int minutes= cal.get(Calendar.MINUTE);

        int style= AlertDialog.THEME_HOLO_LIGHT;


        datePickerDialog= new DatePickerDialog(this,style,dateSetListener,year,month,day);


    }
    private String makeDateString( int day, int month, int year)
    {
        return getMonthFormat(month)+" "+day+" "+year;
    }



    private String getMonthFormat(int month) {
        if(month==1)
            return "JAN";
        if(month==2)
            return "FEB";
        if(month==3)
            return "MAR";
        if(month==4)
            return "APR";
        if(month==5)
            return "MAY";
        if(month==6)
            return "JUN";
        if(month==7)
            return "JUL";
        if(month==8)
            return "AUG";
        if(month==9)
            return "SEP";
        if(month==10)
            return "OCT";
        if(month==11)
            return "NOV";
        if(month==12)
            return "DEC";
        return "JAN";
    }
    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }


    public void btnn_ShowDialoig(View view) {
        final AlertDialog.Builder alert= new AlertDialog.Builder(add_reminders.this);
        View mView= getLayoutInflater().inflate(R.layout.custom_dialog,null);
        final EditText txt_input=(EditText)mView.findViewById(R.id.txtinput);

        Button btok=(Button)mView.findViewById(R.id.btok);
        alert.setView(mView);
        final AlertDialog alertDialog=alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etlistname.setText(txt_input.getText().toString());
                alertDialog.dismiss();

            }
        });
        alertDialog.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==KEY)
        {
            if(resultCode== RESULT_OK){

                String namei=data.getStringExtra("inserted_items");

                Toast.makeText(add_reminders.this,namei,Toast.LENGTH_LONG).show();
                input_Items.add(new list_data(namei));
               myAdapter2.notifyDataSetChanged();

            }
else if (resultCode== RESULT_CANCELED)
            {
                Toast.makeText(add_reminders.this,"DATA NOT FOUND",Toast.LENGTH_LONG).show();
            }

        }

    }
}
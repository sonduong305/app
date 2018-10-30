package com.example.sonduong.intentex;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sonduong.intentex.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 123;
    private EditText editHoTen,edtTuoi,edtAddress;

    private TextView txt;
    private Button btnSend;
    private ListView list;
    private static String str="";
    ArrayList<String>   listStudent;
    ArrayAdapter<String> adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = (Button) findViewById(R.id.btn_send);
        editHoTen = (EditText) findViewById(R.id.edt_hoten);
        edtTuoi = (EditText) findViewById(R.id.edt_tuoi);
        edtAddress = (EditText) findViewById(R.id.edt_address);
        list     = (ListView)    findViewById(R.id.list );
        listStudent = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listStudent);
        list.setAdapter(adapter);
        txt = (TextView) findViewById(R.id.dbhi);

    }

    public void insert(View v){
        SQLiteOpenHelper studentDB = new StudentDatabaseHelper(this);
        SQLiteDatabase db = studentDB.getReadableDatabase();
        ((StudentDatabaseHelper) studentDB).insert(db,editHoTen.getText().toString(),Integer.parseInt(edtTuoi.getText().toString()),edtAddress.getText().toString());
    }
    public void getAll(View v){
        SQLiteOpenHelper studentDB = new StudentDatabaseHelper(this);
        SQLiteDatabase db = studentDB.getReadableDatabase();
        Cursor cursor = db.query("student",new String[]{"name","age","address"},null,null,null,null,null,null);
        listStudent.clear();
        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            int age = cursor.getInt(1);
            String address = cursor.getString(2);
            String data = "Ten: "+name+"\nTuoi: "+age+"\nDia chi: "+address;

            listStudent.add(data);

        }
        adapter.notifyDataSetChanged();
        cursor.close();
        db.close();
    }

    public void sendMessage(View v){




        boolean check = false;
        if(edtTuoi.getText().toString().length() == 0 || editHoTen.getText().toString().length() == 0 ){
            check=true;
            Toast.makeText(this, "Nhap thieu thong tin roi", Toast.LENGTH_LONG).show();
            return;
        }
        if(Integer.parseInt(edtTuoi.getText().toString()) == 0){
            check=true;
            Toast.makeText(this, "Number 2 phai khac 012", Toast.LENGTH_LONG).show();
            return;
        }
//        for(int i=0;i<edtTuoi.getText().toString().length();i++) {
//            if(Character.isDigit(edtTuoi.getText().toString().charAt(i))){
//
//            }
//            else {
//                check= true;
//                Toast.makeText(this, "Sai tuoi roi", Toast.LENGTH_LONG).show();
//                return;
//            };
//        }

        Intent intent = new Intent ( this, CalculatorActivity.class);
        //intent.putExtra("MyValue", edtMessage.getText().toString());

        Student student1 = new Student();
        student1.setName(editHoTen.getText().toString());
        student1.setAge(edtTuoi.getText().toString());

        intent.putExtra("MyObject",  student1);

        startActivityForResult(intent, REQ_CODE);
//        if(!check) {
//            int tuoi;
//            tuoi = Integer.parseInt(edtTuoi.getText().toString());
//            if (tuoi > 99 || tuoi < 1) {
//                Toast.makeText(this, "Sai tuoi roi", Toast.LENGTH_LONG).show();
//            } else {
//                str = "";
//                str += editHoTen.getText().toString();
//                str += "\nTuổi :" + edtTuoi.getText().toString();
//                str += "\nĐịa chỉ :" + edtDiaChi.getText().toString() + "\n";
//                //txt.setText(str);
//                listStudent.add(str);
//                adapter.notifyDataSetChanged();
//            }
//        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode == REQ_CODE){
            String data;
            data = intent.getStringExtra("name");
            listStudent.add(data);
            adapter.notifyDataSetChanged();
        }
    }

}

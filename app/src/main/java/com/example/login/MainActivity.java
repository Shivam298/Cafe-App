package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

String orders="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Bundle mbundle=new Bundle();
        mbundle.putString("text",text.getText().toString());*/
        FragmentManager fragmag = getSupportFragmentManager();
        FragmentTransaction fragtran = fragmag.beginTransaction();
      //  frag.setArguments(mbundle);
        fragtran.add(R.id.framelayout, new Fragment_login());
        fragtran.commit();
    }

    public void ordermazza(View v){
        orders=orders+"Mazza ";

    }
    public void ordersprite(View v){
        orders=orders+"Sprite ";

    }
    public void ordercola(View v){
        orders=orders+"Cola ";

    }
    public void ordersandwich(View v){
        orders=orders+"Sandwich ";

    }
    public void orderpineapple(View v){
        orders=orders+"Pineapple ";
    }
    public void ordermango(View v){
        orders=orders+"Mango ";

    }
    public void orderchocalate(View v){
        orders=orders+"Chocalate ";

    }
    public void ordersamosa(View v){
        orders=orders+"Samosa ";

    }
    public void orderroll(View v){
        orders=orders+"Roll ";
    }
    public void finish(View v){
        Toast.makeText(this, "Your Order "+orders, Toast.LENGTH_SHORT).show();
    }
   /* public void menu(View v){
        //Bundle mbundle=new Bundle();
        //  mbundle.putString("text",text.getText().toString());
        FragmentManager fragmag = getSupportFragmentManager();
        FragmentTransaction fragtran = fragmag.beginTransaction();
        //  frag.setArguments(mbundle);
        fragtran.replace(R.id.hello, new Fragment_menu());
        fragtran.commit();*/

}
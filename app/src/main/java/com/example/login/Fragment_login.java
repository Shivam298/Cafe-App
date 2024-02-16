package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_login extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_login.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_login newInstance(String param1, String param2) {
        Fragment_login fragment = new Fragment_login();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login, container, false);
        Button login=v.findViewById(R.id.login);
        Button signup=v.findViewById(R.id.signup);
        TextView username=v.findViewById(R.id.username);
        TextView password=v.findViewById(R.id.password);
        /*String un=username.getText().toString();
        String pass=password.getText().toString();*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TextView username=v.findViewById(R.id.username);
                TextView password=v.findViewById(R.id.password);*/
                String un=username.getText().toString();
                String pass=password.getText().toString();



                Cursor cursor = getActivity().getContentResolver().query(MyContentProvider.CONTENT_URI,
                        null, null, null, null);
                Log.d("tag","cursor  "+cursor);
                if(cursor!=null) {
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {

                            if(un.equals(cursor.getString(cursor.getColumnIndex(MyContentProvider.name)))
                            && pass.equals(cursor.getString(cursor.getColumnIndex(MyContentProvider.title)))
                            ){
                                Toast.makeText(getContext(),"Logged in ",Toast.LENGTH_LONG).show();
                                Fragment fragment=new Fragment_menu();
                                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.framelayout,fragment).addToBackStack("name").commit();
                                break;
                            }

                        cursor.moveToNext();
                    }
                    Toast.makeText(getContext(),"Not Logged in ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Not Logged in ",Toast.LENGTH_LONG).show();
                }

              /*  Fragment fragment=new Fragment_menu();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,fragment).addToBackStack("name").commit();*/
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* TextView username=v.findViewById(R.id.username);
                TextView password=v.findViewById(R.id.password);*/
                String un=username.getText().toString();
                String pass=password.getText().toString();



                ContentValues values = new ContentValues();

                // fetching text from user
                values.put(MyContentProvider.name,un);
                values.put(MyContentProvider.title,pass);
                // inserting into database through content URI
                getActivity().getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
                Toast.makeText(getContext(),"Signed in ",Toast.LENGTH_LONG).show();

                Fragment fragment=new Fragment_menu();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,fragment).addToBackStack("name").commit();
            }
        });
        return v;
    }




}
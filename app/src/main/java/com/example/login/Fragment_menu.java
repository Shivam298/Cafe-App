package com.example.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment_menu extends Fragment {



    public Fragment_menu() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_menu, container, false);
        Button beverage=v.findViewById(R.id.beverage);
        Button pastry=v.findViewById(R.id.pastry);
        Button snacks=v.findViewById(R.id.snacks);
        beverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_beverage fragment=new Fragment_beverage();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,fragment).addToBackStack("name").commit();
            }
        });
        pastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_pastry fragment=new Fragment_pastry();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,fragment).addToBackStack("name").commit();
            }
        });
        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_snacks fragment=new Fragment_snacks();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,fragment).addToBackStack("name").commit();
            }
        });
        return v;
    }
}
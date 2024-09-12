package com.HelloWordPlus.program01_cosc4730_kilduff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldFrag extends Fragment {

    TextView textView;
    EditText inputText;

    public void updateText(View view){
        textView.setText(" Hello There " + inputText.getText( ));
        System.out.println("Button clicked");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hello_world, container, false);
        textView = view.findViewById(R.id.textView);
        inputText = view.findViewById(R.id.inputText);
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_hello_world, container, false);
    }



}
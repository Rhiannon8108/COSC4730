package com.HelloWordPlus.program01_cosc4730_kilduff;
// necessary Android+Jetpack libraries


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// for passing data between different components of an Android application
    // ex. activities and fragments

import android.util.Log;

import androidx.activity.EdgeToEdge;
// allows app to draw behind system bars
    // ex. status and navigation bars

import androidx.appcompat.app.AppCompatActivity;
// base class for activities
    // insuring compatibility support for older versions of android
import androidx.core.graphics.Insets;
// deals with system bars

import androidx.core.view.ViewCompat;
// compatibility support for view related operations across android versions

import androidx.core.view.WindowInsetsCompat;
// Provides a backwards compatible way to handle window insets

import com.HelloWordPlus.program01_cosc4730_kilduff.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements HelloWorldFrag.FragmentHelloWorldBindingListener {


    String TAG = "MainActivityLog";
    HelloWorldFrag fragment_hello_world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        // enables the display to draw behind bars
        EdgeToEdge.enable(this);
        // insets the view with ID 'main'
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Gets the system bars insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // sets padding to avoid overlap with system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            //returns insets so they can be applied
            return insets;
        });

        com.HelloWordPlus.program01_cosc4730_kilduff.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getroot());

        if (savedInstanceState == null){
            fragment_hello_world = new HelloWorldFrag();
            getSupportFragmentManager().beginTransaction().add(binding.mainContainer.getId(), fragment_hello_world).commit();

        }
    }
    @Override
    public void OnTextLogged(String text) {
        Log.v(TAG, "name added" + text);
    }


}

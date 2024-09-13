package com.HelloWordPlus.program01_cosc4730_kilduff;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.HelloWordPlus.program01_cosc4730_kilduff.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements HelloWorldFrag.FragmentHelloWorldBindingListener {

    //tag for logging
    String TAG = "MainActivityLog";
    //declare fragment
    HelloWorldFrag fragment_hello_world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });

        //inflate the program using databinding
        com.HelloWordPlus.program01_cosc4730_kilduff.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //if no saved instance of a fragment add a fragment to the acrivity
        if (savedInstanceState == null){
            fragment_hello_world = new HelloWorldFrag();
            getSupportFragmentManager().beginTransaction().add(binding.main.getId(), fragment_hello_world).commit();

        }
    }
    @Override
    //log the text received from the fragment
    public void OnTextLogged(String text) {
        Log.v(TAG, " name added " + text);
    }


}

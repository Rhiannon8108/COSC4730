package com.HelloWordPlus.program01_cosc4730_kilduff;
// necessary Android+Jetpack libraries


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// for passing data between different components of an Android application
    // ex. activities and fragments

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
    // ex. areas occupied by system bars


public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText inputText;

    // onCreate method is called when the activity is first created
    // entry point for the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enables the display to draw behind bars
        EdgeToEdge.enable(this);

        // sets the content view layout defined in activity_main.xml
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        inputText = (EditText) findViewById(R.id.inputText);

        // insets the view with ID 'main'
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Gets the system bars insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // sets padding to avoid overlap with system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            //returns insets so they can be applied
            return insets;
        });
    }

    public void updateText(View view){
        textView.setText(" Hello There " + inputText.getText( ));
        System.out.println("Button clicked");

    }

}

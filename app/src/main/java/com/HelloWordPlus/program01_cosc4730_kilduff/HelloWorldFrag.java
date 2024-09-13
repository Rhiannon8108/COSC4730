package com.HelloWordPlus.program01_cosc4730_kilduff;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.HelloWordPlus.program01_cosc4730_kilduff.databinding.FragmentHelloWorldBinding;

public class HelloWorldFrag extends Fragment implements Button.OnClickListener{
    //Tag for logging
    String TAG = "FragmentLog";

    //declare binding and listener
    private FragmentHelloWorldBinding binding;
    private FragmentHelloWorldBindingListener listener;
    // Interface for communicating with the activity
    public interface FragmentHelloWorldBindingListener {
        void OnTextLogged(String text);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate using data binding
        binding = FragmentHelloWorldBinding.inflate(inflater, container, false);
        //Set listener for the button click
        binding.buttonHi.setOnClickListener(this);
        //set the initial text
        binding.helloText.setText(" What is your name? ");

        return binding.getRoot();
    }

    public void onClick(View view) {
        //Checks if the clicked via if buttonHi
        if (view == binding.buttonHi) {
            //get get from the input field
            String input_field = binding.userInput.getText().toString();
            // if the input field is not empty
            if (input_field.compareTo("") != 0) {
                binding.helloText.setText(" Hello There " + input_field);
                System.out.println("Button clicked");
            } else {
                //if no input set text
                binding.helloText.setText(" Hello Nobody ");

            }
            // log the value entered into the input field
            Log.v(TAG, "name set: " + input_field);
            //if value is not null notify listener
            if (listener != null) {
                listener.OnTextLogged(input_field);
            }
        }
    }

    //Copied from GitHub examples
    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach (@NonNull Context context){
        super.onAttach(context);
        Activity activity = requireActivity();
        try {
            listener = (MainActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach () {
        super.onDetach();
        listener = null;
    }

}

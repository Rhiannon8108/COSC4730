package com.HelloWordPlus.program01_cosc4730_kilduff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import com.HelloWordPlus.program01_cosc4730_kilduff.databinding.FragmentHelloWorldBinding;

public class HelloWorldFrag extends Fragment {
    String TAG = "FragmentLog";

    private FragmentHelloWorldBinding binding;
    private FragmentHelloWorldBindingListener01 mListener;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHelloWorldBinding.inflate(inflater, container, false);
        binding.button_hi.setOnClickListener(this);
        binding.hello_text.setText(" What is your name? ");

        return binding.getRoot();
    }

    public void onClick(View view) {
        if (view == binding.button_hi) {
            String input_field = binding.user_input.getText().toString();
            if (input_field.compareTo("") != 0) {
                binding.hello_text.setText(" Hello There " + input_field.getText());
                System.out.println("Button clicked");
            } else {
                binding.hello_text.setText(" Hello Nobody ");

            }
            Log.v(TAG, "name set: " + user_input);
            if (listener != null) {
                listener.OnTextLogged(user_input);
            }
        }
    }
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
        mListener = null;
    }

}

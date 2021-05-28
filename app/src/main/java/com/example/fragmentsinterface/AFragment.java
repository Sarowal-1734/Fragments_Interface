package com.example.fragmentsinterface;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class AFragment extends Fragment {

    private FragmentAListener listener;

    private EditText editText;
    private Button buttonSubmit;

    public interface FragmentAListener {
        void onInputASent(String input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        editText = view.findViewById(R.id.editText);
        buttonSubmit = view.findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                listener.onInputASent(input);
            }
        });
        return view;
    }

    public void updateEditText(String newInput) {
        editText.setText(newInput);
    }

    @Override
    public void onAttach(@NonNull @org.jetbrains.annotations.NotNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
package com.example.fragmenttransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PassArguments extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pass_argu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button inp_data = view.findViewById(R.id.input_Data);
        inp_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText send_argu = getView().findViewById(R.id.et_send_argu);
                String send = send_argu.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(Fragment_Argu_Passed.ARGU_KEY,send);
                Fragment_Argu_Passed fragment_argu_passed = new Fragment_Argu_Passed();
                fragment_argu_passed.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_frame,fragment_argu_passed);
                fragmentTransaction.commit();
            }
        });

    }
}

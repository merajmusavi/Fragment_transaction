package com.example.fragmenttransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_frame,new FragmentA());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Button button = findViewById(R.id.remove);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment find = getSupportFragmentManager().findFragmentById(R.id.fragment_frame);
                if (find!=null) {
                    FragmentTransaction fragmentTransaction_remove = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction_remove.remove(find);
                    fragmentTransaction_remove.addToBackStack(null);
                    fragmentTransaction_remove.commit();
                }
            }
        });
    }
}
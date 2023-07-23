package com.example.sweetdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sbz.sweetdialog.SweetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.clickTvId);
        textView.setOnClickListener(v ->


                new SweetDialog.Builder(MainActivity.this)
                .setImage(getDrawable(R.drawable.no_internet))
                .setTitle("Error!!")
                .setBody("No Internet. Please try again!!")
                .setPositiveBtnTxt("Retry")
                .setPositiveListener(() -> {
                    // TODO add your positive logic here
                })
                .setNegativeListener(() -> {
                    // TODO add your negative logic here
                })
                .setCancel(true)
                .build());


    }
}
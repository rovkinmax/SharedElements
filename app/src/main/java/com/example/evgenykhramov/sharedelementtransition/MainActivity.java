package com.example.evgenykhramov.sharedelementtransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View imageView = findViewById(R.id.imageView);
        final View textView = findViewById(R.id.textView);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(imageView, imageView.getTransitionName()),
                        Pair.create(textView, textView.getTransitionName()));


                startActivity(intent, options.toBundle());
            }
        });
    }
}

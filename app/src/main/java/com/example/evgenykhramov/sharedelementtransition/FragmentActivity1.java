package com.example.evgenykhramov.sharedelementtransition;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Window;

public class FragmentActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_activity1);

        Fragment fragment = new Fragment1();
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}

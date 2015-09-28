package com.example.evgenykhramov.sharedelementtransition;

import android.app.Activity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TransitionSet set = new TransitionSet();
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);
        Transition textSize = new TextSizeTransition();
        textSize.addTarget(R.id.textView);
        textSize.addTarget("textView");
        set.addTransition(textSize);

        Transition changeBounds = new ChangeBounds();
        changeBounds.addTarget("textView");
        changeBounds.addTarget("robot");
        set.addTransition(changeBounds);

        getWindow().setSharedElementEnterTransition(set);
        setEnterSharedElementCallback(new EnterSharedElementCallback(14, 35));
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }
}

package com.example.evgenykhramov.sharedelementtransition;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Window;

public class FragmentActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_activity2);

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
        setEnterSharedElementCallback(new EnterSharedElementCallback(40, 45));

        Fragment fragment = new Fragment2();
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}

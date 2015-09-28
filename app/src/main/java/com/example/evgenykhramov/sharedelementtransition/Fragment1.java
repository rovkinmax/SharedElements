package com.example.evgenykhramov.sharedelementtransition;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Evgeny Khramov
 */
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_activity_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final View imageView = view.findViewById(R.id.imageView);
        final View textView = view.findViewById(R.id.textView);


        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FragmentActivity2.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        Pair.create(imageView, imageView.getTransitionName()),
                        Pair.create(textView, textView.getTransitionName()));


                startActivity(intent, options.toBundle());
            }
        });

    }
}

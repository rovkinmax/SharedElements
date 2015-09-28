package com.example.evgenykhramov.sharedelementtransition;

import android.app.SharedElementCallback;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * @author Rovkin Max
 */
public class EnterSharedElementCallback extends SharedElementCallback {
    @Override
    public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
        TextView textView = getTextView(sharedElementNames, sharedElements);
        if (textView == null) {
            return;
        }

        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
    }

    @Override
    public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
        TextView textView = getTextView(sharedElementNames, sharedElements);
        if (textView == null) {
            return;
        }
        // Record the TextView's old width/height.
        int oldWidth = textView.getMeasuredWidth();
        int oldHeight = textView.getMeasuredHeight();

        // Setup the TextView's end values.
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);

        // Re-measure the TextView (since the text size has changed).
        int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        textView.measure(widthSpec, heightSpec);

        // Record the TextView's new width/height.
        int newWidth = textView.getMeasuredWidth();
        int newHeight = textView.getMeasuredHeight();

        // Layout the TextView in the center of its container, accounting for its new width/height.
        int widthDiff = newWidth - oldWidth;
        int heightDiff = newHeight - oldHeight;
        textView.layout(textView.getLeft() - widthDiff / 2, textView.getTop() - heightDiff / 2,
                textView.getRight() + widthDiff / 2, textView.getBottom() + heightDiff / 2);
    }


    private TextView getTextView(List<String> sharedElementNames, List<View> sharedElements) {
        int index = sharedElementNames.indexOf("textView");
        if (index < 0) {
            return null;
        }
        return (TextView) sharedElements.get(index);
    }
}

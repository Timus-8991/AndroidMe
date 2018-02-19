package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by timus-8991 on 20/2/18.
 */

public class BodyPartFragment extends Fragment {

    // TO instantate the fragment
    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // To Inflate Fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part,container, false);

        //
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // Set the first image
        imageView.setImageResource(AndroidImageAssets.getLegs().get(5));

        return  rootView;
    }
}

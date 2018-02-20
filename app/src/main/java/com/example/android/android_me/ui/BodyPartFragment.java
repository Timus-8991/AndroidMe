package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timus-8991 on 20/2/18.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageids;
    private int mListIndex;
    private static final String LIST = "mImageList";
    private static final String INDEX = "mListIndex";

    // TO instantate the fragment
    public BodyPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // To Inflate Fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part,container, false);

        //
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // Set the first image

        if(savedInstanceState != null) {

            mImageids = savedInstanceState.getIntegerArrayList(LIST);
            mListIndex = savedInstanceState.getInt(INDEX);
        }

            if (mImageids != null) {
                imageView.setImageResource(mImageids.get(mListIndex));

//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (mListIndex < mImageids.size() - 1)
//                            mListIndex++;
//                        else
//                            mListIndex = 0;
//
//                        imageView.setImageResource(mImageids.get(mListIndex));
//                    }
//                });

            } else {
                Log.v("BOdyPartFragment", "mImageIDs is null");
            }



        return  rootView;
    }

    public void setmImageids(List<Integer> mImageids) {
        this.mImageids = mImageids;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(LIST, (ArrayList<Integer>) mImageids);
        outState.putInt(INDEX,mListIndex);
    }
}

/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    int headIndex;
    int middleIndex;
    int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if (savedInstanceState == null){

            //Create New Body Part Fragment and display it using fragment manager
            Intent intent = getIntent();
            Bundle b = intent.getExtras();
            headIndex = b.getInt("headIndex");
            middleIndex = b.getInt("middleIndex");
            legIndex = b.getInt("legIndex");

            BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setmImageids(AndroidImageAssets.getHeads());
        headFragment.setmListIndex(headIndex);

        BodyPartFragment middleFragment = new BodyPartFragment();
        middleFragment.setmImageids(AndroidImageAssets.getBodies());
        middleFragment.setmListIndex(middleIndex);

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setmImageids(AndroidImageAssets.getLegs());
        legFragment.setmListIndex(legIndex);


        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.head_container, headFragment).add(R.id.middle_container, middleFragment)
                .add(R.id.leg_container, legFragment).commit();
    }
    }
}

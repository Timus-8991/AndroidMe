package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by timus-8991 on 20/2/18.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    int headIndex;
    int middleIndex;
    int legIndex;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       if(savedInstanceState == null)
//       {
           if(findViewById(R.id.android_me_linear_layout) != null)
           {

               Button button = (Button)findViewById(R.id.next_button);
               button.setVisibility(View.GONE);

               GridView gridView = (GridView) findViewById(R.id.grid_view_images);
               gridView.setNumColumns(2);


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
//       }


    }


    @Override
    public void OnImageSelected(int position) {
        //Toast.makeText(this,"Position" + position,Toast.LENGTH_LONG).show();

        int bodyPartNumber = position/12;

        int ListIndex = position - 12*bodyPartNumber;

        if(getResources().getConfiguration().orientation == 2)
        {
            BodyPartFragment bodyPartFragment = new BodyPartFragment();

            switch(bodyPartNumber)
            {
                case 0: bodyPartFragment.setmImageids(AndroidImageAssets.getHeads());
                        bodyPartFragment.setmListIndex(ListIndex);
                        getSupportFragmentManager().beginTransaction().replace(R.id.head_container,bodyPartFragment).commit();
                        break;
                case 1: bodyPartFragment.setmImageids(AndroidImageAssets.getBodies());
                        bodyPartFragment.setmListIndex(ListIndex);
                        getSupportFragmentManager().beginTransaction().replace(R.id.middle_container,bodyPartFragment).commit();
                        break;
                case 2: bodyPartFragment.setmImageids(AndroidImageAssets.getLegs());
                        bodyPartFragment.setmListIndex(ListIndex);
                        getSupportFragmentManager().beginTransaction().replace(R.id.leg_container,bodyPartFragment).commit();
                        break;

            }
        }

       else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = ListIndex;
                    break;
                case 1:
                    middleIndex = ListIndex;
                    break;
                case 2:
                    legIndex = ListIndex;
                    break;
                default:
                    break;
            }


            Bundle b = new Bundle();
            b.putInt("headIndex", headIndex);
            b.putInt("middleIndex", middleIndex);
            b.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(b);

            Button button = (Button) findViewById(R.id.next_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivityForResult(intent, 1);
                }
            });
        }

    }
}



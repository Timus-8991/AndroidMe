package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

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
    }


    @Override
    public void OnImageSelected(int position) {
        Toast.makeText(this,"Position" + position,Toast.LENGTH_LONG).show();

        int bodyPartNumber = position/12;

        int ListIndex = position - 12*bodyPartNumber;

        int layout = getResources().getConfiguration().orientation;



        switch (bodyPartNumber)
        {
            case  0: headIndex = ListIndex;
                     break;
            case  1: middleIndex = ListIndex;
                     break;
            case  2: legIndex = ListIndex;
                     break;
            default: break;
        }

        Bundle b = new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("middleIndex",middleIndex);
        b.putInt("legIndex",legIndex);

       final  Intent intent = new Intent(this,AndroidMeActivity.class);
        intent.putExtras(b);

        Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent,1);
            }
        });

    }
}



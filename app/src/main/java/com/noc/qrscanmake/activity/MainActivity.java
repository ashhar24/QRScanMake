package com.noc.qrscanmake.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.noc.qrscanmake.R;
import com.noc.qrscanmake.helper.GenerateQR;
import com.noc.qrscanmake.helper.ScanQR;

/**
 * Created by defoliate on 18-10-2015.
 */
public class MainActivity extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bGen = (Button) findViewById(R.id.bGen);
        Button bScan = (Button) findViewById(R.id.bScan);

        bGen.setOnClickListener(this);
        bScan.setOnClickListener(this);
    }

    @Override
    public void onClick (View v)
    {
        Intent i;
        switch(v.getId())
        {
            case R.id.bGen :
                i = new Intent(this, GenerateQR.class);
                startActivity(i);
                break;

            case R.id.bScan :
                i = new Intent(this, ScanQR.class);
                startActivity(i);
                break;
        }
    }
}

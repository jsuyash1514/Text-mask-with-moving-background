package com.example.suyash.movingbackground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public class MainActivity extends AppCompatActivity {

    private GyroscopeObserver gyroscopeObserver;
//    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gyroscopeObserver = new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI/2);

        PanoramaImageView panoramaImageView = (PanoramaImageView)findViewById(R.id.panorama);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);

    }

    @Override
    protected void onResume(){
        super.onResume();
        gyroscopeObserver.register(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        gyroscopeObserver.unregister();
    }
}

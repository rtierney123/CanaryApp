package com.mobile.canary.canary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BlunoLibrary {

    private TextView mTextMessage;
    private Button buttonScan;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText( R.string.title_home );
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText( R.string.title_dashboard );
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText( R.string.title_notifications );
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mTextMessage = (TextView) findViewById( R.id.message );
        BottomNavigationView navigation = (BottomNavigationView) findViewById( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );

        buttonScan = (Button) findViewById(R.id.buttonScan);					//initial the button for scanning the BLE device
        buttonScan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                buttonScanOnClickProcess();										//Alert Dialog for selecting the BLE device
            }
        });
    }

    @Override
    public void onConectionStateChange(connectionStateEnum theconnectionStateEnum) {

    }

    @Override
    public void onSerialReceived(String theString) {

    }
}

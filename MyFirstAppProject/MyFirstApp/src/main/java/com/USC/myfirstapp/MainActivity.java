package com.USC.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private Time time;
    private static Button bluetooth_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        time = new Time();
        time.setToNow();

        bluetooth_button = (Button) findViewById(R.id.button_bluetooth);

        bluetooth_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Bluetooth Button clicked at"+ " "+ getTime(),
                            Toast.LENGTH_LONG).show();
            }
        });

    }

    public String getTime () {

        return time.hour + ":" + time.minute + ":" + time.second;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_settings:
                return true;

            case R.id.patient_profile:
                Toast.makeText(getApplicationContext(), "Open Patient Profile",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.ask_patient:
                Toast.makeText(getApplicationContext(), "Open Ask Patient",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.medical_recs:
                Toast.makeText(getApplicationContext(), "Open Medical Records",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.curr_patient:
                Toast.makeText(getApplicationContext(), "Open Current Patient",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.vital_signs:
                Toast.makeText(getApplicationContext(), "Open Vital Signs",
                        Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

    }

}

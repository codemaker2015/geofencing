package com.vsoft.androidgeofence.activity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.vsoft.androidgeofence.PrefKey;
import com.vsoft.androidgeofence.R;

/**
 * Created by vsoft on 9/7/20.
 *
 */
public class SettingsActivity extends BaseActivity {
    private SeekBar sbRadius;
    private TextView txtRadius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sbRadius = (SeekBar) findViewById(R.id.sb_radius);
        txtRadius = (TextView) findViewById(R.id.txt_radius);

        sbRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                getUtil().savePreference(PrefKey.PREF_RADIUS, (float)progress);
                txtRadius.setText(progress + "m");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        setFormData();
    }

    private void setFormData() {
        float radius = (float) getUtil().getPreference(PrefKey.PREF_RADIUS, 50f);
        sbRadius.setProgress((int) radius);
    }
}

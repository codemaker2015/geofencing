package com.vsoft.androidgeofence;

import android.app.Application;

import com.vsoft.androidgeofence.db.DbHelper;
import com.vsoft.androidgeofence.db.repository.MyGeofenceEventRepository;

/**
 * Created by vsoft on 12/7/20.
 *
 */
public class MyApplication extends Application {
    public static final String DB_NAME = "geofence.db";
    public static final int DB_VERSION = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        // initialize database
        DbHelper.getInstance(this).getWritableDatabase();

        // initialize preference settings
        Util util = Util.getInstance(this);
        float radius = (float) util.getPreference(PrefKey.PREF_RADIUS, -1f);
        if(radius < 0) {
            util.savePreference(PrefKey.PREF_RADIUS, 50f);
        }
    }
}

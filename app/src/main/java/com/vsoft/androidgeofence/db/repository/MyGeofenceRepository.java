package com.vsoft.androidgeofence.db.repository;

import android.content.Context;

import com.guster.skydb.Repository;
import com.vsoft.androidgeofence.db.domain.MyGeofence;


import java.util.List;

/**
 * Created by vsoft on 9/7/20.
 */
public class MyGeofenceRepository extends Repository<MyGeofence> {
    private static MyGeofenceRepository myGeofenceRepository;

    public static MyGeofenceRepository getInstance(Context context) {
        if(myGeofenceRepository == null)
            myGeofenceRepository = new MyGeofenceRepository(context);
        return myGeofenceRepository;
    }

    public MyGeofenceRepository(Context context) {
        super(context, MyGeofence.class);
    }

    public MyGeofence findById(String id) {
        List<MyGeofence> list = findBy("id", id);
        return list.isEmpty()? null : list.get(0);
    }
}

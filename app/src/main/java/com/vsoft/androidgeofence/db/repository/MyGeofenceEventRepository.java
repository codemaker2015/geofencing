package com.vsoft.androidgeofence.db.repository;

import android.content.Context;
import android.database.Cursor;

import com.vsoft.androidgeofence.Util;
import com.vsoft.androidgeofence.db.domain.MyGeofence;
import com.vsoft.androidgeofence.db.domain.MyGeofenceEvent;
import com.guster.skydb.Repository;

import java.util.List;

/**
 * Created by vsoft on 9/7/20.
 *
 */
public class MyGeofenceEventRepository extends Repository<MyGeofenceEvent> {
    private static MyGeofenceEventRepository myGeofenceEventRepository;

    public static MyGeofenceEventRepository getInstance(Context context) {
        if(myGeofenceEventRepository == null)
            myGeofenceEventRepository = new MyGeofenceEventRepository(context);
        return myGeofenceEventRepository;
    }

    public MyGeofenceEventRepository(Context context) {
        super(context, MyGeofenceEvent.class);
    }

    @Override
    public List<MyGeofenceEvent> findAll() {
        List<MyGeofenceEvent> list = super.findAllOrderBy("date", true);

        MyGeofenceRepository repo = MyGeofenceRepository.getInstance(context);
        for(MyGeofenceEvent event : list) {
            MyGeofence geo = repo.findById(event.getId());
            event.setPlaceName(geo.getTitle());
        }

        return list;
    }
}

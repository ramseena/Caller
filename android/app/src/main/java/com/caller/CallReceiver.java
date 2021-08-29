package com.caller;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.facebook.react.HeadlessJsTaskService;


public final class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try{
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                //Toast.makeText(context,"Ringing State",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(context, CallService.class);
                myIntent.putExtra("hasInternet", "incoming call");
                context.startService(myIntent);
                HeadlessJsTaskService.acquireWakeLockNow(context);
            }
            if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
                Toast.makeText(context,"Received State",Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context,"Idle State",Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
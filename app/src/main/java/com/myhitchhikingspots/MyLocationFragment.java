/**
 * Copyright 2014 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.myhitchhikingspots;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.myhitchhikingspots.model.DaoSession;
import com.myhitchhikingspots.model.Spot;
import com.myhitchhikingspots.model.SpotDao;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Getting Location Updates.
 * <p>
 * Demonstrates how to use the Fused Location Provider API to get updates about a device's
 * location. The Fused Location Provider is part of the Google Play services location APIs.
 * <p>
 * For a simpler example that shows the use of Google Play services to fetch the last known location
 * of a device, see
 * https://github.com/googlesamples/android-play-location/tree/master/BasicLocation.
 * <p>
 * This sample uses Google Play services, but it does not require authentication. For a sample that
 * uses Google Play services for authentication, see
 * https://github.com/googlesamples/android-google-accounts/tree/master/QuickStart.
 */
public class MyLocationFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    // UI Widgets
    protected Switch mGetLocationSwitch;
    public ImageButton mSaveSpotButton, mArrivedButton;
    public ImageButton mGotARideButton, mTookABreakButton;
    public LinearLayout mSaveSpotPanel, mEvaluatePanel, mArrivedPanel;
    protected TextView mLastUpdateTimeTextView;
    protected TextView mLatitudeTextView;
    protected TextView mLongitudeTextView;
    //protected ImageButton extra_image_button;

    // UI Labels.
    protected String mLatitudeLabel;
    protected String mLongitudeLabel;
    protected String mLastUpdateTimeLabel;

    protected TrackLocationBaseActivity parentActivity;

    protected static final String TAG = "my-location-fragment";

    /*protected AudioManager mAudioManager;
    protected ComponentName mReceiverComponent;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_location_fragment_layout, container, false);

        // Locate the UI widgets.
        mGetLocationSwitch = (Switch) rootView.findViewById(R.id.update_location_switch);

        mSaveSpotPanel = (LinearLayout) rootView.findViewById(R.id.save_spot_panel);
        mEvaluatePanel = (LinearLayout) rootView.findViewById(R.id.evaluate_panel);
        mArrivedPanel = (LinearLayout) rootView.findViewById(R.id.arrived_panel);

        mSaveSpotButton = (ImageButton) rootView.findViewById(R.id.save_hitchhiking_spot_button);
        mArrivedButton = (ImageButton) rootView.findViewById(R.id.arrived_button);
        mGotARideButton = (ImageButton) rootView.findViewById(R.id.got_a_ride_button);
        mTookABreakButton = (ImageButton) rootView.findViewById(R.id.break_button);

        mLatitudeTextView = (TextView) rootView.findViewById(R.id.latitude_text);
        mLongitudeTextView = (TextView) rootView.findViewById(R.id.longitude_text);
        mLastUpdateTimeTextView = (TextView) rootView.findViewById(R.id.last_update_time_text);
        //extra_image_button = (ImageButton) rootView.findViewById(R.id.extra_image_button);

        // Set UI labels.
        mLatitudeLabel = getResources().getString(R.string.latitude_label);
        mLongitudeLabel = getResources().getString(R.string.longitude_label);
        mLastUpdateTimeLabel = getResources().getString(R.string.last_update_time_label);


        mGetLocationSwitch.setEnabled(false);
        mSaveSpotPanel.setVisibility(View.GONE);//setEnabled(false);
        mEvaluatePanel.setVisibility(View.GONE);//setEnabled(false);

        parentActivity = (TrackLocationBaseActivity) getActivity();

        mGetLocationSwitch.setOnCheckedChangeListener(this);
        mSaveSpotButton.setOnClickListener(this);
        mArrivedButton.setOnClickListener(this);
        mGotARideButton.setOnClickListener(this);
        mTookABreakButton.setOnClickListener(this);
        //extra_image_button.setOnClickListener(this);


      /*   mAudioManager =  (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
        mReceiverComponent = new ComponentName(getContext(), RemoteControlReceiver.class);

       receiver = new RemoteControlReceiver(new Handler()); // Create the receiver
        getActivity().registerReceiver(receiver, new IntentFilter("some.action")); // Register receiver

        getActivity().sendBroadcast(new Intent("some.action")); // Send an example Intent
*/
        return rootView;
    }


    //RemoteControlReceiver receiver;
    Spot mCurrentWaitingSpot;
    boolean mIsWaitingForARide;


    @Override
    public void onResume() {
        super.onResume();
        //extra_image_button.setImageAlpha(127);

        MyHitchhikingSpotsApplication context = ((MyHitchhikingSpotsApplication) parentActivity.getApplicationContext());
        mCurrentWaitingSpot = context.getCurrentSpot();

        if (mCurrentWaitingSpot == null || mCurrentWaitingSpot.getIsWaitingForARide() == null)
            mIsWaitingForARide = false;
        else
            mIsWaitingForARide = mCurrentWaitingSpot.getIsWaitingForARide();

        DaoSession daoSession = context.getDaoSession();
        //insertSampleData(daoSession);
        SpotDao spotDao = daoSession.getSpotDao();
        List<Spot> spotList = spotDao.queryBuilder().orderDesc().orderDesc(SpotDao.Properties.StartDateTime).limit(1).list();
        if (spotList.size() == 0 || (spotList.get(0).getIsDestination() != null && spotList.get(0).getIsDestination()))
            mArrivedPanel.setVisibility(View.GONE);
        else
            mArrivedPanel.setVisibility(View.VISIBLE);


        /*if(mIsWaitingForARide) {
        if (Build.VERSION.SDK_INT >= 21 )
        {
            MediaSession mSession =  new MediaSession(getContext(), getContext().getPackageName());
        Intent intent = new Intent(getContext(), RemoteControlReceiver.class);
        PendingIntent pintent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mSession.setMediaButtonReceiver(pintent);
        mSession.setActive(true);
        //mediaHandler.postDelayed(this, 1000L);
        }
        else
            mAudioManager.registerMediaButtonEventReceiver(mReceiverComponent);
        } else {
            mAudioManager.unregisterMediaButtonEventReceiver(mReceiverComponent);
        }*/

        updateUILocationSwitch();

    }

    public void saveRegularSpotButtonHandler() {
        saveSpotButtonHandler(false);
    }

    public void saveDestinationSpotButtonHandler() {
        saveSpotButtonHandler(true);
    }

    /**
     * Handles the Save Spot button and save current location. Does nothing if
     * updates have already been requested.
     */
    public void saveSpotButtonHandler(boolean isDestination) {
        if (!parentActivity.mRequestingLocationUpdates) {
            Toast.makeText(getActivity(), getResources().getString(R.string.save_spot_location_disabled_message),
                    Toast.LENGTH_SHORT).show();
        } else {
            Spot spot = null;
            if (!mIsWaitingForARide) {
                spot = new Spot();
                spot.setIsDestination(isDestination);
                spot.setLatitude(parentActivity.mCurrentLocation.getLatitude());
                spot.setLongitude(parentActivity.mCurrentLocation.getLongitude());
                spot.setStartDateTime(parentActivity.mLastUpdateTime);
                Log.i(TAG, "Save spot button handler: a new spot is being created.");
            } else {
                spot = mCurrentWaitingSpot;
                Log.i(TAG, "Save spot button handler: a spot is being edited.");
            }

            Intent intent = new Intent(getContext(), SpotFormActivity.class);
            intent.putExtra("Spot", spot);
            startActivityForResult(intent, 1);
        }
    }

    public void gotARideButtonHandler() {
        //TODO: make this in a not hardcoded way!
        mCurrentWaitingSpot.setAttemptResult(1);
        evaluateSpotButtonHandler();
    }

    public void tookABreakButtonHandler() {
        //TODO: make this in a not hardcoded way!
        mCurrentWaitingSpot.setAttemptResult(2);
        evaluateSpotButtonHandler();
    }

    /**
     * Handles the Got A Ride button, and requests removal of location updates. Does nothing if
     * updates were not previously requested.
     */
    public void evaluateSpotButtonHandler() {
        if (mIsWaitingForARide) {
            Intent intent = new Intent(parentActivity.getApplicationContext(), SpotFormActivity.class);
            intent.putExtra("Spot", mCurrentWaitingSpot);
            startActivityForResult(intent, 1);
            //mIsWaitingForARide = false;
            //updateUISaveButtons();
        }
    }

    public void getLocationSwitchHandler(View view) {
        Switch s = (Switch) view;
        if (s.isChecked()) {
            parentActivity.mRequestingLocationUpdates = true;
            parentActivity.startLocationUpdates();
        } else {
            parentActivity.mRequestingLocationUpdates = false;
            parentActivity.stopLocationUpdates();
        }
        updateUILocationSwitch();
    }


    protected void updateUILocationSwitch() {
        if (parentActivity.mGoogleApiClient == null || !parentActivity.mGoogleApiClient.isConnected()) {
            mGetLocationSwitch.setEnabled(false);
        } else {
            mGetLocationSwitch.setEnabled(true);
            mGetLocationSwitch.setChecked(parentActivity.mRequestingLocationUpdates);
        }
        updateUISaveButtons();
    }

    /**
     * Updates the latitude, the longitude, and the last location time in the UI.
     */
    protected void updateUILabels() {
        if (parentActivity.mCurrentLocation != null) {
            mLatitudeTextView.setText(String.format("%s: %f", mLatitudeLabel,
                    parentActivity.mCurrentLocation.getLatitude()));
            mLongitudeTextView.setText(String.format("%s: %f", mLongitudeLabel,
                    parentActivity.mCurrentLocation.getLongitude()));
            mLastUpdateTimeTextView.setText(String.format("%s: %s", mLastUpdateTimeLabel,
                    dateToString(parentActivity.mLastUpdateTime)));
        }
    }


    /**
     * Ensures that only one button is enabled at any time. The Start Updates button is enabled
     * if the user is not requesting location updates. The Stop Updates button is enabled if the
     * user is requesting location updates.
     */
    protected void updateUISaveButtons() {
        if (mIsWaitingForARide) {
            mSaveSpotPanel.setVisibility(View.GONE);//setEnabled(false);
            mEvaluatePanel.setVisibility(View.VISIBLE);//setEnabled(true);
        } else {
            if (parentActivity.mGoogleApiClient == null || !parentActivity.mGoogleApiClient.isConnected() || parentActivity.mCurrentLocation == null) {
                mSaveSpotPanel.setVisibility(View.GONE);//setEnabled(false);
            } else {
                //mSaveSpotPanel.setEnabled(parentActivity.mRequestingLocationUpdates);
                if (parentActivity.mRequestingLocationUpdates)
                    mSaveSpotPanel.setVisibility(View.VISIBLE);
                else
                    mSaveSpotPanel.setVisibility(View.GONE);

            }
            mEvaluatePanel.setVisibility(View.GONE);//setEnabled(false);
        }
    }


    private String dateToString(Date dt) {
        return DateFormat.getTimeInstance().format(dt);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_hitchhiking_spot_button:
                saveRegularSpotButtonHandler();
                break;
            case R.id.arrived_button:
                saveDestinationSpotButtonHandler();
                break;
            case R.id.got_a_ride_button:
                gotARideButtonHandler();
                break;
            case R.id.break_button:
                tookABreakButtonHandler();
                break;

            default:
                //extra_image_button.setImageAlpha(255);
                if (mIsWaitingForARide) {
                    Toast.makeText(getContext(), getResources().getString(R.string.got_a_ride_button_text), Toast.LENGTH_LONG).show();
                    evaluateSpotButtonHandler();
                } else {
                    Toast.makeText(getContext(), getResources().getString(R.string.save_spot_button_text), Toast.LENGTH_LONG).show();
                    saveRegularSpotButtonHandler();
                }
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.update_location_switch)
            getLocationSwitchHandler(buttonView);
    }
}

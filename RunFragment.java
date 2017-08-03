package com.android.huminskiy1325.runtracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cubru on 01.08.2017.
 */

public class RunFragment extends Fragment {

    private Unbinder unbinder;
    private RunManager mRunManager;

    @BindView(R.id.run_startButton)
    Button mStartButton;
    @BindView(R.id.run_stopButton)
    Button mStopButton;

    @BindView(R.id.run_startedTextView)
    TextView mStartedTextView;
    @BindView(R.id.run_latitudeTextView)
    TextView mLatitudeTextView;
    @BindView( R.id.run_longitudeTextView)
    TextView mLongitudeTextView;
    @BindView(R.id.run_altitudeTextView)
    TextView mAltitudeTextView;
    @BindView(R.id.run_durationTextView)
    TextView mDurationTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mRunManager = RunManager.get(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_run, container, false);
        unbinder = ButterKnife.bind(this, view);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRunManager.startLocationUpdates();
                updateUI();
            }
        });
        mStopButton = (Button)view.findViewById(R.id.run_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRunManager.stopLocationUpdates();
                updateUI();
            }
        });
        updateUI();

        return view;
    }


//    @OnClick(R.id.run_startButton)
//    public void runStart(){
//        mRunManager.startLocationUpdates();
//        updateUI();
//    }

    private void updateUI() {
        boolean started = mRunManager.isTrackingRun();

        mStartButton.setEnabled(!started);
        mStopButton.setEnabled(started);
    }

//    @OnClick(R.id.run_stopButton)
//    public void runStop(){
//        mRunManager.startLocationUpdates();
//        updateUI();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

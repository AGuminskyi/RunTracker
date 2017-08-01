package com.android.huminskiy1325.runtracker;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RunActivity extends SingleFragmenActivity {

    @Override
    protected Fragment createFragment() {
        return new RunFragment();
    }
}

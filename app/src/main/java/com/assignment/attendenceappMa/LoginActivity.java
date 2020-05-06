package com.assignment.attendenceappMa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//
        startActivity(new Intent(LoginActivity.this, ModuleDashboardActivity.class));
        finish();
//        Bundle Moduledashb = new Bundle();
//        onCreate(tempBundle);
    }
}
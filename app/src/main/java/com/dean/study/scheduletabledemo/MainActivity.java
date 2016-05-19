package com.dean.study.scheduletabledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {


    private ScheduleTableView mTableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTableView = (ScheduleTableView) findViewById(R.id.table_view);
        setTable();
    }

    private void setTable() {
        String s = TimeUtils.s_long_2_str(System.currentTimeMillis());
        try {
            String[] days = WeekToDay.getStringDate(s);
            mTableView.setDays(days);
            mTableView.setTimeViews(new String[]{"11", "23", "42", "61"});
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

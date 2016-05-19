package com.dean.study.scheduletabledemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 日程控件
 * Created by TianWei on 2016/5/18.
 */

public class ScheduleTableView extends LinearLayout {
    //显示表格时间view
    @Nullable
    @Bind(R.id.monday_morning)
    TextView monday_morning;
    @Nullable
    @Bind(R.id.monday_afternoon)
    TextView monday_afternoon;
    @Nullable
    @Bind(R.id.monday_night)
    TextView monday_night;
    @Nullable
    @Bind(R.id.tuesday_morning)
    TextView tuesday_morning;
    @Nullable
    @Bind(R.id.tuesday_afternoon)
    TextView tuesday_afternoon;
    @Nullable
    @Bind(R.id.tuesday_night)
    TextView tuesday_night;
    @Nullable
    @Bind(R.id.wednesday_morning)
    TextView wednesday_morning;
    @Nullable
    @Bind(R.id.wednesday_afternoon)
    TextView wednesday_afternoon;
    @Nullable
    @Bind(R.id.wednesday_night)
    TextView wednesday_night;
    @Nullable
    @Bind(R.id.thursday_morning)
    TextView thursday_morning;
    @Nullable
    @Bind(R.id.thursday_afternoon)
    TextView thursday_afternoon;
    @Nullable
    @Bind(R.id.thursday_night)
    TextView thursday_night;
    @Nullable
    @Bind(R.id.friday_morning)
    TextView friday_morning;
    @Nullable
    @Bind(R.id.friday_afternoon)
    TextView friday_afternoon;
    @Nullable
    @Bind(R.id.friday_night)
    TextView friday_night;
    @Nullable
    @Bind(R.id.saturday_morning)
    TextView saturday_morning;
    @Nullable
    @Bind(R.id.saturday_afternoon)
    TextView saturday_afternoon;
    @Nullable
    @Bind(R.id.saturday_night)
    TextView saturday_night;
    @Nullable
    @Bind(R.id.sunday_morning)
    TextView sunday_morning;
    @Nullable
    @Bind(R.id.sunday_afternoon)
    TextView sunday_afternoon;
    @Nullable
    @Bind(R.id.sunday_night)
    TextView sunday_night;
    //表头日期
    @Nullable
    @Bind(R.id.week_monday_time)
    TextView monday_time;
    @Nullable
    @Bind(R.id.week_tuesday_time)
    TextView tuesday_time;
    @Nullable
    @Bind(R.id.week_wednesday_time)
    TextView wednesday_time;
    @Nullable
    @Bind(R.id.week_thursday_time)
    TextView thursday_time;
    @Nullable
    @Bind(R.id.week_friday_time)
    TextView friday_time;
    @Nullable
    @Bind(R.id.week_saturday_time)
    TextView saturday_time;
    @Nullable
    @Bind(R.id.week_sunday_time)
    TextView sunday_time;
    //表头星期
    @Nullable
    @Bind(R.id.week_monday_title)
    TextView monday_title;
    @Nullable
    @Bind(R.id.week_tuesday_title)
    TextView tuesday_title;
    @Nullable
    @Bind(R.id.week_wednesday_title)
    TextView wednesday_title;
    @Nullable
    @Bind(R.id.week_thursday_title)
    TextView thursday_title;
    @Nullable
    @Bind(R.id.week_friday_title)
    TextView friday_title;
    @Nullable
    @Bind(R.id.week_saturday_title)
    TextView saturday_title;
    @Nullable
    @Bind(R.id.week_sunday_title)
    TextView sunday_title;


    private List<String> mDays = new ArrayList<>();//保存当前一周的日期
    private Map<String, TextView> mTimeViews = new HashMap();//保存各个时间的view
    private List<TextView> mWeekTitles = new ArrayList<>();//表头星期
    private List<TextView> mWeekTimes = new ArrayList<>();//表头日期
    private Context mContext;

    public ScheduleTableView(Context context) {
        this(context, null);
    }

    public ScheduleTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        View.inflate(context, R.layout.show_offline_table, this);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTimeViews.put("11", monday_morning);
        mTimeViews.put("12", monday_afternoon);
        mTimeViews.put("13", monday_night);
        mTimeViews.put("21", tuesday_morning);
        mTimeViews.put("22", tuesday_afternoon);
        mTimeViews.put("23", tuesday_night);
        mTimeViews.put("31", wednesday_morning);
        mTimeViews.put("32", wednesday_afternoon);
        mTimeViews.put("33", wednesday_night);
        mTimeViews.put("41", thursday_morning);
        mTimeViews.put("42", thursday_afternoon);
        mTimeViews.put("43", thursday_night);
        mTimeViews.put("51", friday_morning);
        mTimeViews.put("52", friday_afternoon);
        mTimeViews.put("53", friday_night);
        mTimeViews.put("61", saturday_morning);
        mTimeViews.put("62", saturday_afternoon);
        mTimeViews.put("63", saturday_night);
        mTimeViews.put("71", sunday_morning);
        mTimeViews.put("72", sunday_afternoon);
        mTimeViews.put("73", sunday_night);

        mWeekTitles.add(monday_title);
        mWeekTitles.add(tuesday_title);
        mWeekTitles.add(wednesday_title);
        mWeekTitles.add(thursday_title);
        mWeekTitles.add(friday_title);
        mWeekTitles.add(saturday_title);
        mWeekTitles.add(sunday_title);

        mWeekTimes.add(monday_time);
        mWeekTimes.add(tuesday_time);
        mWeekTimes.add(wednesday_time);
        mWeekTimes.add(thursday_time);
        mWeekTimes.add(friday_time);
        mWeekTimes.add(saturday_time);
        mWeekTimes.add(sunday_time);
    }

    public void setDays(List<String> mDays) {
        String currentTime = TimeUtils.ss_long_2_str(System.currentTimeMillis());
        List<String> days = new ArrayList<>();
        if (mDays != null) {
            for (String day : mDays) {
                if (day.length() == 10) {
                    String[] split = day.split("-");
                    String substring = split[1] + "-" + split[2];
                    days.add(substring);
                }
                if (day.length() == 8) {
                    String substring_ = day.substring(4, 6);
                    String _substring = day.substring(6, 8);
                    String substring = substring_ + "-" + _substring;
                    days.add(substring);
                }
            }
            for (int i = 0; i < days.size(); i++) {
                if (currentTime.equals(days.get(i))) {
                    mWeekTitles.get(i).setTextColor(Color.RED);
                    mWeekTimes.get(i).setText("今日");
                    mWeekTimes.get(i).setTextColor(Color.RED);
                } else {
                    mWeekTimes.get(i).setText(days.get(i));
                }
            }
        }

    }

    public void setDays(String[] mDays) {
        String currentTime = TimeUtils.ss_long_2_str(System.currentTimeMillis());
        List<String> days = new ArrayList<>();
        if (mDays != null) {
            for (String day : mDays) {
                if (day.length() == 10) {
                    String[] split = day.split("-");
                    String substring = split[1] + "-" + split[2];
                    days.add(substring);
                }
                if (day.length() == 8) {
                    String substring_ = day.substring(4, 6);
                    String _substring = day.substring(6, 8);
                    String substring = substring_ + "-" + _substring;
                    days.add(substring);
                }
            }
            for (int i = 0; i < days.size(); i++) {
                if (currentTime.equals(days.get(i))) {
                    mWeekTitles.get(i).setTextColor(Color.RED);
                    mWeekTimes.get(i).setText("今日");
                    mWeekTimes.get(i).setTextColor(Color.RED);
                } else {
                    mWeekTimes.get(i).setText(days.get(i));
                }
            }
        }

    }

    private void setDaysView() {
        String currentTime = TimeUtils.ss_long_2_str(System.currentTimeMillis());
        List<String> days = new ArrayList<>();
        if (mDays != null) {
            for (String day : mDays) {
                if (day.length() == 10) {
                    String[] split = day.split("-");
                    String substring = split[1] + "-" + split[2];
                    days.add(substring);
                }
                if (day.length() == 8) {
                    String substring_ = day.substring(4, 6);
                    String _substring = day.substring(6, 8);
                    String substring = substring_ + "-" + _substring;
                    days.add(substring);
                }
            }
            for (int i = 0; i < days.size(); i++) {
                if (currentTime.equals(days.get(i))) {
                    mWeekTitles.get(i).setTextColor(Color.RED);
                    mWeekTimes.get(i).setText("今日");
                    mWeekTimes.get(i).setTextColor(Color.RED);
                } else {
                    mWeekTimes.get(i).setText(days.get(i));
                }
            }
        }

    }

    public void setTimeViews(List<String> times) {
        for (String time : times) {
            if (mTimeViews.containsKey(time)) {
                TextView textView = mTimeViews.get(time);
                textView.setBackgroundResource(R.drawable.textview_table_green);
                textView.setText("可预约");
                textView.setTextColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);
            }

        }
    }

    public void setTimeViews(String[] times) {
        for (String time : times) {
            if (mTimeViews.containsKey(time)) {
                TextView textView = mTimeViews.get(time);
                textView.setBackgroundResource(R.drawable.textview_table_green);
                textView.setText("可预约");
                textView.setTextColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);
            }

        }
    }

}

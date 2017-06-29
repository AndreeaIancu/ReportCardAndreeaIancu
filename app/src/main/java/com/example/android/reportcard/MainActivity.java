package com.example.android.reportcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportCard oneReportCard = new ReportCard();
        oneReportCard.setStudentName("John Smith");
        oneReportCard.setYear(2017);
        oneReportCard.setGradingPeriod(1);
        oneReportCard.setNoOfSubjects(8);
        String[] subjectsThisGradingPeriod = new String[]{"Reading","Written Communications",
                "Science","Mathematics","Social Studies","Art","Music","Physical Education"};
        oneReportCard.setSubjectMatters(subjectsThisGradingPeriod);
        oneReportCard.setGrade("reading",7.5);
        oneReportCard.setGrade("written communications", 9.00);
        oneReportCard.setGrade("science",10.00);
        oneReportCard.setGrade("mathematics",10.00);
        oneReportCard.setGrade("Art",8.00);
        oneReportCard.setGrade("Music",5.00);
        oneReportCard.setGrade("Physical education",6.00);
        oneReportCard.setGrade("social studies",10.00);
        oneReportCard.setPresence(40);
        oneReportCard.setAbsence(1);
        oneReportCard.setTardy(2);
        String reportCardSummary = oneReportCard.toString();
        Log.v("MainActivity",reportCardSummary);

    }
}

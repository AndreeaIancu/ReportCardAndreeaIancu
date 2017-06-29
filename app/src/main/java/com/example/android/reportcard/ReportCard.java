package com.example.android.reportcard;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by andreea on 28-Jun-17.
 */

public class ReportCard {

    /*
    Declaration of variable storing the student name.
     */
    private String mStudentName;

    /*
    Declaration of variable storing the number of subjects studied for a grading period.
         */
    private int mSubjectNo;

    /*
    Declaration of variable storing the subjects in which the student is enrolled for
    a specific grading period.
    This variable is an array of Strings storing the name of the subject matters such as
    Math, Reading, etc. for a specific grading period. The names of the subject matters
    can change from trimester (grading period) to trimester for a student as he progresses
    through the study period.
     */
    private String[] mSubjectName;

    /*
    Declaration of variable storing the grades for subjects in which the student is enrolled for
    a specific grading period.
    This variable is an array of doubles storing the grades for each subject matter such as
    Math, Reading, etc. for a specific grading period.
    Each grade must have a value between 1 and 10.
     */
    private double[] mSubjectGrade;

    /*
    Declaration of variable storing the grading period within a specific school year.
    There can by only four grading periods within one school year.
     */
    private int mGradingPeriod;

    /*
    Declaration of variable storing the value of the specific school year for which the
    ReportCard object is being created.
     */
    private int mSchoolYear;

    /*
    Declaration of variable storing the number of times the student was on time for his classes
    throughout the trimester.
     */
    private int mPresent;

    /*
    Declaration of variable storing the number of times the student was absent throughout
    the trimester.
     */
    private int mAbsent;

    /*
    Declaration of variable storing the number of times the student showed up late for a class
    throughout the trimester.
     */
    private int mTardy;

    /*
    * Create a new ReportCard object.
    *
    * A ReportCard object should contain information regarding
    * student's grades for one of the 4 grading periods within the school year.
    * The subjects studied can differ from one trimester to another, but the student cannot be
    * enrolled in more than 8 subjects in one given grading period.
    * The constructor initializes the object's attributes to a default value.
    * All actual values - like a real student name, name of the subjects studied, etc. -
    * will be added using setter methods.
    * */
    public ReportCard() {

        mStudentName = "Default Name";
        mGradingPeriod = 0;
        mSchoolYear = 0;

        mSubjectNo = 8;
        mSubjectName = new String[mSubjectNo];
        mSubjectGrade = new double[mSubjectNo];

        /*
        Defining a for loop in order to initialize the two arrays for the name of subjects studied
        and the corresponding grade. Local variable i is used to keep count of the position in the
        array.
         */
        for ( int i = 0; i < mSubjectNo; i++ ) {
            mSubjectName[i] = "Subject Matter " + i;
            mSubjectGrade[i] = 0;
        }

        mPresent = 0;
        mAbsent = 0;
        mTardy = 0;
    }

    /*
    This method sets the student name for a ReportCard object.
     */
    public void setStudentName(String name) {
        mStudentName = name;
    }

    /*
    This method returns the student name for a ReportCard object.
     */
    public String getStudentName (){
        return mStudentName;
    }

    /*
    This method sets the school year for a ReportCard object.
    The year variable should contain four digits.
    In addition to setting the year value, the method returns true if a correct format year is
    provided and false if not. It also prints a log message in case the exception is found.
     */
    public boolean setYear(int currentYear) {
        int noOfDigits = String.valueOf(currentYear).length();
        if (noOfDigits !=4){
            Log.v("ReportCard","Not a valid year format. A four digit number is expected");
            return false;
        }
        mSchoolYear = currentYear;
        return true;
    }

    /*
    This method returns the value of the school year for a ReportCard Object.
     */
    public int getYear(){
        if (mSchoolYear == 0) {
            Log.v("ReportCard","No school year assigned for this ReportCard");
        }
        return mSchoolYear;

    }

    /*
    This method sets the number of Subjects studied within a grading period. A maximum of 8 is allowed.
     */
    public boolean setNoOfSubjects (int number){
        int maxSubj = 8;
        if (number > maxSubj){
            Log.v("ReportCard","Maximum subjects allowed per grading period is " + maxSubj);
            return false;
        }
        mSubjectNo = number;
        return true;
    }

    /*
    This method returns the number of subjects for which a student is enrolled for a grading period.
     */

    public int getNoOfSubjects (){
        if (mSubjectNo == 0){
            Log.v("ReportCard","Student not enrolled for classes for grading period " + mGradingPeriod +
                    "for the school year " + mSchoolYear);
        }
        return mSubjectNo;
    }

    /*
   This method sets the grading period for a ReportCard object.
   There are only 4 grading periods for one school year, hence a constraint must be defined.
   When the integer input for this variable is not between the interval [1,4] a log message
   should be printed, with a specific exception message. In addition to setting the grading period
   this method also returns a boolean value which is useful for catching exceptions in the code
   using the ReportCard object.
    */
    public boolean setGradingPeriod(int gradingPeriodNumber) {
        if (gradingPeriodNumber >= 1 && gradingPeriodNumber <= 4){
            mGradingPeriod = gradingPeriodNumber;
            return true;
        }
        else {
            Log.v("ReportCard","Invalid grading period, value in interval [1,4] expected");
            return false;
        }
    }

    /*
    This method returns the integer number representing the grading period of a ReportCard.
     */
    public int getGradingPeriod() {
        return mGradingPeriod;
    }

    /*
    * This method sets the subject matters for a ReportCard object for a given grading period.
    * It receives as input parameters an array of strings representing the
    * subject matters studied in a specific trimester / grading period.
    * The if clause ensures that only a string with an index equal to the max no. of
    * subject per grading period (mSubjectNo) is allowed as input parameter. Otherwise print
    * exception log. In addition to setting the names of the subjects studies per grading period
    * this method returns a boolean value which can be used further in code and deal with exceptions
    * such as when the user tries to input more than 8 subject matters per grading period.
    */
    public boolean setSubjectMatters(String[] names) {
        if (names.length != mSubjectNo){
            Log.v("ReportCard","invalid number of subjects per grading period. " + mSubjectNo +
                    " subject matters expected");
            return false;
        }

        for ( int i = 0; i < mSubjectNo; i++ ) {
            mSubjectName[i] = names[i];
        }
        return true;
    }

    /*
    This method returns an array of Strings representing all subject matters for a grading period.
     */

    public String[] getAllSubjectMatters (){
        return mSubjectName;
    }

    /*
    This method sets one subject matter at a specific index position in the SubjectMatters array
    variable. If an invalid index position is provided an exception log statement should be printed.
    The method returns a boolean value to be used further in code for handling exceptions.
     */
    public boolean setSubjectMatter (int index,String name){
        if (index <1 || index >mSubjectNo){
            Log.v("ReportCard","Invalid index position, expected value in interval [1,"+mSubjectNo +"] expected");
            return false;
        }
        mSubjectName [index]= name;
        return true;
    }

    /*
    This method returns the name of a subject matter at a specific position in the array.
     */
    public String getSubjectMatter (int index){
        return mSubjectName[index];
    }

    /*
    * This method sets the grades for the entire array of subjecs in a grading period.
    * It receives as input parameters an array of doubles representing the
    * grades obtained in a specific trimester / grading period.
    * The first if clause ensures that only an array with an index equal to the max no. of
    * subjects per grading period (mSubjectNo) is allowed as input parameter. Otherwise print
    * exception log.
    * The first for loop ensures that the accepted values of the grades must be between 1 and 10,
    * with 10 being the highest grade.
    * In addition to setting the grades per grading period
    * this method returns a boolean value which can be used further in code and deal with exceptions
    * such as when the user tries to input more than 8 grades per grading period or the grade values
    * is not between 1 and 10.
    */
    public boolean setGrades(double[] grades) {
        if (grades.length != mSubjectNo){
            Log.v("ReportCard","invalid number of grades per grading period. " + mSubjectNo +
                    " grades corresponding to the same number of subject matters expected");
            return false;
        }

        for (int i=0;grades[i]<1 || grades[i]>10;i++){
            Log.v("ReportCard","invalid grade, a value between [1,10] expected");
            return false;
        }

        for ( int i = 0; i < mSubjectNo; i++ ) {
            mSubjectGrade[i] = grades[i];
        }
        return true;
    }

    /*
    This method returns an array containing all the grades in a grading period.
     */
    public double[] getAllGrades (){
        return mSubjectGrade;
    }

    /*
    This method sets the grade for one subject matter at a specific index position in the array
    variable. If an invalid index position is provided an exception log statement should be printed.
    If the grade assigned is not between 1 and 10 an exception log statement should be printed
    The method returns a boolean value to be used further in code for handling exceptions.
     */
    public boolean setGrade (String name, double myGrade){
        int index = -1; // local variable to store the index position that matches the subject matter name
        for (int i=0; i<mSubjectNo;i++){
            if (name.equalsIgnoreCase(mSubjectName[i])){
                index = i;
            }
        }

        if (index == -1) {
            Log.v("ReportCard","The name of the subject matter " + name + " is not within" +
                    " the areas studied within this grading period or is misspelled.");
            return false;
        }

        mSubjectGrade[index] = myGrade;
        return true;

    }

    /*
    This method returns the grade of a subject matter. It receives as an input parameter the name
    of the subject matter. If the subject matter is not within the ones assigned for this grading
    period or is misspelled, then it will return 0 and print a log message. If there is no grade
    assigned it will return the default value of 0 and print a log message.
     */
    public double getGrade (String name){
        int index = -1; // local variable to store the index position that matches the subject matter name
        for (int i=0; i < mSubjectNo; i++) {
            if (name.equalsIgnoreCase(mSubjectName[i])) {
                index = i;
            }
        }

        if (index == -1){
            Log.v("ReportCard","The name of the subject matter " + name + " is not within" +
                        " the areas studied within this grading period or is misspelled.");
        }
        if (mSubjectGrade[index] == 0){
            Log.v("ReportCard","There is no grade assigned for " + mSubjectName[index]);
            return mSubjectGrade[index];
        }
        else{
            return mSubjectGrade[index];
        }

    }

    /*
    This method sets the number of presences in a given grading period.
     */
    public void setPresence(int noOfPresences) {
        mPresent = noOfPresences;
    }

    /*
    This method returns the number of presences in a given grading period.
     */
    public int getPresences (){
        return mPresent;
    }

    /*
    This method sets the number of absences in a given grading period.
     */
    public void setAbsence(int noOfAbsences) {
        mAbsent = noOfAbsences;
    }

    /*
    This method returns the number of absences in a given grading period.
     */
    public int getAbsences (){
        return mAbsent;
    }

    /*
   This method sets the number of times the student was late for class in a given grading period.
    */
    public void setTardy(int noOfTardy) {
        mTardy = noOfTardy;
    }

    /*
    This method returns the number of times the student was late for class in a given grading period.
     */
    public int getTardy (){
        return mTardy;
    }

    /*
    This method calculates the average grade of a grading period. All subject matters must have
    a grade assigned in order for the computation to take place, otherwise it will return 0 and
    print an exception to the log files.
     */
    public double calculateGradeAverage(){
        double total = 0;
        for (int i=0; i < mSubjectNo ;i++){
            if (mSubjectGrade[i] == 0){
                Log.v("ReportCard","Grade not assigned for " + mSubjectName[i] + "Cannot calculate average!");
                return 0;
            }
            total = total + mSubjectGrade[i];
        }
        return total/mSubjectNo;

    }

    /*
    This method evaluates whether the student has passed this grading period or not.
    An average grade of minimum 5 must be attained in order to graduate a certain grading period.
     */
    public String evaluatePassingGrade(){
        double gradeAvg = calculateGradeAverage();
        if (gradeAvg >= 5){
            return "PASS";
        }
        return "FAILED";
    }


    @Override
    public String toString() {
        return "ReportCard{" +
                "StudentName= " + mStudentName + "\n" +
                "SchoolYear= " + mSchoolYear + "\n" +
                "GradingPeriod= " + mGradingPeriod + "\n" +
                "SubjectNo= " + mSubjectNo + "\n" +
                "SubjectNames= " + Arrays.toString(mSubjectName) + "\n" +
                "SubjectGrades= " + Arrays.toString(mSubjectGrade) + "\n" +
                "Present= " + mPresent + "\n" +
                "Absent= " + mAbsent + "\n" +
                "Tardy= " + mTardy + "\n" +
                "GradeAverage= " + calculateGradeAverage() + "\n" +
                "Evaluation= " + evaluatePassingGrade() + '}';
    }
}

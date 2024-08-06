package com.niantic.part_2_objects;

public class MathTest
{
    private int score;
    private int possiblePoints;
    private String studentName;

    public MathTest(int possiblePoints, String studentName)
    {
        this.possiblePoints = possiblePoints;
        this.studentName = studentName;
    }

    public int getPossiblePoints() {return possiblePoints;}

    public String getStudentName() {return studentName;}

    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}

    public double percent = ((double) score / possiblePoints) * 100;
    public double getPercent() {return percent;}

    int letterGrade;
    public int getLetterGrade() {return letterGrade;}


}

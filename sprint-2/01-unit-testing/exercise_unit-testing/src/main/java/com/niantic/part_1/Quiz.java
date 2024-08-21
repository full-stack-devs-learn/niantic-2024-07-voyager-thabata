package com.niantic.part_1;

public class Quiz
{
    private int score;
    private final int possiblePoints;
    private final String studentName;

    public Quiz() {
        this(0,"");
    }

    public Quiz(int possiblePoints, String studentName)
    {
        this.possiblePoints = Math.max(possiblePoints, 0);
        this.studentName = studentName;
    }

    public int getScore()
    {
        if (score < 0)
        {
            return 0;
        }
        else return Math.min(score, 100);
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getPossiblePoints()
    {
        return Math.max(possiblePoints, 0);
    }

    public String getStudentName()
    {
        return studentName;
    }

    public int getPercent()
    {
        return (int) ((double) getScore() / getPossiblePoints() * 100);
    }

    public String getLetterGrade()
    {
        int percent = getPercent();

        if(percent > 90) return "A";
        else if(percent > 80) return "B";
        else if(percent > 70) return "C";
        else if(percent > 50) return "D";
        else return "F";
    }
}

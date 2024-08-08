package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;

public class TestScores
{
    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> scoresByTest = new ArrayList<>();

        for (TestScore test : testScores)
        {
            if (test.getTestName().equals(testName))
            {
                scoresByTest.add(test);
            }
        }

        return scoresByTest;
    }


    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> scoresByStudent = new ArrayList<>();

        for (TestScore studentName : testScores)
        {
            if (studentName.getStudentName().equals(student))
            {
                scoresByStudent.add(studentName);
            }
        }
        return scoresByStudent;
    }


    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        int highestScore = 0;

        for (TestScore score : testScores)
        {
            if (score.getScore() > highestScore)
            {
                highestScore = score.getScore();
            }
        }

        return highestScore;
    }


    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        int lowestScore = 100;

        for (TestScore score : testScores)
        {
            if (score.getScore() < lowestScore)
            {
                lowestScore = score.getScore();
            }
        }

        return lowestScore;
    }


    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int sum = 0;
        for (TestScore score : testScores)
        {
            sum += score.getScore();
        }

        return sum / testScores.size();
    }


    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int highestScore = 0;

        for (TestScore score : testScores)
        {
            if (testName.equals(score.getTestName()))
            {
                if (score.getScore() > highestScore)
                {
                    highestScore = score.getScore();
                }
            }
        }

        return highestScore;
    }


    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int lowestScore = 100;

        for (TestScore score : testScores)
        {
            if (testName.equals(score.getTestName()))
            {
                if (score.getScore() < lowestScore)
                {
                    lowestScore = score.getScore();
                }
            }
        }

        return lowestScore;
    }


    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int sum = 0;
        int counter = 0;

        for (TestScore score : testScores)
        {
            if (testName.equals(score.getTestName()))
            {
                sum += score.getScore();
                counter++;
            }
        }

        return sum / counter;
    }


    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int highestScoreByStudent = 0;

        for (TestScore score : testScores)
        {
            if (student.equals(score.getStudentName()))
            {
                if (score.getScore() > highestScoreByStudent)
                {
                    highestScoreByStudent = score.getScore();
                }
            }
        }

        return highestScoreByStudent;
    }


    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int lowestScoreByStudent = 100;

        for (TestScore score : testScores)
        {
            if (student.equals(score.getStudentName()))
            {
                if (score.getScore() < lowestScoreByStudent)
                {
                    lowestScoreByStudent = score.getScore();
                }
            }
        }

        return lowestScoreByStudent;
    }


    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int sum = 0;
        int counter = 0;

        for (TestScore score : testScores)
        {
            if (student.equals(score.getStudentName()))
            {
                sum += score.getScore();
                counter++;
            }
        }

        return sum / counter;
    }
}
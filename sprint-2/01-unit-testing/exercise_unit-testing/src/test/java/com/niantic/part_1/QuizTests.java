package com.niantic.part_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizTests
{
    @Test
    public void getPercent_shouldReturn_correctValueBasedOn_Score_and_possiblePoints()
    {
        Quiz quiz = new Quiz(100, "Student");

        int expectedScore = quiz.getScore();
        int expectedPossiblePoints = quiz.getPossiblePoints();
        int expectedPercent = (expectedScore / expectedPossiblePoints) * 100;

        int actualPercent = quiz.getPercent();

        assertEquals(expectedPercent, actualPercent, "Because Percent = (score / possiblePoints) * 100");
    }

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "90, B",
            "89, B",
            "85, B",
            "73, C",
            "55, D",
            "50, F",
            "40, F"
    })

    public void getLetterGrade_shouldReturn_correctLetterGrade(int score, String expectedLetterGrade)
    {
        Quiz quiz = new Quiz(100, "Student");

        quiz.setScore(score);

        String actualLetterGrade = quiz.getLetterGrade();

        assertEquals(expectedLetterGrade, actualLetterGrade, "Because the expected grade letter for this score is incorrect");
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 100, 110, 150})

    public void getScore_shouldReturn_correctValueForEdgeCases(int edgeScore)
    {
        Quiz quiz = new Quiz();

        quiz.setScore(edgeScore);

        int expectedScore;
        if (edgeScore < 0)
        {
            expectedScore = 0;
        }
        else expectedScore = Math.min(edgeScore, 100);

        int actualScore = quiz.getScore();

        assertEquals(expectedScore, actualScore, "Because if score <= 0 it should return 0, but if score > 100 it should cap at 100");
    }

    @Test
    public void getPossiblePoints_shouldReturnZero_ifNegative()
    {
        Quiz quiz = new Quiz(-5, "Student");

        int actualPossiblePoints = quiz.getPossiblePoints();

        assertEquals(0, actualPossiblePoints, "Because if possiblePoints is negative, it should return 0");
    }
}
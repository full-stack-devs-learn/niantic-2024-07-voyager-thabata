package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    displayAllStudentStatistics();
                    break;
                case 5:
                    displayAssignmentStatistics();
                    break;
                case 7:
                    createStudentSummaryReport();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles()
    {
        // todo: 1 - get and display all student file names

        String[] fileNames = gradesService.getFileNames();

        if (fileNames == null || fileNames.length == 0)
        {
            UserInput.displayMessage("No files found.");
        }
        else
        {
            UserInput.displayMessage("Student Files:");
            for (String fileName : fileNames)
            {
                UserInput.displayMessage(fileName);
            }
        }
    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files

        displayAllFiles();
        String fileName = UserInput.getFileNameSelection();
        List<Assignment> assignments = gradesService.getAssignments(fileName);

        if (assignments.isEmpty())
        {
            UserInput.displayMessage("No assignments found for this file.");
        }
        else
        {
            UserInput.displayMessage("Student: " + assignments.get(0).getFirstName() + " " + assignments.get(0).getLastName());
            for (Assignment assignment : assignments)
            {
                UserInput.displayMessage(assignment.toString());
            }
        }
    }

    private void displayStudentAverages()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)

        displayAllFiles();
        String fileName = UserInput.getFileNameSelection();
        List<Assignment> assignments = gradesService.getAssignments(fileName);

        if (assignments.isEmpty())
        {
            UserInput.displayMessage("No assignments found for this file.");
        }
        else
        {
            int min = assignments.stream().mapToInt(Assignment::getScore).min().orElse(0);
            int max = assignments.stream().mapToInt(Assignment::getScore).max().orElse(0);
            double avg = assignments.stream().mapToInt(Assignment::getScore).average().orElse(0.0);

            UserInput.displayMessage("Student: " + assignments.get(0).getFirstName() + " " + assignments.get(0).getLastName());
            UserInput.displayMessage("Low Score: " + min);
            UserInput.displayMessage("High Score: " + max);
            UserInput.displayMessage("Average Score: " + avg);
        }
    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }

    private void createStudentSummaryReport()
    {
        File reportDir = new File("reports");
        if (!reportDir.exists()) {
            reportDir.mkdir();
        }

        displayAllFiles();
        String fileName = UserInput.getFileNameSelection();
        List<Assignment> assignments = gradesService.getAssignments(fileName);

        if (assignments.isEmpty())
        {
            UserInput.displayMessage("No assignments found for this file.");
            return;
        }

        String studentName = assignments.get(0).getFirstName() + " " + assignments.get(0).getLastName();
        int minScore = assignments.stream().mapToInt(Assignment::getScore).min().orElse(0);
        int maxScore = assignments.stream().mapToInt(Assignment::getScore).max().orElse(0);
        double avgScore = assignments.stream().mapToInt(Assignment::getScore).average().orElse(0.0);

        String currentDate = java.time.LocalDate.now().toString();
        String reportFileName = "reports/" + currentDate + "_" + studentName.replace(" ", "_").toLowerCase() + ".txt";

        StringBuilder reportContent = new StringBuilder();
        reportContent.append(studentName).append("\n");
        reportContent.append("-".repeat(40)).append("\n");
        reportContent.append(String.format("Low Score %30d\n", minScore));
        reportContent.append(String.format("High Score %29d\n", maxScore));
        reportContent.append(String.format("Average Score %26.2f\n", avgScore));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFileName)))
        {
            writer.write(reportContent.toString());
            UserInput.displayMessage("Student Summary Report created: " + reportFileName);
        }
        catch (IOException e)
        {
            UserInput.displayMessage("Error creating report: " + e.getMessage());
        }
    }
}

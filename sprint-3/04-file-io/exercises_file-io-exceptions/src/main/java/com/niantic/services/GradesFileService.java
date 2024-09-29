package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradesFileService implements GradesService
{

    @Override
    public String[] getFileNames()
    {
        File folder = new File("files");
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".csv"));
        if (listOfFiles != null)
        {
            String[] fileNames = new String[listOfFiles.length];
            for (int i = 0; i < listOfFiles.length; i++)
            {
                fileNames[i] = listOfFiles[i].getName();
            }
            return fileNames;
        }
        else
        {
            return new String[0];
        }
    }

    @Override
    public List<Assignment> getAssignments(String fileName)
    {
        List<Assignment> assignments = new ArrayList<>();
        String filePath = "files/" + fileName;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null)
            {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 5)
                {
                    int number = Integer.parseInt(values[0]);
                    String firstName = values[1];
                    String lastName = values[2];
                    String assignmentName = values[3];
                    int score = Integer.parseInt(values[4]);

                    assignments.add(new Assignment(number, firstName, lastName, assignmentName, score));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error parsing file: " + e.getMessage());
        }
        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames)
    {
        List<Assignment> allAssignments = new ArrayList<>();

        return allAssignments;
    }
}

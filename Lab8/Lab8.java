/*  
 * Made by: Monica
 * This program uses the greedy algorithm.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Lab8 class is the driver of the program. It has a main method which creates
 * Lab8 objects and calls methods to perform 3 greedy algorithms on an Arraylist
 * of Meeting objects based on start time, meeting length, and end time.
 */
public class Lab8 {
    // List to store all the meetings from the text file
    private ArrayList<Meeting> meetingsList = new ArrayList<>();

    // List to store all the chosen (no overlap) meetings
    private ArrayList<Meeting> chosenMeetings = new ArrayList<>();

    /**
     * Reads all lines from a text file and stores the values into Meeting objects,
     * which are added to an Arraylist.
     * 
     * @param fileName - string, name of the text file
     * @throws FileNotFoundException - if file is not found
     */
    private void storeFileData(String fileName) throws FileNotFoundException {

        try {
            // Create BufferedReader and FileReader objects to read through each line in the
            // file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            // Read each first line in the file (the first line is the name of the group)
            String currMeetingGroup = bufferedReader.readLine();

            // Read the file line by line until the end of the file is reached
            while (currMeetingGroup != null) {

                // Get the current meeting time from the second line in the file
                String currMeetingTime = bufferedReader.readLine();

                // Use a Scanner to get the two integers representing the start and end time, separated by white
                // space
                Scanner scanner = new Scanner(currMeetingTime);

                // Store the number values into strings
                String numberString1 = scanner.next();
                String numberString2 = scanner.next();

                // Close the scanner
                scanner.close();

                // Store the start time from the first integer
                Integer startTime = Integer.parseInt(numberString1);

                // Store the end time from the second integer
                Integer endTime = Integer.parseInt(numberString2);

                // Create a new meeting with the current data from the file
                Meeting meeting = new Meeting(currMeetingGroup, startTime, endTime);

                // Add the meeting to the Arraylist
                meetingsList.add(meeting);

                // Read the next line
                currMeetingGroup = bufferedReader.readLine();
            }

            // Close BufferedReader object
            bufferedReader.close();

        } catch (Exception e) {
            // If an error occurs
            e.printStackTrace();
        }
    }

    /**
     * Helper function that loops through all meeting objects in the meetingsList
     * Arraylist and calls another helper function to check for overlapping meeting
     * times.
     */
    private void checkValidMeetings() {
        // Go through each meeting request
        for (Meeting meeting : meetingsList) {

            // Call helper function to check for overlaps and add it to the chosen meetings
            // list if there are no overlaps, then continue to the next meeting request
            checkOverlappingMeetings(meeting);
        }
    }

    /**
     * Compares a meeting with each meeting object in the chosenMeetings Arraylist.
     * The parameter meeting is only added to the list if it's time doesn't overlap
     * with any of the chosen meetings
     * 
     * @param meeting - Meeting object, meeting being potentially added to the
     *                chosen meetings list
     */
    private void checkOverlappingMeetings(Meeting meeting) {
        // Stores whether or not the parameter meeting overlaps with another meeting
        boolean hasOverlap = false;

        // Case for first element when the list is initially empty
        if (chosenMeetings.isEmpty()) {
            // Since there are no meetings in the list, there are no overlap conflicts so
            // the first meeting can be added
            chosenMeetings.add(meeting);
            return;
        }

        // Loop through each of the chosen meetings
        for (Meeting currMeeting : chosenMeetings) {

            // Check if the meetings are not the same
            if (!meeting.equals(currMeeting)) {
                
                // If the meeting's time overlaps with another meeting that's already chosen
                if (meeting.overlapsWith(currMeeting)) {

                    // There is an overlap
                    hasOverlap = true;
                }
            }
        }

        // If there are no overlaps with any already chosen meetings
        if (!hasOverlap) {
            // Add the parameter meeting to the chosen meetings
            chosenMeetings.add(meeting);
        }
    }

    /**
     * Performs the greedy algorithm when the list is sorted by start time.
     */
    private void greedyAlgorithmStartTime() {
        // Use built in Java collections to sort the meetingsList Arraylist
        Collections.sort(meetingsList, new Comparator<Meeting>() {

            // Override comparison method between 2 meeting objects
            @Override
            public int compare(Meeting meeting1, Meeting meeting2) {
                // Compare 2 meetings based on start times (smaller start time goes first)
                return meeting1.getStart() - meeting2.getStart();
            }
        });

        // Call helper function to loop through all meetings in meetingsList and check
        // for overlaps
        checkValidMeetings();

        // Display the number of meetings scheduled with Greedy Algorithm #1 (rank by
        // Start)
        System.out.println("Number of meetings scheduled with Greedy Algorithm #1 (rank by Start)");
        System.out.println(chosenMeetings.size() + "\n");

        // Display the names of the meetings scheduled with Greedy Algorithm #1 (rank by
        // Start)
        System.out.println("Names of the meetings scheduled with Greedy Algorithm #1 (rank by Start)");
        System.out.println(chosenMeetings + "\n");
    }

    /**
     * Performs the greedy algorithm when the list is sorted by length of the
     * meeting.
     */
    private void greedyAlgorithmMeetingLength() {
        // Use built in Java collections to sort the meetingsList Arraylist
        Collections.sort(meetingsList, new Comparator<Meeting>() {

            // Override comparison method between 2 meeting objects
            @Override
            public int compare(Meeting meeting1, Meeting meeting2) {
                // Compare 2 meetings based on meeting length (shorter length goes first)
                return meeting1.getLength() - meeting2.getLength();
            }
        });

        // Call helper function to loop through all meetings in meetingsList and check
        // for overlaps
        checkValidMeetings();

        // Display the number of meetings scheduled with Greedy Algorithm #2 (rank by
        // Length)
        System.out.println("Number of meetings scheduled with Greedy Algorithm #2 (rank by Length)");
        System.out.println(chosenMeetings.size() + "\n");

        // Display the names of the meetings scheduled with Greedy Algorithm #2 (rank by
        // Length)
        System.out.println("Names of the meetings scheduled with Greedy Algorithm #2 (rank by Length)");
        System.out.println(chosenMeetings + "\n");
    }

    /**
     * Performs the greedy algorithm when the list is sorted by end time.
     */
    private void greedyAlgorithmEndTime() {
        // Use built in Java collections to sort the meetingsList Arraylist
        Collections.sort(meetingsList, new Comparator<Meeting>() {

            // Override comparison method between 2 meeting objects
            @Override
            public int compare(Meeting meeting1, Meeting meeting2) {
                // Compare 2 meetings based on end times (smaller end time goes first)
                return meeting1.getEnd() - meeting2.getEnd();
            }
        });

        // Call helper function to loop through all meetings in meetingsList and check
        // for overlaps
        checkValidMeetings();

        // Display the number of meetings scheduled with Greedy Algorithm #3 (rank by
        // End)
        System.out.println("Number of meetings scheduled with Greedy Algorithm #3 (rank by End)");
        System.out.println(chosenMeetings.size() + "\n");

        // Display the names of the meetings scheduled with Greedy Algorithm #3 (rank by
        // End)
        System.out.println("Names of the meetings scheduled with Greedy Algorithm #3 (rank by End)");
        System.out.println(chosenMeetings + "\n");
    }

    /**
     * Performs 3 greedy algorithm methods based on start time, meeting length, and
     * end time.
     * 
     * @param fileName - String, name of the text file
     * @throws FileNotFoundException - if file is not found
     */
    public void callGreedyAlgorithms(String fileName) throws FileNotFoundException {
        // Store data from the text file into Meeting objects in the meetingsList
        // Arraylist
        storeFileData(fileName);

        // Perform greedy algorithm based on meeting start times
        greedyAlgorithmStartTime();

        // Clear/reset Arraylist for the next method
        chosenMeetings = new ArrayList<>();

        // Perform greedy algorithm based on meeting lengths
        greedyAlgorithmMeetingLength();

        // Clear/reset Arraylist for the next method
        chosenMeetings = new ArrayList<>();

        // Perform greedy algorithm based on meeting end times
        greedyAlgorithmEndTime();

        // Clear Arraylists
        meetingsList = new ArrayList<>();
        chosenMeetings = new ArrayList<>();
    }

    /**
     * Main method that runs the program.
     * Creates a Lab8 object which is used to call greedy algorithm methods on all
     * the text files.
     * 
     * NOTE: this file assumes the Meeting.java class is in the same directory as
     * this class.
     * NOTE: this file assumes all text files are in the same directory as this
     * class.
     * 
     * @param args - String array
     */
    public static void main(String[] args) {
        // Create a Lab8 object to call greedy algorithm methods on all the text files
        Lab8 Lab8 = new Lab8();

        try {
            System.out.println("----------------data1.txt----------------");
            // Perform 3 greedy algorithms on data1.txt file
            Lab8.callGreedyAlgorithms("Lab8/data1.txt");

            System.out.println("----------------data2.txt----------------");
            // Perform 3 greedy algorithms on data2.txt file
            Lab8.callGreedyAlgorithms("Lab8/data2.txt");

            System.out.println("----------------data3.txt----------------");
            // Perform 3 greedy algorithms on data3.txt file
            Lab8.callGreedyAlgorithms("Lab8/data3.txt");

            System.out.println("----------------data4.txt----------------");
            // Perform 3 greedy algorithms on data4.txt file
            Lab8.callGreedyAlgorithms("Lab8/data4.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

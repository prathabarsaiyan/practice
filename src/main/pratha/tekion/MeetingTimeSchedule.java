package main.pratha.tekion;

/**
 * Find rooms required
 * start[] = {9:00, 10:00, 10:30, 11:00, 15:00, 18:00}
 * end[] = {9:30, 12:00, 11:30, 11:30, 19:00, 20:00}
 *
 * {930} i = 0
 * {1200} i = 1
 * {1130, 1200} i = 2
 * {1130, 1130, 1200} i = 3
 * {1130, 1200, 1900} i = 4
 * {1200, 1800, 1900} i = 5
 *
 *
 *
 * i = 0 , maxTime = 930, maxRoom = 1, curr = 1
 * i = 1, maxTime = 1200, maxRoom = 1, curr = 1
 * i = 2, maxTime = 1200, maxRoom = 2, curr = 2
 *
 * Assumption: input is sorted on the basis of start time
 */
public class MeetingTimeSchedule {
    int count = 1;

}

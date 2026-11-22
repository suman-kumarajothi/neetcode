package problem.solving.neetcode150.problems.intervals.meetingrooms2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2
{
    public static void main(String[] args)
    {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,40));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));
        System.out.println(new MeetingRooms2().minMeetingRooms(intervals));
    }
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> meetingSchedules = new PriorityQueue<>();

        for(int i = 0; i < intervals.size(); i ++)
        {
            Interval meeting = intervals.get(i);
            if (!meetingSchedules.isEmpty() && meetingSchedules.peek() <= meeting.start)
            {
                meetingSchedules.poll();
            }
            meetingSchedules.offer(meeting.end);
        }
        return meetingSchedules.size();
    }
}

class Interval {
     public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
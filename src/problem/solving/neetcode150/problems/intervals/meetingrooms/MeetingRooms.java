package problem.solving.neetcode150.problems.intervals.meetingrooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms
{
    public static void main(String[] args)
    {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(5,30));
        intervals.add(new Interval(0,3));
        intervals.add(new Interval(3,6));
        System.out.println(new MeetingRooms().canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) return true;

        intervals.sort(Comparator.comparingInt(a -> a.start));
        Interval current = intervals.get(0);
        for(int i = 1; i < intervals.size(); i ++)
        {
            Interval next = intervals.get(i);
            if (current.end > next.start)
            {
                return false;
            }
            current = next;
        }
        return true;
    }
}

class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }


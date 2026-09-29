class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.size() == 0) {
            return 0;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        rooms.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {

            // Earliest room is free
            if (intervals.get(i).start >= rooms.peek()) {
                rooms.poll();
            }

            // Assign room to current meeting
            rooms.add(intervals.get(i).end);
        }

        return rooms.size();
    }
}
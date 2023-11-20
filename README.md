# javaEpamUni
Test tasks from the "Java Spring-Summer 2022" program of Epam University.

Description:
Please, implement the following methods of class Segment:

Constructor with start and end points as parameters
Ensure that a created segment exists and is not degenerative which means that the start and the end of the segment is not the same point.
If it is, use throw new IllegalArgumentException() to raise an error.
double length()
Return length of the segment.
Point middle()
Return a middle point of the segment.
Point intersection(Segment another)
Return a point of the intersection of the current segment and the given one.
Return null if there is no such point.
Return null if segments are collinear.
Please, note that intersection point must lay on both segments.

# javaEpamUni
Test tasks from the "Java Spring-Summer 2022" program of Epam University.

Description:
Please, make Triangle, Quadrilateral, Circle classes extend Figure abstract class.

Implement methods in Triangle, Quadrilateral, Circle:

Constructors with following parameters:
Triangle – three vertices (points) as parameters.
Quadrilateral – four vertices (points) as parameters.
Circle – point of the center and double value of the radius.
All the input datasets in tests are guaranteed to form a non-degenerative figures. For Quadrilaterals, it is guaranteed that all test datasets would form a convex quadrilaterals.
public double area()
Return the area of the figure.
Note: Convex quadrilaterals can be divided into two triangles by any of their diagonals.
public String pointsToString()
Return a String value in following formats:
Triangle –
Format: (a.x,a.y)(b.x,b.y)(c.x,c.y)
Example: (0.0,0.0)(0.1,5.8)(7.0,7.0)
Quadrilateral –
Format: (a.x,a.y)(b.x,b.y)(c.x,c.y)(d.x, d.y)
Example: (0.0,0.0)(0.0,7.1)(7.0,7.0)(7.0,0.0)
Circle –
Format: (center.x,center.y)
Example: (0.0,0.6)
Note: you may benefit from implementing toString() in the Point class.
public String toString()
Return a String value in following formats:
Triangle –
Format: Triangle[(a.x,a.y)(b.x,b.y)(c.x,c.y)]
Example: Triangle[(0.0,0.0)(0.1,5.8)(7.0,7.0)]
Quadrilateral –
Format: Quadrilateral[(a.x,a.y)(b.x,b.y)(c.x,c.y)(d.x, d.y)]
Example: Quadrilateral[(0.0,0.0)(0.0,7.1)(7.0,7.0)(7.0,0.0)]
Circle –
Format: Circle[(center.x,center.y)radius]
Example: Circle[(0.0,0.6)4.5]
Note: you may use default implementation given in the Figure class, when it suits a case well.
public Point leftmostPoint()
Return a leftmost point of the figure: the one having the least X coordinate.
If there are many leftmost points, return any of them.
Point class is already there.

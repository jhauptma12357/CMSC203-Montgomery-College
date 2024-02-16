/*
 * Class: CMSC203-21575
 * Instructor: Grigoriy Grinberg
 * Description: Constructors, getters, setters, overlap checker, and encompassment checker
 * Due: 10/23/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class Plot {
    private int x, y, width, depth;
    private Plot otherPlot;

    //constructor with parameters of x, y, width, depth
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    //constructor with no parameters
    public Plot() {
        width = depth = 1;
    }

    //constructor with a parameter of another Plot
    public Plot(Plot otherPlot) {
        this.x = otherPlot.getX();
        this.y = otherPlot.getY();
        this.width = otherPlot.getWidth();
        this.depth = otherPlot.getDepth();
    }

    public int getDepth() {
        return depth;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean overlaps(Plot plot) { //Check if overlaps. Don't use = because that's not considered overlap.
        return !(x + width <= plot.getX() || plot.getX() + plot.getWidth() <= x || y + depth <= plot.getY() || plot.getY() + plot.getDepth() <= y);
    } //Math is quite readable, so I don't think an explanation is needed

    public boolean encompasses(Plot plot) { //Check is another plot encompasses this plot
        return (x < plot.getX() && x + width > plot.getX() + plot.getWidth() && y < plot.getY() && y + depth > plot.getY() + plot.getDepth());
    } //Just check if the other plot is inside of this plot, my checking size and position

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return (x + "," + y + "," + width + "," + depth); //Returns the variables to a string
    }
}

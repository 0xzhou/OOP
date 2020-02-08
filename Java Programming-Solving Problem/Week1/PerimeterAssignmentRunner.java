import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num_p=0;
        for(Point currPt: s.getPoints()){
            num_p=num_p+1;
        }
        return num_p;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double a_length=0.0;
        double total_l=getPerimeter(s);
        a_length=total_l/getNumPoints(s);
        return a_length;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double l_length=0.0;
        Point prev=s.getLastPoint();
        for (Point currPt: s.getPoints()){
            double currDist = prev.distance(currPt);
            if (currDist>l_length){
                l_length=currDist;
            }
            prev = currPt;
        }
        return l_length;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double max_X=0.0;
        Point prev=s.getLastPoint();
        for (Point currPt : s.getPoints()) { 
            double curr_X = currPt.getX();
            if (curr_X>max_X){
                max_X=curr_X;
            }
            prev = currPt;
        }
        return max_X;
        
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max_peri=0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double peri=getPerimeter(s); 
            if (peri>max_peri){
                max_peri=peri;
            }
        }        
        return max_peri;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();  
        double max_peri=0.0;
        File temp=null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double peri=getPerimeter(s); 
            if (peri>max_peri){
                max_peri=peri;
                temp=f;
            }
        }        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        //call getNumPoints
        double num_p=getNumPoints (s);
        System.out.println("number of points = " + num_p);
        // call the method getAverageLength
        double a_length=getAverageLength(s); 
        System.out.println("average length = " + a_length);
        // call the getLargestSide
        double l_length=getLargestSide(s);
        System.out.println("largest length = " + l_length);
        //
        double max_X=getLargestX(s);
        System.out.println("largest X coordinate = " + max_X);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        double max_peri=pr.getLargestPerimeterMultipleFiles();
        System.out.println("maximal perimeter = " + max_peri);
    
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        String f_name=pr.getFileWithLargestPerimeter(); 
        System.out.println("the file with largest perimeter is "+f_name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}

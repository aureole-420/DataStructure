/** Test pairwise force between two planets */

public class TestPlanet{
	public static void main(String[] args){
		System.out.println("Checking pariwise force between two planets");
		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.3, "jupiter.gif");
        Planet p2 = new Planet(2.0, 3.0, 3.0, 4.0, 4e11, "jupiter.gif");
        Planet[] planets = {p1,p2};
        double Fx12 = p1.calcForceExertedByX(p2);
        double Fy12 = p1.calcForceExertedByY(p2);
        double Fx21 = p2.calcForceExertedByX(p1);
        double Fy21 = p2.calcForceExertedByY(p1);
        System.out.println("Fx12="+Fx12);
        System.out.println("Fy12="+Fy12);
        System.out.println("Fx21="+Fx21);
        System.out.println("Fy21="+Fy21);
	}
}
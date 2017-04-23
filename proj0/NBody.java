public class NBody {
//java NBody 157780000.0 25000.0 data/planets.txt

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]); // a bug? args are Strings
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);

		StdAudio.loop("audio/2001.mid");

		
		double t = 0; // time variable

		while (t<T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			int n = 0;
			// calculated the force
			while (n<planets.length){
				xForces[n] = planets[n].calcNetForceExertedByX(planets);
				yForces[n] = planets[n].calcNetForceExertedByY(planets);
				n = n+1;
			}
			// update status
			n = 0;
			while (n<planets.length){
				planets[n].update(dt, xForces[n], yForces[n]);		
				n = n+1;
			}

			// draw background
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");

			// draw planets
			n = 0;
			while (n<planets.length){
				planets[n].draw();
				n = n+1;
			} // end draw planets

			StdDraw.show(10);
			t = t+dt;
		} 
	}


	public static double readRadius(String path){
		// e.g. path = "./data/planets.txt"
		In in = new In(path);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/** Read the planets from txt file*/
	public static Planet[] readPlanets(String path){
		In in = new In(path);
		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[N];
		int n = 0;
		while (n<N){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[n] = new Planet(xP,yP,xV,yV,m,img);
			n = n+1;
		}
		return planets;
	}

	/*public static void main(String[] args){
		Planet[] planets = readPlanets("data/planets.txt");
		System.out.println(planets[0].xxPos);
	}*/

}

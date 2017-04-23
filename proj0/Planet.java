public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName; 
	// the name of an image in the images directory that depicts the planet

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	} // copy a planet

	public double calcDistance(Planet another){
		double dx = another.xxPos - this.xxPos;
		double dy = another.yyPos - this.yyPos;
		return Math.sqrt(dx*dx + dy*dy);
	} // calculate the distance

	public double calcForceExertedBy(Planet another){
		double r = this.calcDistance(another);
		double G = 6.67e-11;
		double force = G*(this.mass)*(another.mass)/(r*r);
		return force;
	} // calculate the force (a scalar)

	public double calcForceExertedByX(Planet another){
		double fx = 0;
		double force; 
		double r;
		force = this.calcForceExertedBy(another);
		r = this.calcDistance(another);
		fx = force*(another.xxPos -this.xxPos)/r;
		return fx;
	}

	public double calcForceExertedByY(Planet another){
		double fy = 0;
		double force; 
		double r;
		force = this.calcForceExertedBy(another);
		r = this.calcDistance(another);
		fy = force*(another.yyPos -this.yyPos)/r;
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] planets){
		double fx = 0;
		int n=0;
		while (n<planets.length){
			if (!this.equals(planets[n])){
				fx = fx + this.calcForceExertedByX(planets[n]);	
			}
			n = n+1;
		}
		return fx;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double fy = 0;
		int n=0;
		while (n<planets.length){
			if (!this.equals(planets[n])){
				fy = fy + this.calcForceExertedByY(planets[n]);			
			}
			n = n+1;
		}
		return fy;
	}

	public void update(double dt, double fx, double fy){
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		// update the velocity
		this.xxVel = this.xxVel + ax*dt;
		this.yyVel = this.yyVel + ay*dt;
		// update the position
		this.xxPos = this.xxPos	+ this.xxVel*dt;
		this.yyPos = this.yyPos + this.yyVel*dt;
	}

	public void draw(){
		String imageToDraw = "images/"+imgFileName;
		StdDraw.picture(xxPos,yyPos,imageToDraw);
	}

}

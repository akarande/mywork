package general;


/**
 * Find angle between hrs and minute hand
 * @author akarande
 *
 *Derivation
 * so let 12 o clock be 0 degrees
 * and let us measure clockwise
 * so then, we know that 12 hours = 360 degrees
 * so how many degrees is x hours y minutes?  
 * 720 minutes = 360 degrees
 * so (60 * x + y) minutes is how many degrees?
 * 360 / 720 * (60 * x + y) = 30x + y / 2
 * also for minutes hand now
 * 60 minutes = 360 degrees
 * so y minutes = 6 y degrees
 * so angle between them is given by subtraction
 * 30x + y / 2 - 6y = 30x - 11/2y
 */
public class ClockAngle {

	public double angle(double hrs, double mins) {
		if(hrs > 12 || mins > 60) return -1;
		double result = 30.0*(hrs) - 11.0*(mins)/2.0;
		if(result > 0) result -= 180;
		return result;
	}
	
	public static void main(String arg[]) {
		double hrs = 10;
		double mins = 5.5;
		ClockAngle ca = new ClockAngle();
		System.out.println(ca.angle(hrs, mins));
	}
}

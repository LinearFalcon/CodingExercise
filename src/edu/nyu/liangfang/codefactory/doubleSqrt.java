package edu.nyu.liangfang.codefactory;

// write function for double sqrt(double)

public class doubleSqrt {
	public double sqrt(double x) {
		return sqrt(1, x);
	}
	
	private double sqrt(double g, double x) {
		if (closeEnough(x / g, g)) {
			return g;
		} else {
			return sqrt(betterGuess(g, x), x);
		}
	}
	
	private boolean closeEnough(double a, double b) {
		return Math.abs(a - b) < b * 0.0001;
	}
	
	private double betterGuess(double g, double x) {
		return (g + x / g) / 2;
	}
}

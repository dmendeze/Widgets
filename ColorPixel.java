package a7;

public class ColorPixel implements Pixel {

	private double red;
	private double green;
	private double blue;
	
	public ColorPixel(double r, double g, double b) {
		if (r < 0.0 || r > 1.0 || g < 0.0 || g > 1.0 || b < 0.0 || b > 1.0) {
			throw new IllegalArgumentException("One or more color components out of range");
		}
		
		red = r;
		green = g;
		blue = b;
	}
	
	@Override
	public double getRed() {
		return red;
	}

	@Override
	public double getGreen() {
		return green;
	}

	@Override
	public double getBlue() {
		return blue;
	}

	@Override
	public double getIntensity() {
		return (0.2126 * getRed() + 0.7152 * getGreen() + 0.0722 * getBlue());
	}
	
	public Pixel lighten(double factor) {
		
		double newRed = getRed() * (1.0 - factor) + factor;
		double newGreen = getGreen() * (1.0 - factor) + factor;
		double newBlue = getBlue() * (1.0 - factor) + factor;
		
		return new ColorPixel (newRed, newGreen, newBlue);
		
	}
	
	public Pixel darken(double factor) {
		
		double newRed = getRed() * (1.0 - factor);
		double newGreen = getGreen() * (1.0 - factor);
		double newBlue = getBlue() * (1.0 - factor);
		
		return new ColorPixel (newRed, newGreen, newBlue);
	}

	@Override
	public Pixel lighten() {
		// TODO Auto-generated method stub
		return lighten();
	}

	@Override
	public Pixel darken() {
		// TODO Auto-generated method stub
		return darken();
	}

}

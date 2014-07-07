package Chapter14;

public class RationalClass {

	public static void main(String[] args){
		Rational r1 = new Rational(4,2);
		Rational r2 = new Rational(2,-3);
		
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
	}
}


class Rational extends Number implements Comparable {
	
	private long numerator;
	private long denominator;
	
	public Rational(){
		numerator = 0;
		denominator = 1;
	}
	
	public Rational(long n, long d){
		long gcd = gcd(n, d);
		numerator = ((d>0) ? 1:-1)*n / gcd;
		denominator = Math.abs(d) / gcd;
	}
	
	public long getNumerator(){
		return numerator;
	}
	
	public long getDenominator(){
		return denominator;
	}
	
	// 求最大公约数
	private static long gcd(long n, long d){
		n = Math.abs(n);
		d = Math.abs(d);
		int gcd = 1;
		
		for(int i=1; i<=n && i<=d; i++)
			if(n%i == 0 && d%i == 0)
				gcd = i;
		
		return gcd;
	}
	
	public Rational add(Rational r){
		long d = r.getDenominator() * this.denominator;
		long n = this.numerator * r.getDenominator() + this.denominator*r.getNumerator();
		return new Rational(n,d);
	}
	
	public Rational subtract(Rational r){
		long d = r.getDenominator() * this.denominator;
		long n = this.numerator * r.getDenominator() - this.denominator*r.getNumerator();
		return new Rational(n,d);
	}
	
	public Rational multiply(Rational r){
		long d = r.getDenominator()*this.denominator;
		long n = r.getNumerator()*this.numerator;
		return new Rational(n,d);
	}
	
	public Rational divide(Rational r){
		long d = r.getNumerator()*this.denominator;
		long n = r.getDenominator()*this.numerator;
		return new Rational(n,d);
	}
	
	public String toString(){
		if(this.denominator == 1)
			return this.numerator+"";
		else
			return this.numerator + "/" + this.denominator;
	}
	
	public double doubleValue(){
		double n = this.numerator;
		double d = this.denominator;
		return n/d;
	}
	
	public int compareTo(Object o){   // Object
		return 0;
	}
	
}



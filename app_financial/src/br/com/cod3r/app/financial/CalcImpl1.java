package br.com.cod3r.app.financial;

public class CalcImpl1 implements Calc{

	@Override
	public double sum(double... nums) {
		double total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		return total;
	}

}

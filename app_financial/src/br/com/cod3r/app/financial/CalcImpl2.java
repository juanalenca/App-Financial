package br.com.cod3r.app.financial;

import java.util.Arrays;

public class CalcImpl2 implements Calc{

	@Override
	public double sum(double... nums) {
		return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
	}

}

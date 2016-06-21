package p1;

public class SMAcalc {
	static int i;
	static float avg;
	static int bars=30;
	static double[] ma;
	public double[] SMA_calc(double[] s1){
		int k=0;
		ma=new double[s1.length-bars+1];
		for(int j=bars-1;j<s1.length;j++){
			ma[k]=0.0;
			for(int l=0;l<bars;l++){
				ma[k]+=s1[j-l];
			}
			ma[k]/=bars;
			k++;
		}
		return ma;
		
	}
}

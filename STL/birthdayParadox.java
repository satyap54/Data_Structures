class birthdayParadox
{
	public static void main(String[] args) {
		float num=365.0f,denom=365.0f,p=1.0f;
		int n=0;
		while(p>0.5)
		{
			p*=num/denom;
			num--;
			n++;
			System.out.println("Probability is = "+p+" and no. of people="+n);
		}
	}
}
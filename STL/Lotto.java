class Lotto
{
	public static void main(String[] args) {
		int a[]={1,2,4,5,6,7,8,10,12};
		int l=a.length;
		for(int i=0;i<l-5;i++)
			for(int j=i+1;j<l-4;j++)
				for(int k=j+1;k<l-3;k++)
					for(int m=k+1;m<l-2;m++)
						for(int n=m+1;n<l-1;n++)
							for(int o=n+1;o<l;o++)
								System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[m]+" "+a[n]+" "+a[o]);

	}
}
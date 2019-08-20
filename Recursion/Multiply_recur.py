#define a and b

class Multiply_recur:

	def __init__(self,a,b):
		self.a=a
		self.b=b

	def multiply(self,x,y):#we'll be adding 'x' , 'y' times

		if(y==1):
			return x

		return x+self.multiply(x,y-1)

	def compute(self):
		pow=abs(self.b)
		m=self.multiply(self.a,pow)

		if(self.b<0):
			return -m
		else:
			return m
		
ob=Multiply_recur(-2,5)

print(ob.compute())

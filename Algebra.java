public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3)); 
	    System.out.println(minus(7,2));
   		System.out.println(minus(2,7));
 		System.out.println(times(3,4));
   		System.out.println(plus(2,times(4,2)));
   		System.out.println(pow(5,3));
   		System.out.println(pow(3,5));
   		System.out.println(div(12,3));   
   		System.out.println(div(5,5));
   		System.out.println(div(25,7));
   		System.out.println(mod(25,7));
   		System.out.println(mod(120,6));   
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
		if (x1 == 0) {
			return x2; 
		}
		if (x2 == 0) {
			return x1;
		}
		int i = 0;
		if (x2 < 0 && x1 < 0) {
		while (i > x2) {
			x1--;
			i--;
		}
		}
		if (x2 > 0 && x1 > 0) {
		while (i < x2) {
			x1++;
			i++;
		}
		}
		if (x2 > 0 && x1 < 0) {
		while (i < x2) {
			x1++;
			i++;
		}
		}
		if (x2 < 0 && x1 > 0) {
		while (i > x2 ) {
			x1--;
			i--;
		}
		}


		return x1;
	}

	public static int minus(int x1, int x2) {
	if (x1 == 0) {
			return x2;
		}
		if (x2 == 0) {
			return x1;
		}
		int i = 0;
		if (x2 < 0 && x1 < 0) {
		while (i > x2) {
			x1++;
			i--;
		}
		}
		if (x2 > 0 && x1 > 0) {
		while (i < x2) {
			x1--;
			i++;
		}
		}
		if (x2 > 0 && x1 < 0) {
		while (i < x2) {
			x1--;
			i++;
		}
		}
		if (x2 < 0 && x1 > 0) {
		while (i > x2 ) {
			x1++;
			i--;
		}
		}


		return x1;
	}

	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		boolean resultIsNegative = false;
    if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
        resultIsNegative = true;
    }
	int absX1 = x1;
    if (x1 < 0) {
        absX1 = minus(0, x1); 
	}
	int absX2 = x2;
    if (x2 < 0) {
        absX2 = minus(0, x2);
    }
		int i = 0;
		int res = 0;

		while (i < absX2) { 
        res = plus(res, absX1);
        i++;
    }
	if (resultIsNegative) {
        return minus(0, res); 
    }
		
		return res;
	}

	public static int pow(int x, int n) {
	if (n == 0) {
		return 1;
	}
	if (x == 0) {
		return 0;	
	}	
	int res = 1;
	int i = 0;
	while (i < n) {
		res = times(res, x);
		i++;
		}
		return res;
	}

	public static int div(int x1, int x2) {
		if (x2 == 0) {
			return 0;
		}
		if (x1 == 0) {
			return 0;
		}
			boolean neg = false;
			if (x1 < 0) {
				x1 = minus(0, x1);
				neg =! neg;
			}
			if (x2 < 0) {
				x2 = minus(0, x2);
				neg =! neg;
			}
			int count = 0;
			while (x1 >= x2) {
				x1 = minus(x1, x2);
				count++;
			}
			if (neg) {
                count = minus(0, count);
			}
		return count;
	}

	public static int mod(int x1, int x2) {
	if (x2 == 0){
		return 0;
	}
	if (x1 == 0){
		return 0;
	}
	boolean negg = false;
	if (x1 < 0) {
		x1 = minus(0, x1);
		negg =! negg;
	}
	int negx2;
	if (x2 < 0) {
		negx2 = minus(0, x1);
	} else {
			negx2 = x2;
		}
		while (x1 >= negx2) {
			minus(x1, negx2);
		}
		if (negg) {
			minus(0, x1);
		}
		return x1;
	}

	public static int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		int num = 0;

while (times(num, num) <= x) {
	num++;
	
}
		return minus(num, 1);
	}	  	  
}

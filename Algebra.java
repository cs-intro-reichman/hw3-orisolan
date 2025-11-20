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

    boolean negative = false;
    if (x1 < 0) negative = !negative;
    if (x2 < 0) negative = !negative;

    int a = x1;
    int absA = 0;
    if (a < 0) {
        while (a < 0) {
            a++;     
            absA++;   
        }
    } else {
        absA = a;
    }

    int b = x2;
    int absB = 0;
    if (b < 0) {
        while (b < 0) {
            b++;
            absB++;
        }
    } else {
        absB = b;
    }

    int res = 0;
    int i = 0;
    while (i < absB) {
        res = plus(res, absA);
        i++; 
    }

    if (negative) {
        int negRes = 0;
        int j = 0;
        while (j < res) {  
            negRes--;      
            j++;
        }
        return negRes;
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
    if (x2 == 0) return 0;
    if (x1 == 0) return 0;

    boolean negative = false;

    int absX1 = 0;
    if (x1 < 0) {
        negative = !negative;
        while (x1 < 0) {
            x1++;
            absX1++;
        }
    } else {
        absX1 = x1;
    }

    int absX2 = 0;
    if (x2 < 0) {
        negative = !negative;
        while (x2 < 0) {
            x2++;
            absX2++;
        }
    } else {
        absX2 = x2;
    }

    int count = 0;
    while (absX1 >= absX2) {
        absX1 = minus(absX1, absX2);
        count++;
    }

    if (negative) {
        int neg = 0;
        int i = 0;
        while (i < count) {
            neg--;
            i++;
        }
        return neg;
    }

    return count;
}

	public static int mod(int x1, int x2) {
    if (x2 == 0) return 0;
    if (x1 == 0) return 0;

    int absX1 = 0;
    if (x1 < 0) {
        while (x1 < 0) {
            x1++;
            absX1++;
        }
    } else {
        absX1 = x1;
    }

    int absX2 = 0;
    if (x2 < 0) {
        while (x2 < 0) {
            x2++;
            absX2++;
        }
    } else {
        absX2 = x2;
    }

    while (absX1 >= absX2) {
        absX1 = minus(absX1, absX2);
    }

    if (x1 < 0) {
        int neg = 0;
        int i = 0;
        while (i < absX1) {
            neg--;
            i++;
        }
        return neg;
    }

    return absX1;
}


public static int sqrt(int x) {
    if (x <= 0) return 0;

    int num = 0;

    while (times(num, num) <= x) {
        num++;
    }

    return minus(num, 1);
}
}


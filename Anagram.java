/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		boolean check = str1.length() == str2.length();
		int i =0;
		while (0 < str1.length() && check) {
			char l1 = str1.charAt(index: 0);
			i = 0;
			while (i < str2.length() && l1 != str2.charAt(i)) {
				i++;
			}
			if (i < str2.length()) {
				str1 = str1.substring(beginIndex: 1, str1.length());
				str2 = str2.substring(beginIndex: 0, i) + str2.substring(i + 1, str2.length());
				check = true;
			} else {
				check = false;
			}
		}
		return check;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String newStr = "";
		int i = 0;
		for (i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch > 96 && ch < 123) {
				newStr += ch;
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int i = 0;
		String nstr = "";
		while (str.length() > 1) {
			i = (int)  (Math.random() * str.length());
			nstr = nstr + str.charAt(i);
			str = str.substring(beginIndex: 0,i) + str.substring(i + 1, str.length());
		}
		return nstr + str;
	}
}

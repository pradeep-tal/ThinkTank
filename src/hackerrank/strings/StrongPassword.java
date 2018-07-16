package hackerrank.strings;

public class StrongPassword {
	/*
	 * Its length is at least . It contains at least one digit. It contains at least
	 * one lowercase English character. It contains at least one uppercase English
	 * character. It contains at least one special character. The special characters
	 * are: !@#$%^&*()-+
	 */

	public static void main(String[] args) {

		String s = "AaaaaA189%$!";
		
		String chars = "!@#$%^&*()-+";

		System.out.println(chars.indexOf("%%"));
		
		System.out.println(chars.contains("%"));
		
		
		System.out.println(reducedString(s, s.length()));

	}

	static int reducedString(String password, int n) {

		
		String chars = "!@#$%^&*()-+";

		boolean isUpperCase = false;

		boolean isLowerCase = false;

		boolean isnumber = false;

		boolean isSpecialChar = false;

		for (int i = 0; i < password.length(); i++) {

			String c = password.substring(i, i + 1);
			
			
			boolean isnumberLocal = false;

			try {

				Integer.valueOf(c);
				isnumberLocal=true;
				
				if(!isnumber)
					isnumber=isnumberLocal;

			} catch (Exception e) {
			}

			if (isnumberLocal) {

			} else if (chars.contains(c)) {
				isSpecialChar = true;
			}
			else if (c.equals(c.toUpperCase())) {
				isUpperCase = true;
			} else if (c.equals(c.toLowerCase())) {
				isLowerCase = true;
			} else {

			}
		}
		int reqCount = 0;

		if (!isLowerCase)
			reqCount++;
		if (!isUpperCase)
			reqCount++;
		if (!isnumber)
			reqCount++;
		if (!isSpecialChar)
			reqCount++;
		
		if(n+reqCount < 6) {
			reqCount=reqCount+(6-(n+reqCount));
		}

		return reqCount;
	}

}

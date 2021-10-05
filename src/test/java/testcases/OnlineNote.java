package testcases;

import java.util.Random;

public class OnlineNote {
		

			public static String note() {
				int start = 97; // letter 'a'
				int end = 122; // letter 'z'
				int StringLength = 10;
				Random random = new Random();
				StringBuilder buffer = new StringBuilder(StringLength);
				for (int i = 0; i < StringLength; i++) {
					int randomLimitedInt = start + (int) (random.nextFloat() * (end - start + 1));
					buffer.append((char) randomLimitedInt);
				}
				String RandomString = buffer.toString();

				// System.out.println(generatedString);
				return RandomString;
			}

	}



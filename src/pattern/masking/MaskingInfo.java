package pattern.masking;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskingInfo {

	public static String maskName(String name) {

		// TODO 아래에 내용을 작성하시오.
		Pattern p = Pattern.compile("[가-힣]+");
		Matcher m = p.matcher(name);

		if (m.matches()) {
			int size = name.length();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < size - 1; i++) {
				sb.append("*");
			}
			name = name.subSequence(0, 1) + sb.toString()
					+ name.subSequence(size - 1, size);
		} else {
			throw new IllegalArgumentException();
		}

		return name;
	}

	public static String maskSsnId(String ssnId) {

		// TODO 아래에 내용을 작성하시오.
		Pattern p = Pattern.compile("^(\\d{6}-(1|2|3|4)\\d{6})$");
		Matcher m = p.matcher(ssnId);
		if (m.matches()) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 6; i++) {
				sb.append("*");
			}
			ssnId = ssnId.replaceAll("\\d{6}$", sb.toString());
		} else {
			throw new IllegalArgumentException();
		}
		return ssnId;
	}

	public static String maskCreditCardNo(String creditCardNo) {

		// TODO 아래에 내용을 작성하시오.
		// TODO 아래에 내용을 작성하시오.
		Pattern p = Pattern.compile("^(\\d{4}-\\d{4}-\\d{4}-\\d{4})$");
		Matcher m = p.matcher(creditCardNo);
		if (m.matches()) {
			StringBuffer sb = new StringBuffer();
			String str = "**-****-****";
			creditCardNo = creditCardNo.substring(0, 7)+str;
		} else {
			throw new IllegalArgumentException();
		}
		return creditCardNo;
	}
}
package self.calcul;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator2 {
	
    public long calc( String pattern ) {
    	long answer = 0;
    	
    	String firstCalcPattern = firstCalc(pattern);
    	System.out.println(firstCalcPattern);
    	String secondCalcPattern = secondtCalc(firstCalcPattern);
    	System.out.println(secondCalcPattern);
    	return answer;
    }
    
    public String firstCalc(String pattern) {
    	if(!(pattern.contains("*")||pattern.contains("/"))) {
    		return pattern;
    	}else {
    		Pattern p = Pattern.compile("(\\d+)(\\*|/)(\\d+)");
    		Matcher m = p.matcher(pattern);
    		
    		while(m.find()) {
    			int start = m.start();
    			int end = m.end();
    			
    			String result = simpleCal(Integer.parseInt(m.group(1)), m.group(2), Integer.parseInt(m.group(3)));
    			return firstCalc(pattern.substring(0, start)+result+pattern.substring(end));
    		}
    		return pattern;
    	}
    }
    
    public String secondtCalc(String pattern) {
    	if(!(pattern.contains("+")||pattern.contains("-"))) {
    		return pattern;
    	}else {
    		boolean isStartWithMinus = false;
    		if(pattern.startsWith("-")) {
    			isStartWithMinus = true;
    		}
    		Pattern p = Pattern.compile("(\\d+)(\\+|-)(\\d+)");
    		Matcher m = p.matcher(pattern);
    		
    		while(m.find()) {
    			int start = m.start();
    			int end = m.end();
    			
    			String result = "";
    			if(isStartWithMinus) {
    				result = simpleCal(Integer.parseInt("-"+m.group(1)), m.group(2), Integer.parseInt(m.group(3)));
    				isStartWithMinus = false;
    				return secondtCalc(result+pattern.substring(end));
    			}else {
    				result = simpleCal(Integer.parseInt(m.group(1)), m.group(2), Integer.parseInt(m.group(3)));
    				return secondtCalc(pattern.substring(0, start)+result+pattern.substring(end));
        			
    			}
    		}
    		return pattern;
    	}
    }
    
    public String simpleCal(int a, String p, int b){
    	long result =0;

    	switch (p) {
		case "+":
			result = a+b;
			break;
		case "-":
			result = a-b;
			break;
		case "*":
			result = a*b;
			break;
		case "/":
			result = a/b;
			break;
		default:
			throw new RuntimeException("�Է¿���");
		}
    	
    	return String.valueOf(result);
    }
}
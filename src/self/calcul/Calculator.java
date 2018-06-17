package self.calcul;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
    public static long calc( String pattern ) {
    
        Pattern p1 = Pattern.compile("(\\D)(\\d+)(\\*|/)(\\d+)(\\D)");
        Matcher m1 = p1.matcher(pattern);
        
        
        if(m1.find()){
        	String part = simpleCal(Integer.valueOf(m1.group(2)),m1.group(3),Integer.valueOf(m1.group(4)));
        	pattern = pattern.substring(0, m1.start()+1)+part+pattern.substring(m1.end()-1);
        	return calc(pattern);
        }
        
        Pattern p2 = Pattern.compile("(-*\\d+)(\\+|-|\\*|/)(\\d+)");
        Matcher m2 = p2.matcher(pattern);
        
        if(m2.find()){
        	String part = simpleCal(Integer.valueOf(m2.group(1)),m2.group(2),Integer.valueOf(m2.group(3)));
        	if(m2.start()==0&&m2.end()!=pattern.length()){
        		pattern = part+pattern.substring(m2.end());
        	}else if(m2.start()!=0&&m2.end()==pattern.length()){
        		pattern = pattern.substring(0, m2.start()-1)+part;
        	}else if(m2.start()==0&&m2.end()==pattern.length()){
        		return Integer.valueOf(part);
        	}else{
        		pattern = pattern.substring(0, m2.start()-1)+part+pattern.substring(m2.end());
        	}
        	return calc(pattern);
        }
        return Integer.valueOf(pattern);
    }
    
    public static String simpleCal(int a, String p, int b){
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
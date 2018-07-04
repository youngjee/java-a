package pattern;

public class FindSamePattern {
	public static void main(String[] args) {
		String[] strArr = {"config.syss", "config.infs", "config.ures"};
		System.out.println(findSameStr(strArr));
		
	}
	
	public static String findSameStr(String[] arr){
		String compared = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			StringBuffer str = new StringBuffer();
			char[] compArr = compared.toCharArray();
			char[] charArr = arr[i].toCharArray();
			
			for (int j = 0; j < compArr.length; j++) {
				if(j<charArr.length){
					if(compArr[j]==charArr[j]){
						str.append(compArr[j]);
					}else{
						str.append("?");
					}
				}
			}
			compared = str.toString();
		}
		return compared;
	}
}

package pattern.masking;

public class MaskingInfoRun {

	public static void main( String[] args ) {
    	
    	System.out.println("======================================");
    	
    	String name = "ȫ�浿�ƹ���";
        System.out.println("��ȯ�� �̸�: " + MaskingInfo.maskName(name));
        
        String ssnId = "800101-1234567";
        System.out.println("��ȯ�� �ֹι�ȣ: " + MaskingInfo.maskSsnId(ssnId));
        
        String creditCardNo = "1234-5678-1234-5678";
        System.out.println("��ȯ�� ī���ȣ: " + MaskingInfo.maskCreditCardNo(creditCardNo));
        System.out.println("======================================");
    }
}
package self.calcul;

public class CalculatorRun {

	public static void main( String[] args ) {
        System.out.println( "5+4*3/2-1=" + Calculator.calc("5+4*3/2-1") );                    // 10
        System.out.println( "3*2+3/2-2*4*2/3+5=" + Calculator.calc("3*2+3/2-2*4*2/3+5") );    // 7
        System.out.println( "3+5*4+5*6/2-3=" + Calculator.calc("3+5*4+5*6/2-3") );            // 35
        System.out.println( "2-3*4+5*4/2+9-9*2/2*2+9=" + Calculator.calc("2-3*4+5*4/2+9-9*2/2*2+9") );   // 0
        
        System.out.println();
        Calculator2 c2 = new Calculator2();
//        c2.calc("5+4*3/2-1");
//        c2.calc("3*2+3/2-2*4*2/3+5");
//        c2.calc("3+5*4+5*6/2-3");
        c2.calc("2-3*4+5*4/2+9-9*2/2*2+9");
	}
}
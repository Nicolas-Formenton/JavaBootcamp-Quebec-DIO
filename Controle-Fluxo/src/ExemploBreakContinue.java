public class ExemploBreakContinue {
    public static void main(String[] args) {
        
        for(int num = 0; num <= 5; num++){
            if(num == 3)
                //break; //Imprime ate o menor que o 3
                
                continue; //Muda o fluxo, não imprime o 3

            System.out.println(num);
        }
    }
}

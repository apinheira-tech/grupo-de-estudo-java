package cap6.exercs;
/*
Fatorial - para aprender recurssão
Eh a multiplicação da sequencia de numeros
 */
public class Fatorial {

    //Método Recursivo para calcular o fatorial
    public long calcFat(int num){
        if (num <= 1) {
            // Caso base
            return 1;
        } else {
            //chamada recursiva : calcFat(num - 1);
            long f =num * calcFat(num - 1);
            return f;
            //Colocar o objeto numa variavel interna para ver a multimplicação acontecendo e o resultado final
        }
    }

    public static void main (String[] args){
        //instacia da classe principal
        Fatorial fat = new Fatorial();
        // Resultado: 120 => 5*4*3*2*1
        System.out.println("Fatorial de 5: " + fat.calcFat(5));
    }

}

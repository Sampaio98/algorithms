package coders;

import java.util.Scanner;

public class FindSolution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String B = in.next();
        var letters = B.split("");
        var resultado = new StringBuffer();

        for(String n : letters) {
            if(n.equals("1")) {
                resultado.append("0");
            } else {
                resultado.append("1");
            }
        }
        System.out.println(resultado);

    }

}

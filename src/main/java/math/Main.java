package math;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] param = new String[3];

        while(true){
            param[0] = in.nextLine();
            param[1] = in.nextLine();
            param[2] = in.nextLine();
            Calculator.pars(param);
        }
    }
}

/*
    Aufagbe 3) Debuggen

    In dieser Aufgabe üben Sie den Umgang mit dem Debugger, der Ihnen beim
    Implementieren und Testen Ihrer Programme hilfreich sein kann.

    Unten finden Sie ein gegebenes Programm mit einem eingebauten Fehler.
    Verwenden Sie den Debugger von IntelliJ um diesen Fehler zu finden.

*/
public class Aufgabe3{

    // Das Programm soll in einer while-Schleife bis 100 zählen und danach die
    // while-Schleife verlassen. Nach dem Beenden der while-Schleife soll
    // "finished" ausgegeben werden.
    public static void main(String[] args) {
        boolean isLoop = true;

        while(isLoop == true){
            int counter = 0;
            if(counter == 100){
                isLoop = false;
            }
            counter = counter + 1;
        }

        // Diese Anweisung wird nicht erreicht, da die while-Schleife nicht
        // beendet wird. D.h. die Unittests reichen nicht aus um den Fehler zu
        // finden. Daher kann man an dieser Stelle den Debugger verwenden.
        System.out.println("finished");
    }
}


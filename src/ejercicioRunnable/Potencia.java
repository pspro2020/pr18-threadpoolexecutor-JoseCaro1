package ejercicioRunnable;


import javax.swing.text.DateFormatter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Potencia implements Runnable {

    private int num;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    Potencia(int num) {
        this.num = num;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            double result = Math.pow(num, i);
            System.out.println(String.format("%s - %d elevado a %d es igual %.0f (Ejecutado por el %s)",
                    LocalTime.now().format(formatter), num, i, result, Thread.currentThread().getName()));
        }

    }


}

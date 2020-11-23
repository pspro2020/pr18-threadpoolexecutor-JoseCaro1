package ejercicioRunnable;

public class Potencia implements Runnable {

    private int num;


    Potencia(int num) {
        this.num = num;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            double result = Math.pow(num, i);
            System.out.println(String.format("%s - %d elevado a %d es igual %.0f", Thread.currentThread().getName(), num, i, result));
        }

    }


}

package ejercicioRunnable;

public class Potencia implements Runnable {

    private int num;
    private String name;

    Potencia(int num,String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            double result=Math.pow(num,i);
            System.out.println(String.format("%s - %d elevado a %d es igual %.0f", Thread.currentThread().getName(), num, i, result));
        }

    }

    protected String getName() {
        return name;
    }
}

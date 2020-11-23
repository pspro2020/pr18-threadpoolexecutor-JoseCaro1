package ejercicioRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class MainFixed {

    public static void main(String[] args) {
        final ThreadPoolExecutor fixedThreadPool =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        Potencia potencia = null;
        for (int i = 0; i < 10; i++) {
            try {
               potencia = new Potencia(i,"My Thread "+i);
               Thread.sleep(200);
                fixedThreadPool.execute(potencia);
            } catch (RejectedExecutionException e) {
                System.out.printf("Server -> Task rejected: %s\n",potencia.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        fixedThreadPool.shutdown();


    }
}

package ejercicioRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MainFixed {

    public static void main(String[] args) {
        final ThreadPoolExecutor fixedThreadPool =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(5,new ThreadFactory() {
                    Integer count=0;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r,"Hilo "+ ++count);
                    }
                });

        Potencia potencia = null;
        for (int i = 0; i < 10; i++) {
            try {
                potencia = new Potencia(i);
                Thread.sleep(200);
                fixedThreadPool.execute(potencia);
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        fixedThreadPool.shutdown();


    }
}

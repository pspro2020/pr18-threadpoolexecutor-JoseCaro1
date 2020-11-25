package ejercicioRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MainFixed {

    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolExecutor fixedThreadPool =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(),new ThreadFactory() {
                    Integer count=0;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r,"hilo "+ ++count);
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
        while(!fixedThreadPool.isTerminated()){
            Thread.sleep(200);
        }
        System.out.printf("El numero maximo de hilos utilizados ha/han sido %d",fixedThreadPool.getLargestPoolSize());


    }
}

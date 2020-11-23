package ejercicioRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MainCached {
    public static void main(String[] args) {
        final ThreadPoolExecutor cachedThreadPool =
                (ThreadPoolExecutor) Executors.newCachedThreadPool(new ThreadFactory() {
                    Integer count=0;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r,"Potencia "+ ++count);
                    }
                });

        Potencia potencia = null;
        for (int i = 0; i < 10; i++) {
            try {
                potencia = new Potencia(i);
                Thread.sleep(200);
                cachedThreadPool.execute(potencia);
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        cachedThreadPool.shutdown();
    }
}

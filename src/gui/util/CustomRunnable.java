package gui.util;

/**
 * Interface yang digunakan untuk menghubungkan dua layout
 *
 * @author Steve Lukis - D42116006
 *
 * @param <T>
 */
public interface CustomRunnable<T> {

    /**
     * Metode yang akan dioverload dan dipanggil.
     * @param params parameter yang bisa lebih dari satu
     */
    void run(T... params);

}

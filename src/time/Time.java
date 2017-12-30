package time;

/**
 * Kelas parent untuk alat - alat waktu
 * * @author Steve - D42116006
 */
public abstract class Time {

    protected int second;
    protected int minute;
    protected int hour;

    //Overloading constructor
    public Time() {
        this(0);
    }

    public Time(int totalSeconds) {
        convertTime(totalSeconds);
    }

    /**
     * Mengubah total detik menjadi nilai jam, menit, dan detik yang sesuai,
     * @param totalSeconds Jumlah detik
     */
    private void convertTime(int totalSeconds) {
        hour = totalSeconds / 3600;
        minute = (totalSeconds % 3600) / 60;
        second = totalSeconds % 60;
    }

    /**
     * Dipanggil setiap detik.
     */
    public abstract void updateTime();

    /**
     * Memasang nilai baru.
     * @param totalSeconds Total detik.
     */
    public void setTime(int totalSeconds) {
        convertTime(totalSeconds);
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }
}

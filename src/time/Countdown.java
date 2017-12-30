package time;

public class Countdown extends Time {

    //Overloading dari metode kelas Time.
    public void updateTime() {

        //dekremen nilai detik
        second--;

        //jika nilai detik lebih kecil dari 0, set nilai detik jadi 59 dan dekremen menit
        if (second < 0) {
            second = 59;
            minute--;
        }

        //jika nilai menit lebih kecil dari 0, set nilai menit jadi 59 dan dekremen jam
        if (minute < 0) {
            minute = 59;
            hour--;
        }

        //jika nilai jam lebih kecil dari 0, berarti countdown telah selesai.
        if (hour < 0) {
            second = 0;
            minute = 0;
            hour = 0;
        }
    }

}

package time;

public class Stopwatch extends Time {

    //Overloading dari metode parent
    public void updateTime() {

        //Menaikkan nilai detik.
        second++;

        //jika jumlah detik lebih besar atau sama dengan 60, inkremen menit dan set detik jadi 0
        if (second >= 60) {
            second = 0;
            minute++;
        }

        //jika jumlah menit lebih besar atau sama dengan 60, inkremen jam dan set menit jadi 0
        if(minute >= 60) {
            hour++;
            minute = 0;
        }
    }
}

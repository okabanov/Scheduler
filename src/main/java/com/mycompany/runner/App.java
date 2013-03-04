package com.mycompany.runner;

import java.io.IOException;
import java.util.Date;

public class App {

    private static int[] intervals = new int[5];

    public static void main(String[] args) throws InterruptedException, IOException {
        // s = s.replace(/.*:(\d\d:\d\d:\d\d).*/, "$1")
        // a = s.split(':')
        // t = a[0] * 3600 + a[1] * 60 + a[2]
        createTestData();
        while (true) {
            int intervalPosition = searchInterval(getCurrentTime());
            if (intervalPosition >= 0) {
                for (int i = intervalPosition; i < intervals.length; i++) {
                    Runtime.getRuntime().exec("ls");
                    int timeout = intervals[i] - getCurrentTime();
                    if (timeout > 0) {
                        Thread.sleep(timeout * 1000);
                    }
                }
            }
            Thread.sleep(1000); // Полночь. И такая фигня пока не придёт первый пользователь.
        }
    }

    private static int searchInterval(int time) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] > time) {
                return i;
            }
        }
        return -1; // На сегодня больше нет
    }

    private static int getCurrentTime() {
        Date date = new Date();
        return (date.getHours() + 1) * 3600
                + date.getMinutes() * 60
                + date.getSeconds();
    }

    private static void createTestData() {
        int time = getCurrentTime();
        for (int i = 0; i < intervals.length; i++) {
            time += Math.random() * 10;
            intervals[i] = time;
        }
    }
}

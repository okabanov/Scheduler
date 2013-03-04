package com.mycompany.runner;

import java.io.IOException;
import java.util.Date;

// for (var i = 0; i < a.length; i++) {var tmp = a[i].split(':'); a[i] = tmp[0] * 60 + tmp[1] * 1}

public class App {
    private static int delayInSeconds = 1;
    private static int timePeriod = 30 * 60;
    private static float rate = 0.22f; // 200 users
    private static int[] intervals = new int[] {
        3, 6, 1, 2, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 16, 1, 7, 20, 32, 13, 
        17, 10, 26, 41, 16, 24, 16, 27, 17, 47, 38, 16, 29, 44, 39, 31, 28, 71, 
        56, 53, 44, 28, 41, 26, 19, 4
    }; // summ = 913

    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {
            if(Math.random() * timePeriod / delayInSeconds < intervals[getCurrentTime()] * rate) {
                Runtime.getRuntime().exec("runner.bat");
            }
            Thread.sleep(delayInSeconds * 1000);
        }
    }

    private static int getCurrentTime() {
        Date date = new Date();
        return (int) Math.floor((date.getHours() * 3600 + date.getMinutes() * 60) / timePeriod);
    }

    
}

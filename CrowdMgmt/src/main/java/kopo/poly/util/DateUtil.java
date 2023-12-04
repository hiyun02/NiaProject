package kopo.poly.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    /**
     * 날짜, 시간 출력하기
     *
     * @param fm 날짜 출력 형식
     * @return date
     */
    public static String getDateTime(String fm) {

        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat(fm);

        return date.format(today);
    }

    public static String getDateTimeHour(String fm) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fm);

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Subtract one hour
        LocalDateTime oneHourAgo = now.minusHours(1);

        // Format the result to the specified pattern
        return oneHourAgo.format(formatter);
    }
}
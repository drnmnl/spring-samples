package com.drnmnl.devtests.datetime;

import org.apache.tomcat.jni.Local;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import java.time.DayOfWeek;

// Demo for the new java.time (JDK8)
public class DateTimeSample {
    public void demoLocalDateTime() {
        LocalDate dateNow, dateJavaBday, dateNextMonth, dateNextTues;
        dateNow = LocalDate.now();
        dateJavaBday = LocalDate.of(1995, 5, 23);
        dateNextMonth = dateNow.plusMonths(1);
        dateNextTues = dateNow.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));

        StringBuilder sb = new StringBuilder();
        sb.append("Date now: ").append(dateNow).append("\n")
                .append("Java's birthday: ").append(dateJavaBday).append("\n")
                .append("Is Java's bday in the past? ").append(dateJavaBday.isBefore(dateNow)).append("\n")
                .append("Is Java's bday on a leap year? ").append(dateJavaBday.isLeapYear()).append("\n")
                .append("Java bday day of the week: ").append(dateJavaBday.getDayOfWeek()).append("\n")
                .append("Date next month: ").append(dateNextMonth).append("\n")
                .append("Date next Tuesday: ").append(dateNextTues).append("\n");

        System.out.println(sb.toString());

        LocalTime timeNow, nowPlus, nowHrsMins, timeLunch, timBed;
        int nthMinute;

        timeNow = LocalTime.now();
        nowPlus = timeNow.plusHours(1).plusMinutes(15);
        nowHrsMins = timeNow.truncatedTo(ChronoUnit.MINUTES);
        nthMinute = timeNow.toSecondOfDay() / 60;
        timeLunch = LocalTime.of(12,30);
        long minutesToLunch = Math.abs(timeNow.until(timeLunch, ChronoUnit.MINUTES));

        sb = new StringBuilder();
        sb.append("Time now: ").append(timeNow).append("\n")
                .append("Truncate current time to minutes: ").append(nowHrsMins).append("\n")
                .append("Time 1h 15min from now: ").append(nowPlus).append("\n")
                .append("It is the ").append(nthMinute).append("th minute.").append("\n")
                .append("Lunch time is ").append(timeLunch).append("\n")
                .append("Is lunch time over today? ").append(timeLunch.isBefore(timeNow)).append("\n")
                .append("How many minutes after lunch? ").append(minutesToLunch).append("\n");
        System.out.println(sb.toString());

        LocalDate ld = LocalDate.of(2020, 06, 12);
        LocalTime lt  = LocalTime.of(12,00);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);


        System.out.println("================== LocalDateTime ===================");
        sb = new StringBuilder();

        LocalDateTime courseStart, courseEnd;
        courseStart = LocalDateTime.of(2019, 11, 24, 9, 00);
        courseEnd = LocalDateTime.of(2019,11,28,17,00);

        courseStart = LocalDateTime.of(2019, 11, 24, 9, 00);
        courseEnd = LocalDateTime.of(2019,11,25,9,00);

        long duration = (courseEnd.getHour() - courseStart.getHour()) * (courseStart.until(courseEnd, ChronoUnit.DAYS) + 1);
        long daysCourse = courseStart.until(courseEnd, ChronoUnit.DAYS);
        sb.append("Course start: ").append(courseStart).append("\n")
                .append("Course end: ").append(courseEnd).append("\n")
                .append("Course duration in hours: ").append(duration).append("\n")
                .append("Days to finish course: ").append(daysCourse).append("\n");


        System.out.println(sb.toString());

        System.out.println("================== ZonedDateTime ===================");

        ZoneId usZoneId = ZoneId.of("America/New_York");
        LocalDateTime ldtNow = LocalDateTime.now(usZoneId);
        System.out.println("US Date & Time now: " + ldtNow);


        // 	Ex. Given a meeting date the day before DST (2AM March 9th),
        // 	what happens if the meeting is moved out by a day?

        ZoneOffset usEastZoneOffset = ZoneOffset.ofHoursMinutes(5, 30);

        ZoneId usEastZoneId = ZoneId.ofOffset("UTC", usEastZoneOffset);

        LocalDateTime meetDateTime = LocalDateTime.of(2014, Month.MARCH, 8, 16, 00);
        ZonedDateTime meeting = ZonedDateTime.of(meetDateTime, usZoneId);
        ZonedDateTime newMeeting = meeting.plusDays(1);
        System.out.println("Prev meeting: " + meeting);
        System.out.println("New meeting: " + newMeeting + "\n");

        System.out.println("================== OffsetDateTime ===================");
        ZonedDateTime callTime = ZonedDateTime.of(meetDateTime, usZoneId);
        OffsetDateTime callTimeOffset = callTime.toOffsetDateTime();

        ZoneId londonZoneId = ZoneId.of("Europe/London");
        ZonedDateTime callTimeUk = callTimeOffset.atZoneSameInstant(londonZoneId);

        System.out.println("Call time (US Eastern): " + callTime);
        System.out.println("Call time (UK): " + callTimeUk);
        System.out.println("Zoned date time now: " + ZonedDateTime.now());

        Duration.ofMillis(100);
        Duration.ofNanos(100);
        Duration.ofDays(100);

        System.out.println("================== DateTimeFormatter ===================");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(formatter.format(zdt));

        System.out.println(LocalDateTime.parse("2019-06-12T06:00:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME));



    }
}

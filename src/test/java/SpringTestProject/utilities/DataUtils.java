package SpringTestProject.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

@Component
@Log4j2
public class DataUtils {

    public String getTodayDate(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return today.format(df);
    }

    public String getTodayDate2(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(df);
    }

    public String getTodayDate_ru(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd MMM, yyyy").localizedBy(new Locale("ru"));;
        return today.format(df);
    }


    public String getDateOfTheMonth(int date){
        LocalDate today = LocalDate.now().withDayOfMonth(date);
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return today.format(df);
    }

    public String getDateOfTheMonth_ru(int date){
        LocalDate today = LocalDate.now().withDayOfMonth(date);
        ;
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd MMM, yyyy").localizedBy(new Locale("ru"));;
        return today.format(df);
    }

    public String getDateOfTheNextMonth(int date){
        LocalDate today = LocalDate.now().withDayOfMonth(date).plusMonths(1);
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return today.format(df);
    }

    public String getDateOfTheNextMonth_ru(int date){
        LocalDate today = LocalDate.now().withDayOfMonth(date).plusMonths(1);
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd MMM, yyyy").localizedBy(new Locale("ru"));;
        return today.format(df);
    }


    public Date stringToData(String str) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = formatter.parse(str);
        return date;
    }

    public Date stringToData2(String str) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = formatter.parse(str);
        return date;
    }

    public String convertDateFormat(String str) throws ParseException {
        DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy").localizedBy(new Locale("ru"));
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("dd MMM, yyyy");
        LocalDate date = LocalDate.parse(str, originalFormat);
        String formattedDate = date.format(targetFormat);
        return formattedDate;
    }

    public int calculateMonth(LocalDate today, LocalDate targetDate){
        int monthsBetween = (int) ChronoUnit.MONTHS.between(today.withDayOfMonth(1), targetDate.withDayOfMonth(1));
        return monthsBetween;
    }

    public boolean checkTheDateAndTimeWithIn2MinOFNow(String dateAndTimeToCheck){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dateAndTime = LocalDateTime.parse(dateAndTimeToCheck, formatter);
        LocalDateTime now = LocalDateTime.now();
        log.info(now.toString());
        long minutesDifference = Duration.between(now, dateAndTime).toMinutes();
        log.info(minutesDifference);
        return Math.abs(minutesDifference)<=2;
    }
}

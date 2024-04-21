package clov3r.googlecalendartask;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.LocalDate;

public class EventData {
    private String summary;
    private Event.Creator creator;
    private String created;
    private String updated;
    private String start;
    private String end;
    private String description;

    // EventData 초기화
    public EventData(String summary, Event.Creator creator, DateTime created, DateTime updated, EventDateTime start, EventDateTime end, String description) {
        this.summary = summary;
        this.creator = creator;
        this.created = (created != null) ? formatDateTime(created, "yyyy년 MM월 dd일") : "-";
        this.updated = (updated != null) ? formatDateTime(updated, "yyyy년 MM월 dd일") : "-";
        this.start = (((start.getDate()) != null) ? formatDate(start.getDate(), "yyyy년 MM월 dd일") : formatDateTime(start.getDateTime(), "yyyy년 MM월 dd일")) + " " + ((start.getDateTime() != null) ? formatDateTime(start.getDateTime(), "HH:mm") : "00:00");
        this.end = (((end.getDate()) != null) ? formatDate(end.getDate(), "yyyy년 MM월 dd일") : formatDateTime(end.getDateTime(), "yyyy년 MM월 dd일")) + " " + ((end.getDateTime() != null) ? formatDateTime(end.getDateTime(), "HH:mm") : "00:00");
        this.description = (description != null) ? description : "no description";
    }

    // DateTime 값 중 시간이 포함 된 값의 Format 변환 함수
    private String formatDateTime(DateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime.toStringRfc3339(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return formatter.format(zonedDateTime);
    }

    // DateTime 값 중 시간이 포함 되지 않은 값의 Format 변환 함수
    private String formatDate(DateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(dateTime.toStringRfc3339(), DateTimeFormatter.ISO_LOCAL_DATE);
        return formatter.format(localDate);
    }

    // get과 set 함수 정의
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Event.Creator getCreator() {
        return creator;
    }

    public void setCreator(Event.Creator creator) {
        this.creator = creator;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

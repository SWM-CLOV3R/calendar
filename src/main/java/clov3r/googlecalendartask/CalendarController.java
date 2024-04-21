package clov3r.googlecalendartask;

import com.google.api.services.calendar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
public class CalendarController {

    private final CalendarService calendarService;
    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping
    public String test(Model model) {
        model.addAttribute("data", "World");
        return "test";
    }

    /**
     * 구글 캘린더 API 이벤트를 가져와서 웹에 넘겨주는 함수
     * @return 이벤트 리스트
     * @throws IOException
     * @throws GeneralSecurityException
     */
    @GetMapping("/events")
    public String getEvents(Model model) throws IOException, GeneralSecurityException {
        List<Event> events = calendarService.getEvents();
        model.addAttribute("events", events);
        return "test";
    }

    /**
     * 구글 캘린더 API 이벤트를 가져오는 함수 - postman 테스트용
     */
    @GetMapping("/events/postman")
    public ResponseEntity<List<Event>> getEvents() throws IOException, GeneralSecurityException {
        List<Event> events = calendarService.getEvents();
        return ResponseEntity.ok(events);
    }

}

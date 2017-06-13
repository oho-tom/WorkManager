package wrkmng.app.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wrkmng.domain.model.MeetingRoom;
import wrkmng.domain.service.room.RoomService;

@Controller
@RequestMapping("reservations")
public class ReservationsController {
	@Autowired
	RoomService roomService;
//	@Autowired
//	ReservationService reservationService;

//	@ModelAttribute
//	ReservationForm setUpForm() {
//		ReservationForm form = new ReservationForm();
//		// デフォルト値
//		form.setStartTime(LocalTime.of(9, 0));
//		form.setEndTime(LocalTime.of(10, 0));
//		return form;
//	}

	@RequestMapping(method = RequestMethod.GET)
	String reserveForm(Model model) {
//		ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
//		List<Reservation> reservations = reservationService.findReservations(reservableRoomId);
//
//		List<LocalTime> timeList = Stream.iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30)).limit(24 * 2).collect(Collectors.toList());
		List<MeetingRoom> meetingRooms = roomService.findMeetingRoom();

		model.addAttribute("rooms", meetingRooms);
//		model.addAttribute("reservations", reservations);
//		model.addAttribute("timeList", timeList);
		return "reservation/reserveForm";
	}

//	@RequestMapping(method = RequestMethod.POST)
//	String reserve(@Validated ReservationForm form,
//			BindingResult bindingResult,
//			@AuthenticationPrincipal ReservationUserDetails userDetails,
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
//			@PathVariable("roomId") Integer roomId, Model model) {
//		if(bindingResult.hasErrors()) {
//			return reserveForm(date, roomId, model);
//		}
//
//		ReservableRoom reservableRoom = new ReservableRoom(new ReservableRoomId(roomId, date));
//		Reservation reservation = new Reservation();
//		reservation.setStartTime(form.getStartTime());
//		reservation.setEndTime(form.getEndTime());
//		reservation.setReservableRoom(reservableRoom);
//		reservation.setUser(userDetails.getUser());
//
//		try {
//			reservationService.reserve(reservation);
//		}
//		catch (UnavailableReservationException | AlreadyReservedException e) {
//			model.addAttribute("error", e.getMessage());
//			return reserveForm(date, roomId, model);
//		}
//		return "redirect:/reservations/{date}/{roomId}";
//	}
//
//	@RequestMapping(method = RequestMethod.POST, params = "cancel")
//	String cancel(@RequestParam("reservationId") Integer reservationId,
//			@PathVariable("roomId") Integer roomId,
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
//			Model model) {
//
//		try {
//			Reservation reservation = reservationService.findOne(reservationId);
//			reservationService.cancel(reservation);
//		}
//		catch (AccessDeniedException e){
//			model.addAttribute("error", e.getMessage());
//			return reserveForm(date, roomId, model);
//		}
//		return "redirect:/reservations/{date}/{roomId}";
//	}
}
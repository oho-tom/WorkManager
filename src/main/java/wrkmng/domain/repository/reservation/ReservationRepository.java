package wrkmng.domain.repository.reservation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wrkmng.domain.model.MeetingRoom;
import wrkmng.domain.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByMeetingRoom_RoomId(MeetingRoom meetingRoom);
	List<Reservation> findByMeetingRoom_RoomIdAndReservedDate(Integer roomId, LocalDate reservedDate);
}

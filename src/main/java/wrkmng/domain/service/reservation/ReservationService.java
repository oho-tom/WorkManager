package wrkmng.domain.service.reservation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wrkmng.domain.model.Reservation;
import wrkmng.domain.repository.reservation.ReservationRepository;

@Service
@Transactional
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	public Reservation reserve(Reservation reservation) {
		List<Reservation> reservations = this.findByMeetingRoom_RoomIdAndReservedDate(reservation.getMeetingRoom().getRoomId(), reservation.getReservedDate());

		// 重複チェック
		boolean overlap = reservations.stream().anyMatch(x -> x.overlap(reservation));
		if(overlap) {
			// 例外をスローする
			throw new AlreadyReservedException("入力の条件はすでに予約済みです。");
		}

		// 予約情報の登録
		reservationRepository.save(reservation);
		return reservation;
	}

	public List<Reservation> findByMeetingRoom_RoomIdAndReservedDate(Integer roomId, LocalDate reservedDate) {
		return reservationRepository.findByMeetingRoom_RoomIdAndReservedDate(roomId, reservedDate);
	}

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

//	// 予約キャンセル処理
//	@PreAuthorize("hasRole('ADMIN') or principal.user.userId == #reservation.user.userId")
//	public void cancel(@P("reservation") Reservation reservation) {
//		reservationRepository.delete(reservation);
//	}
//
//	public Reservation findOne(Integer reservationId) {
//		return reservationRepository.findOne(reservationId);
//	}
}

package wrkmng.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;

	private LocalTime startTime;

	private LocalTime endTime;

	private LocalDate reservedDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private MeetingRoom meetingRoom;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate = reservedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	// 予約時間の重複チェック
	public boolean overlap(Reservation target) {
		// 部屋idと予約日付が一致しなければ重複していない
		if(!(Objects.equals(meetingRoom.getRoomId(), target.getMeetingRoom().getRoomId()) &&
				Objects.equals(reservedDate, target.getReservedDate()))){
			return false;
		}
		// 開始時刻と終了時刻が一致する場合は重複している
		if(startTime.equals(target.startTime) && endTime.equals(target.endTime)) {
			return true;
		}
		// 予約時間帯が交差または包含関係にあれば重複している
		return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);
	}
}

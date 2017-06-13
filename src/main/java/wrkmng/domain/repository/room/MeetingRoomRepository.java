package wrkmng.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import wrkmng.domain.model.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
}

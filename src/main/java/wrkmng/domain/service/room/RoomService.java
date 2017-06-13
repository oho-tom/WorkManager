package wrkmng.domain.service.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wrkmng.domain.model.MeetingRoom;
import wrkmng.domain.repository.room.MeetingRoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	MeetingRoomRepository meetingRoomRepository;

	public List<MeetingRoom> findMeetingRoom(){
		return meetingRoomRepository.findAll();
	}

	public MeetingRoom findMeetingRoom(Integer roomId){
		return meetingRoomRepository.findOne(roomId);
	}
}

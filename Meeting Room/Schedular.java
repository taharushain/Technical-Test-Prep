import java.time.LocalTime;
import java.util.ArrayList;

public class Schedular{

	private ArrayList<Booking> bookings = new ArrayList<>();

	public Schedular(){
	}

	public Boolean handleBookings(Booking booking){
		for(Booking mBooking : bookings){

			if(checkConflict(mBooking.getStartTime(), 
				mBooking.getEndTime(),
				booking.getStartTime(),
				booking.getEndTime())){
				return true; // True indicates a conflict
			}
		}

		bookings.add(booking);
		
		return false;
	}


	public boolean checkConflict(LocalTime oldStart, LocalTime oldEnd,
		LocalTime newStart, LocalTime newEnd){
		Boolean check = true;

		if(newStart.isBefore(oldStart) && newEnd.isBefore(oldStart)){
			return false;

		}else if((newStart.isAfter(oldEnd) || newStart.equals(oldEnd)) && newEnd.isAfter(oldEnd)){
			return false;
		}

		return check;
	}
	

}
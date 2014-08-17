package inn348.muteme.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeOfDay {
	private int hour;
	private int minutes;
	public TimeOfDay(int hour, int minutes){
		this.hour = hour;
		this.minutes = minutes;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinute(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date time = new Date();
		time.setHours(hour);
		time.setMinutes(minutes);
		return sdf.format(time);
	}
	
}
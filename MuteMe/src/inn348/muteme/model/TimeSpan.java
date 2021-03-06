package inn348.muteme.model;

import java.text.SimpleDateFormat;
import java.util.Date;



public class TimeSpan {
	
	TimeOfDay start;
	TimeOfDay stop;
	public TimeSpan(TimeOfDay start, TimeOfDay stop){
		this.start = start;
		this.stop = stop;
	}

	public TimeOfDay getStart() {
		return start;
	}
	public void setStart(TimeOfDay start) {
		this.start = start;
	}
	public TimeOfDay getStop() {
		return stop;
	}
	public void setStop(TimeOfDay stop) {
		this.stop = stop;
	}
	
	@Override
	public String toString()
	{
		return start.toString() + " - " + stop.toString();
	}
}

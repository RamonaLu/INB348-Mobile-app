package inn348.muteme;

import java.util.EnumSet;



public class ChronoCondition {		
	int id;
	EnumSet<DayOfWeek> daysOfWeek;
	TimeSpan timeSpan;
	
	public ChronoCondition(TimeSpan timeSpan, EnumSet<DayOfWeek> daysOfWeek) {

		this.timeSpan = timeSpan;
		this.daysOfWeek = daysOfWeek;
	}	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public EnumSet<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(EnumSet<DayOfWeek> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public TimeSpan getTimeSpan() {
		return timeSpan;
	}


	public void setTimeSpan(TimeSpan timeSpan) {
		this.timeSpan = timeSpan;
	}
}

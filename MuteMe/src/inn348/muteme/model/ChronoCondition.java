package inn348.muteme.model;


import java.util.EnumSet;

import com.google.gson.annotations.Expose;


public class ChronoCondition {	

	@Expose
	private EnumSet<DayOfWeek> daysOfWeek;

	@Expose
	private TimeSpan timeSpan;
	
	public ChronoCondition(TimeSpan timeSpan, EnumSet<DayOfWeek> daysOfWeek) {

		this.timeSpan = timeSpan;
		this.daysOfWeek = daysOfWeek;
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

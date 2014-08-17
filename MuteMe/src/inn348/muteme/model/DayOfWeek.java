package inn348.muteme.model;

import java.util.Calendar;
import java.util.EnumSet;

public enum DayOfWeek{
	MONDAY(Calendar.MONDAY),
	TUESDAY(Calendar.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY),
	FRIDAY(Calendar.FRIDAY),
	SATURDAY(Calendar.SATURDAY),
	SUNDAY(Calendar.SUNDAY);
	
	private int value;
	
	public static EnumSet<DayOfWeek> WeekDays = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);
	public static EnumSet<DayOfWeek> WeekEnds = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);	
	
	private DayOfWeek(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}

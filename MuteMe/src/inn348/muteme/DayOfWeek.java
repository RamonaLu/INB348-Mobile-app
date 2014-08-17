package inn348.muteme;

import java.util.Calendar;


public enum DayOfWeek{
	MONDAY(Calendar.MONDAY),
	TUESDAY(Calendar.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY),
	FRIDAY(Calendar.FRIDAY),
	SATURDAY(Calendar.SATURDAY),
	SUNDAY(Calendar.SUNDAY);
	
	private int value;
	
	private DayOfWeek(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}

package inn348.muteme.model;
import com.google.gson.annotations.Expose;
public class Mute {
	@Expose	
	private GeoCondition geoCondition;
	
	@Expose	
	private ChronoCondition chronoCondition;

	@Expose	
	public Boolean allowAlarm;

	@Expose	
	public Boolean isActive;
	
	public Boolean getAllowAlarm() {
		return allowAlarm;
	}

	public void setAllowAlarm(Boolean allowAlarm) {
		this.allowAlarm = allowAlarm;
	}

	
	public Mute(){}
	
	public Mute(GeoCondition geoCondition, ChronoCondition chronoCondition){
		this.geoCondition = geoCondition;
		this.chronoCondition = chronoCondition;
	}

	public GeoCondition getGeoCondition() {
		return geoCondition;
	}

	public void setGeoCondition(GeoCondition geoCondition) {
		this.geoCondition = geoCondition;
	}

	public ChronoCondition getChronoCondition() {
		return chronoCondition;
	}

	public void setChronoCondition(ChronoCondition chronoCondition) {
		this.chronoCondition = chronoCondition;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	
}

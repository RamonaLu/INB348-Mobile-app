package inn348.muteme;

public class Mute {
	int id;
	
	GeoCondition geoCondition;
	ChronoCondition chronoCondition;
	
	public Mute(GeoCondition geoCondition, ChronoCondition chronoCondition){
		this.geoCondition = geoCondition;
		this.chronoCondition = chronoCondition;
	}
	
	@Override
	public String toString() {
		return "Description";
	}
	
	
}

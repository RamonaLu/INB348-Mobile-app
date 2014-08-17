package inn348.muteme;

import android.location.Location;

public class GeoCondition {
	int id;
	Location centre;
	int radiusMetres;
	
	public GeoCondition(Location centre, int radiusMetres)
	{
		this.centre = centre;
		this.radiusMetres = radiusMetres;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getCentre() {
		return centre;
	}

	public void setCentre(Location centre) {
		this.centre = centre;
	}

	public int getRadiusMetres() {
		return radiusMetres;
	}

	public void setRadiusMetres(int radiusMetres) {
		this.radiusMetres = radiusMetres;
	}

}

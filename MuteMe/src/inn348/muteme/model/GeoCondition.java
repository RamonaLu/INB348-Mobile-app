package inn348.muteme.model;

import android.location.Location;

import com.google.gson.annotations.Expose;
public class GeoCondition {

	@Expose
	private double longitude;
	@Expose
	private double latitude;
	@Expose
	private int radiusMetres;
	
	public static int DEFAULT_RADIUS = 50;
	public GeoCondition(double latitude, double longitude) {
		this(latitude, longitude, DEFAULT_RADIUS);
	}
	public GeoCondition(double latitude, double longitude, int radiusMetres)
	{
		this.latitude = latitude;
		this.longitude = longitude;
		this.radiusMetres = radiusMetres;
	}
	
	public int getRadiusMetres() {
		return radiusMetres;
	}
	public void setRadiusMetres(int radiusMetres) {
		this.radiusMetres = radiusMetres;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	

}

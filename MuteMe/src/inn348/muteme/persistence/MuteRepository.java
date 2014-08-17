package inn348.muteme.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.location.Location;

import com.google.gson.Gson;

import inn348.muteme.model.ChronoCondition;
import inn348.muteme.model.DayOfWeek;
import inn348.muteme.model.GeoCondition;
import inn348.muteme.model.Mute;
import inn348.muteme.model.TimeOfDay;
import inn348.muteme.model.TimeSpan;

public class MuteRepository {

	private static String repositoryFileName = "mutes.json";
	
	public MuteRepository(Context context) {
		this.context = context;
	}
	private Context context;	
	
	public void Write(Mute[] mutes) {
				
		Gson gson = new Gson();
				
		try {
			FileOutputStream outputStream = context.openFileOutput(repositoryFileName, Context.MODE_PRIVATE);

			String muteJson = gson.toJson(mutes);	
			outputStream.write(muteJson.getBytes());
			
			outputStream.close();
		} catch (Exception e) {
			  e.printStackTrace();
		}
	}
	
	public Mute[] Read() {	
		Mute[] mutes = null;
		Gson gson = new Gson();
		try {
			FileInputStream inputStream = context.openFileInput(repositoryFileName);
			Reader reader = new InputStreamReader(inputStream);
			mutes = gson.fromJson(reader, Mute[].class);
			inputStream.close();
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
		
		if (mutes == null || mutes.length == 0) {
			return CreateSampleMutes();
		}
		else {
			return mutes;
		}
	}


	public static Mute[] CreateSampleMutes() {

		TimeSpan morning = new TimeSpan(new TimeOfDay(6, 30), new TimeOfDay(9, 30));
		TimeSpan lunch = new TimeSpan(new TimeOfDay(12, 15), new TimeOfDay(13, 45));
		TimeSpan night = new TimeSpan(new TimeOfDay(23, 00), new TimeOfDay(5, 00));
		GeoCondition home = new GeoCondition(-27.455620, 153.059356);
		GeoCondition work = new GeoCondition(-27.474329, 153.027368);
		GeoCondition library = new GeoCondition(-27.474329, 153.027368);
		
		Mute sleepInOnWeekends = new Mute(
				home,
				new ChronoCondition(morning, DayOfWeek.WeekEnds)
		);
		Mute quietWorkLunches = new Mute(
				work,
				new ChronoCondition(lunch, DayOfWeek.WeekDays)
				);		
		Mute alwaysQuietInTheLibrary = new Mute(
				library,
				null
				);	

		Mute everywhereDuringWeekNights = new Mute(
				null,
				new ChronoCondition(night, DayOfWeek.WeekDays)
				);	
		Mute[] sampleMutes = new Mute[] {quietWorkLunches, sleepInOnWeekends, alwaysQuietInTheLibrary, everywhereDuringWeekNights};
				
		return sampleMutes;		
	}
	
}

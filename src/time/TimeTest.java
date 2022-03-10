package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	//getTotalSeconds tests
	@Test
	public void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue(seconds == 18305, "The seconds were not calculated properly.");
	}
	@Test 
	public void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getTotalSeconds("10:00");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"00:21:11", "33:59:59", "14:22:54"})
	public void testGetTotalSecondsBoundry(String candidate)
	{
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue(seconds >= 0 && seconds <= 86399, "The total time was out of bounds.");
	}
	
	//getSeconds tests
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05");
		assertTrue(seconds == 5, "The seconds were not calculated properly.");
	}
	@Test
	void testGetSecondsBad() {
		assertThrows(NumberFormatException.class, ()->{Time.getSeconds("abcdefghijk");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"00:21:11", "11:59:79", "14:22:54"})
	public void testGetSecondsBoundry(String candidate)
	{
		int seconds = Time.getSeconds(candidate);
		assertTrue(seconds >= 0 && seconds <= 59, "The seconds were out of bounds.");
	}
	
	//getTotalMinutes tests
	@Test
	void testGetTotalMinutesGood() {
		int mins = Time.getTotalMinutes("05:25:05");
		assertTrue(mins == 25, "The minutes were not calculated properly.");
	}
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getTotalMinutes("15");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"00:21:11", "11:79:29", "14:22:54"})
	void testGetTotalMinutesBoundry(String candidate) {
		int mins = Time.getTotalMinutes(candidate);
		assertTrue(mins >= 0 && mins <= 59, "The minutes were out of bounds.");
	}
	
	//getTotalHours tests
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("11:25:05");
		assertTrue(hours == 11, "The minutes were not calculated properly.");
	}
	@Test
	void testGetTotalHoursBad() {
		assertThrows(NumberFormatException.class, ()->{Time.getTotalHours("abcdefghijk");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"00:21:11", "11:79:29", "14:22:54"})
	void testGetTotalHoursBoundry(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue(hours >= 0 && hours <= 23, "The hours were out of bounds.");
	}

	@Test
	void testGetMillisecondsGood() {
		int millis = Time.getMilliseconds("22:14:12:222");
		assertTrue(millis == 222, "The milliseconds were not calculated properly.");
	}
	@Test
	void testGetMillisecondsBad() {
		assertThrows(NumberFormatException.class, ()->{Time.getTotalHours("abcdefghijksfd");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"00:12:23:415","11:19:20:100","12:19:20:990"})
	void testGetMillisecondsBoundry(String candidate) {
		int millis = Time.getMilliseconds(candidate);
		assertTrue(millis >= 0 && millis <= 999, "The milliseconds were out of bounds.");
	}
}

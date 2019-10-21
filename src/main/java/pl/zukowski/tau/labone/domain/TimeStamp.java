package pl.zukowski.tau.labone.domain;

import java.time.LocalDate;

public class TimeStamp {
	private LocalDate timeStamp;

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

	public TimeStamp(LocalDate timeStamp) {

		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return getTimeStamp().toString();
	}
	
}

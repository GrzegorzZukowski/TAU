package pl.zukowski.tau.labone.domain;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeStamp {
	private LocalDate timeStamp;

	public TimeStamp(){

	}

	public TimeStamp(LocalDate timeStamp) {

		this.timeStamp = timeStamp;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public String toString() {
		return getTimeStamp().toString();
	}
	
}

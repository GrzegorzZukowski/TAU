package pl.zukowski.tau.labone.domain;

import java.time.LocalDateTime;

public class TimeProvider {
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}
}

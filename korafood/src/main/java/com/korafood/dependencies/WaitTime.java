package com.korafood.dependencies;

public class WaitTime {

	public void Simply(int timeUnits) throws InterruptedException {

		Thread.sleep(timeUnits * 1000);
	}
}

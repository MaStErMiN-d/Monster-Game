package de.mastermind.thegoog.project.monstergame.gui;

public class WaitingTimeDigitalClock implements Runnable {

	private boolean exit = false;
	
	@Override
	public void run() {
		while(!exit) {
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package de.mastermind.thegoog.project.monstergame.gui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Creates a digital clock display as a simple label. Format of the clock
 * display is:<br>
 * <br>
 * day - dd.month yyyy<br>
 * hh:mm:ss<br>
 * <br>
 * where: day is weekday, dd Day in month, month Month in year, yyyy Year<br>
 * hh Hour in day, mm Minute in hour ss Second in minute<br>
 * in the system time for the local timezone.<br>
 * <br>
 * Changeable to hh:<br>
 * <br>
 * day - dd.month yyyy<br>
 * hh:mm:ss aa<br>
 * <br>
 * where: day is weekday, dd Day in month, month Month in year, yyyy Year<br>
 * hh Hour in day, mm Minute in hour, ss Second in minute, aa AM/PM-Indicator<br>
 * in the system time for the local timezone.<br>
 * <br>
 * Clock creates its own Thread
 */
public class DigitalClock extends Label {

	private String days, seconds, minutes, hours, day, dayDate, monthDate,
			yearDate, ampmClock;
	private LocalDateTime ldt;
	private LocalDate ld;
	private boolean fullUpdateNeeded = true;
	private boolean updateWithoutDate = false;
	private boolean ampm = false;
	private boolean exit = false;
	private Timeline timeline;
	private Thread time;// = new Thread(new WaitingTimeDigitalClock());

	/**
	 * Creates a digital clock label
	 */
	public DigitalClock() {
		setId("digitalClock");
		addTime();
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// System.out.println("Blubb");
				ampm = !ampm;
				fullUpdateNeeded = true;
			}
		});

		this.setCache(true);
		this.setCacheHint(CacheHint.SPEED);
		this.setCacheShape(true);

		this.getStylesheets().add(
				new File("resources/css/clock.css").toURI().toString());
		this.getStyleClass().add("DigitalClock");
	}

	// the digital clock updates once a second.
	private void addTime() {
		time = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!exit) {
					try {
						Thread.sleep(30000);// 300000);
						System.out.println("refreshing");
						if (!exit) {
							refreshDigitalClock();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				exit = false;
				timeline = new Timeline(new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent actionEvent) {
								ldt = LocalDateTime.now();
								ld = LocalDate.now();

								if (ampm) {
									if (fullUpdateNeeded) {
										days = Integer.toString(ld
												.getDayOfMonth());
										if (days.length() == 1) {
											days = "0" + days;
										}
										seconds = Integer.toString(ldt
												.getSecond());
										if (seconds.length() == 1) {
											seconds = "0" + seconds;
										}
										minutes = Integer.toString(ldt
												.getMinute());
										if (minutes.length() == 1) {
											minutes = "0" + minutes;
										}
										int hoursInt = ldt.getHour();
										if (hoursInt >= 12) {
											ampmClock = "PM";
											hoursInt = hoursInt % 12;
										} else {
											ampmClock = "AM";
										}
										hours = Integer.toString(hoursInt);
										if (hours.length() == 1) {
											hours = "0" + hours;
										}
										day = "" + ld.getDayOfWeek();
										dayDate = days;
										monthDate = "" + ld.getMonth();
										yearDate = Integer.toString(ld
												.getYear());
										fullUpdateNeeded = false;
									} else if (updateWithoutDate) {
										seconds = Integer.toString(ldt
												.getSecond());
										if (seconds.length() == 1) {
											seconds = "0" + seconds;
										}
										minutes = Integer.toString(ldt
												.getMinute());
										if (minutes.length() == 1) {
											minutes = "0" + minutes;
										}
										int hoursInt = ldt.getHour();
										if (hoursInt >= 12) {
											ampmClock = "PM";
											hoursInt = hoursInt % 12;
										} else {
											ampmClock = "AM";
										}
										hours = Integer.toString(hoursInt);
										if (hours.length() == 1) {
											hours = "0" + hours;
										}
										updateWithoutDate = false;
									} else {
										seconds = Integer.toString(ldt
												.getSecond());
										if (seconds.length() == 1) {
											seconds = "0" + seconds;
										} else {
											if (seconds.equals("59")) {
												if (minutes.equals("59")) {
													if (hours.equals("11")) {
														fullUpdateNeeded = true;
													} else {
														updateWithoutDate = true;
													}
												} else {
													updateWithoutDate = true;
												}
											}
										}
									}
									setText(day + " - " + dayDate + ". "
											+ monthDate + " " + yearDate + "\n"
											+ hours + ":" + minutes + ":"
											+ seconds + " " + ampmClock);
								} else {
									if (fullUpdateNeeded) {
										days = Integer.toString(ld
												.getDayOfMonth());
										if (days.length() == 1) {
											days = "0" + days;
										}
										seconds = Integer.toString(ldt
												.getSecond());
										if (seconds.length() == 1) {
											seconds = "0" + seconds;
										}
										minutes = Integer.toString(ldt
												.getMinute());
										if (minutes.length() == 1) {
											minutes = "0" + minutes;
										}
										hours = Integer.toString(ldt.getHour());
										if (hours.length() == 1) {
											hours = "0" + hours;
										}
										day = "" + ld.getDayOfWeek();
										dayDate = days;
										monthDate = "" + ld.getMonth();
										yearDate = Integer.toString(ld
												.getYear());
										fullUpdateNeeded = false;
									} else if (updateWithoutDate) {
										seconds = Integer.toString(ldt
												.getSecond());
										if (seconds.length() == 1) {
											seconds = "0" + seconds;
										}
										minutes = Integer.toString(ldt
												.getMinute());
										if (minutes.length() == 1) {
											minutes = "0" + minutes;
										}
										hours = Integer.toString(ldt.getHour());
										if (hours.length() == 1) {
											hours = "0" + hours;
										}
										updateWithoutDate = false;
										System.gc();
									} else {
										seconds = Integer.toString(ldt
												.getSecond());
										if (seconds.length() == 1) {
											seconds = "0" + seconds;
										} else {
											if (seconds.equals("59")) {
												if (minutes.equals("59")) {
													if (hours.equals("23")) {
														fullUpdateNeeded = true;
													} else {
														updateWithoutDate = true;
													}
												} else {
													updateWithoutDate = true;
												}
											}
										}
									}
									setText(day + " - " + dayDate + ". "
											+ monthDate + " " + yearDate + "\n"
											+ hours + ":" + minutes + ":"
											+ seconds);
								}
							}
						}), new KeyFrame(Duration.millis(1005)));// seconds(1)));
				timeline.setCycleCount(Animation.INDEFINITE);
				timeline.play();
			}
		});
		t.start();
		time.start();
	}

	public void refreshDigitalClock() {
		this.stopDigitalClock();
		System.gc();
		addTime();
	}

	public void stopDigitalClock() {
		timeline.stop();
		timeline = null;
		this.exit = true;
	}

	public boolean getExitCommand() {
		return this.exit;
	}
}
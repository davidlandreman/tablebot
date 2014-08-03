package com.tablebot

import com.tablebot.components.Servo

class Commands {

	def servo = new Servo()
	
	def startGun() {
		println "Starting Gun"
		"gpio write 25 1".execute()
	}
	
	def stopGun() {
		println "Stopping Gun"
		"gpio write 25 0".execute()
	}
	
	def fireGun() {
		println "Firing"
		"gpio write 23 1".execute()
		Thread.sleep(200);
		"gpio write 23 0".execute()
	}
	
	def forward() {
		println "Moving Forward"
		servo.moveServo("2","10%")
		servo.moveServo("1","90%")
	}
	
	def turnRight() {
		println "Moving Right"
		servo.moveServo("1","90%")
		servo.moveServo("2","90%")
	}
	
	def turnLeft() {
		println "Moving Left"
		servo.moveServo("1","10%")
		servo.moveServo("2","10%")
	}
	
	def backward() {
		println "Moving Backward"
		servo.moveServo("1","10%")
		servo.moveServo("2","90%")
	}
	
	def stop() {
		println "Stopping"
		servo.moveServo("1","51%")
		servo.moveServo("2","51%")
	}
	
}

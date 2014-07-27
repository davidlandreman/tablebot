package com.tablebot

import com.tablebot.components.Servo

class Startup {

	def servo = new Servo();
	
	static main(args) {
		def startup = new Startup();
		startup.commandLoop();
	}
	
	def commandLoop() {
		while(true) {
			def command = System.console().readLine "Command: "
			if(command == 'exit') System.exit(0)
			if(command == 'forward') {
					println "Moving Forward"
					servo.moveServo("2","10%")
					servo.moveServo("1","90%")
			}
			if(command == 'right') {
					println "Moving Right"
					servo.moveServo("1","90%")
					servo.moveServo("2","90%")
			}
			if(command == 'left') {
					println "Moving Left"
					servo.moveServo("1","10%")
					servo.moveServo("2","10%")
			}
			if(command == 'backward') {
					println "Moving Backward"
					servo.moveServo("1","10%")
					servo.moveServo("2","90%")
			}
			if(command == 'stop') {
					println "Stopping"
					servo.moveServo("1","51%")
					servo.moveServo("2","51%")
			}
		}
	}

}

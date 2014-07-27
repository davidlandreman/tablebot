package com.tablebot.components

class Servo {

	def moveServo(def id, def amt) {
		def out = new FileOutputStream("/dev/servoblaster")
		out.withWriter {
				it.println "${id}=${amt}"
		}
		out.close()
	}
	
}

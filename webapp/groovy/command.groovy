import javax.servlet.http.HttpServletResponse

import com.tablebot.Commands

def command = request.getQueryString()

def commands = new Commands()

if(command == "forward")
	commands.forward()
if(command == "backward")
	commands.backward()
if(command =="left")
	commands.turnLeft()
if(command =="right")
	commands.turnRight()
if(command == "stop")
	commands.stop()
if(command == "motor-on")
	commands.startGun()
if(command == "motor-off")
	commands.stopGun()
if(command == "fire")
	commands.fireGun()
println "Command Processed: ${command}"
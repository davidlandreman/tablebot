package com.tablebot

import groovy.servlet.GroovyServlet

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.HandlerList
import org.eclipse.jetty.server.handler.ResourceHandler
import org.eclipse.jetty.servlet.ServletContextHandler

class Startup {

	def commands = new Commands();
	
	static main(args) {
		def startup = new Startup();
		startup.startup();
	}
	
	def startup() {
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS)
		context.with {
			contextPath = '/app'
			resourceBase = 'webapp/groovy'
			addServlet(GroovyServlet, '*.groovy')
		}
		
		ResourceHandler resource_handler = new ResourceHandler();
		resource_handler.setDirectoriesListed(true);
		resource_handler.setResourceBase("webapp");
		println resource_handler.getBaseResource().getFile().absolutePath
		
		HandlerList handlers = new HandlerList();
		handlers.addHandler(context);
		handlers.addHandler(resource_handler);
		
		
		def jettyServer = new Server(1234)
		jettyServer.with {
			setHandler(handlers)
			start()
		}
		
		
		// Start console Interface
		//this.commandLoop();
	}
	
	def commandLoop() {
		while(true) {
			def command = System.console().readLine "Command: "
			if(command == 'exit') System.exit(0)
			if(command == 'start gun') {
				commands.startGun()
			}
			if(command == 'stop gun') {
				commands.stopGun()
			}
			if(command == 'fire') {
				commands.fireGun()
			}
			if(command == 'forward') {
				commands.forward()
			}
			if(command == 'right') {
				commands.turnRight()
			}
			if(command == 'left') {
				commands.turnLeft()
			}
			if(command == 'backward') {
				commands.backward()
			}
			if(command == 'stop') {
				commands.stop()
			}
		}
	}

}

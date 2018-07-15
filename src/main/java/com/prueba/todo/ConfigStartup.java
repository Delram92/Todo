package com.prueba.todo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.prueba.todo.model.Todo;
import com.prueba.todo.model.TodoEstado;

/**
 * 
 * @author Yohana Delgado Ramos
 */

public class ConfigStartup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		ObjectifyService.register(Todo.class);
		ObjectifyService.register(TodoEstado.class);

	}
}

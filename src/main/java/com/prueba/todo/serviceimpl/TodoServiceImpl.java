package com.prueba.todo.serviceimpl;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;


import com.googlecode.objectify.Key;
import com.prueba.todo.model.Todo;
import com.prueba.todo.model.TodoEstado;
import com.prueba.todo.service.TodoService;

/**
 * 
 * @author Yohana Delgado Ramos
 */

public class TodoServiceImpl implements TodoService{

	@Override
	public void actualizar(Todo todo) {
		ofy().save().entity(todo).now();		
	}
	//retorna la tarea por ID

	@Override
	public Todo consultarPorId(Long todoid) {
		Key<Todo> k = Key.create(Todo.class, todoid);
		return ofy().load().key(k).now();
	}

	//Consulta todas las tareas diferentes a las finalizadas
	@Override
	public List<Todo> consultarTodos() {
		// TODO Auto-generated method stub
		TodoEstado estado = ofy().load().type(TodoEstado.class).filter("estadoNombre","FINALIZADA").first().now();

		return ofy().load().type(Todo.class).filter("todoEstado !=", estado).list();
	}
	
	//retorna la lista de tareas finalizadas
	@Override
	public List<Todo> consultarFinalizados() {
		// TODO Auto-generated method stub
		TodoEstado estado = ofy().load().type(TodoEstado.class).filter("estadoNombre","FINALIZADA").first().now();
		return ofy().load().type(Todo.class).filter("todoEstado", estado).list();
	}



	@Override
	public void crear(Todo todo) {
		ofy().save().entity(todo).now();		
		
	}

	@Override
	public void eliminar(Todo todo) {
		ofy().delete().entity(todo).now();		
		
	}



	@Override
	public List<TodoEstado> seleccionarEstados() {
		// TODO Auto-generated method stub
		return ofy().load().type(TodoEstado.class).list();
	}

	//realiza la busqueda de la tarea tomando en cuenta el nombre 
	@Override
	public Todo consultarNombreUnico(String nombre) {
		// TODO Auto-generated method stub
		return  ofy().load().type(Todo.class).filter("todoNombre",nombre).first().now();
	}

}

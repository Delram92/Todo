package com.prueba.todo.serviceimpl;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;
import com.prueba.todo.model.Todo;
import com.prueba.todo.model.TodoEstado;
import com.prueba.todo.service.TodoEstadoServicie;

/**
 * 
 * @author Yohana Delgado Ramos
 */
public class TodoEstadoServiceImpl implements TodoEstadoServicie{


	//Consulta los estados por ID
	@Override
	public TodoEstado consultarPorId(Long estadoid) {
		Key<TodoEstado> k = Key.create(TodoEstado.class, estadoid);
		return ofy().load().key(k).now();
	}

	//Consulta todos los estados
	@Override
	public List<TodoEstado> consultarTodoEstados() {
		// TODO Auto-generated method stub
		return ofy().load().type(TodoEstado.class).list();
	}


	//Crea un nuevo estado

	@Override
	public void crear(TodoEstado estado) {
		ofy().save().entity(estado).now();	
		
	}




	//Consulta estado por nombre
	@Override
	public TodoEstado consultarNombreUnico(String nombre) {
		return  ofy().load().type(TodoEstado.class).filter("estadoNombre",nombre).first().now();
	}



}

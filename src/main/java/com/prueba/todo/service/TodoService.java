package com.prueba.todo.service;

import java.util.List;

import com.prueba.todo.model.Todo;
import com.prueba.todo.model.TodoEstado;

/**
 * 
 * @author Yohana Delgado Ramos
 */

public interface TodoService {

	public void actualizar(Todo todo);

	public Todo consultarPorId(Long todoid);

	public Todo consultarNombreUnico(String nombre);

	public List<Todo> consultarTodos();

	public List<TodoEstado> seleccionarEstados();

	public void crear(Todo todo);

	public void eliminar(Todo todo);

	public List<Todo> consultarFinalizados();

}

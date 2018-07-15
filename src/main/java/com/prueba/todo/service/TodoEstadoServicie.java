package com.prueba.todo.service;

import java.util.List;

import com.prueba.todo.model.TodoEstado;

/**
 * 
 * @author Yohana Delgado Ramos
 */

public interface TodoEstadoServicie {

	// Interfaz  que seran aplicados para crear y buscar estado

	public TodoEstado consultarPorId(Long estadoid);

	public List<TodoEstado> consultarTodoEstados();

	public void crear(TodoEstado estado);

	public TodoEstado consultarNombreUnico(String nombre);

}

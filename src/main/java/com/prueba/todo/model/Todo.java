/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.todo.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

/**
 * 
 * @author Yohana Delgado Ramos
 */


@Entity
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private Long todoid;
	
	@Index
	@NotNull
		private String todoNombre;
	
private String todoDescripcion;

	@Index
	@Load
	private
	Ref<TodoEstado> todoEstado;
	
	
	@Index

	private Date todofechaCreacion;
	
	private Date todoFechaInicio;
	private Date todofechaFin;
	
	private Long todoNumHoras;
	
	@Index
	private Long prioridad;



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (todoid != null ? todoid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Todo)) {
			return false;
		}
		Todo other = (Todo) object;
		if ((this.todoid == null && other.todoid != null)
				|| (this.todoid != null && !this.todoid.equals(other.todoid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.prueba.todo.model.Todo[ todoid=" + todoid + " ]";
	}

	
	

	
	public TodoEstado getTodoEstado() {
		return todoEstado.get();
	}

	public void setTodoEstado(TodoEstado todoEstado) {
		this.todoEstado = Ref.create(todoEstado);
	}



	
	public Long getTodoid() {
		return todoid;
	}

	public void setTodoid(Long todoid) {
		this.todoid = todoid;
	}

	public String getTodoNombre() {
		return todoNombre;
	}

	public void setTodoNombre(String todoNombre) {
		this.todoNombre = todoNombre;
	}

	public Date getTodofechaCreacion() {
		return todofechaCreacion;
	}

	public void setTodofechaCreacion(Date todofechaCreacion) {
		this.todofechaCreacion = todofechaCreacion;
	}

	/**
	 * @return the todoFechaInicio
	 */
		public Date getTodoFechaInicio() {
		return todoFechaInicio;
	}

	/**
	 * @param todoFechaInicio the todoFechaInicio to set
	 */
		public void setTodoFechaInicio(Date todoFechaInicio) {
		this.todoFechaInicio = todoFechaInicio;
	}

	/**
	 * @return the todofechaFin
	 */
	public Date getTodofechaFin() {
		return todofechaFin;
	}

	/**
	 * @param todofechaFin the todofechaFin to set
	 */
	public void setTodofechaFin(Date todofechaFin) {
		this.todofechaFin = todofechaFin;
	}

	/**
	 * @return the todoNumHoras
	 */
	public Long getTodoNumHoras() {
		return todoNumHoras;
	}

	/**
	 * @param todoNumHoras the todoNumHoras to set
	 */
	public void setTodoNumHoras(Long todoNumHoras) {
		this.todoNumHoras = todoNumHoras;
	}

	public String getTodoDescripcion() {
		return todoDescripcion;
	}

	public void setTodoDescripcion(String todoDescripcion) {
		this.todoDescripcion = todoDescripcion;
	}

	public Long getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}

	
}

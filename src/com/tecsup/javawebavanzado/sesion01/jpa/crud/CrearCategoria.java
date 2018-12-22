package com.tecsup.javawebavanzado.sesion01.jpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class CrearCategoria {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");
		
		em = emf.createEntityManager();
		
		try {
			//Empieza la Tx.
			em.getTransaction().begin();
			
			Categoria emp =  new Categoria();
			emp.setNombre("Verduras");
			emp.setDescripcion("Descripcion de verduras");
			
			//Graba registro
			em.persist(emp);
			
			//Confirma transaccion
			em.getTransaction().commit();

			
			
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
		em.close();
		emf.close();

	}
}

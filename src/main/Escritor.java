package main;

import java.util.*;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;

public class Escritor extends Thread {

	private int id;
	private int tiempoEscritura;
	private int tiempoSleep; 
	Random rnd = new Random();
	private int escritura;
	private MarcoTabla tablaEstado;
	private MarcoColaEscritores colaEscritores;
	private Semaphore mutex;
	private Semaphore wrt;
	private Fecha fecha=new Fecha();
	long time;

	
	public Escritor(int id, int tiempoEscritura, int tiempoSleepEsc, JFrame tablaEstado, JFrame colaEscritores, Semaphore mutex, Semaphore wrt){
		this.tiempoSleep=tiempoSleepEsc;
		this.id=id;
		this.tiempoEscritura=tiempoEscritura;
		this.tablaEstado=(MarcoTabla) tablaEstado;
		this.colaEscritores=(MarcoColaEscritores)colaEscritores;
		this.mutex=mutex;
		this.wrt=wrt;

	}


	public void run() {
	
		while (true){
			try {
				colaEscritores.modelo.addRow(new Object[]{"Escritor id: "+id});  // Simulacion de la cola de Escritores
				wrt.acquire();	//wait (p)
					System.out.println("Escritor: "+id+" Iniciando Escritura "+" dato= "+Principal.baseDatos + " Tiempo: "+fecha.mostrarFecha());
					tablaEstado.modelo.addRow(new Object[]{id, "Escritor", "Inicio Escritura", fecha.mostrarFecha()});
					Principal.baseDatos=rnd.nextInt(1000);		 //Escribiendo en la base de datos
					Thread.sleep(tiempoEscritura);
					System.out.println("Escritor: "+id+" Finalizando Escritura "+" dato= "+Principal.baseDatos + " Tiempo: "+fecha.mostrarFecha());
					tablaEstado.modelo.addRow(new Object[]{id, "Escritor", "Fin Escritura", fecha.mostrarFecha()});
					colaEscritores.modelo.removeRow(colaEscritores.modelo.getRowCount() - 1);  // Simulacion de la cola de Escritores
				wrt.release();	//signal (v)
				
				Thread.sleep(tiempoSleep);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
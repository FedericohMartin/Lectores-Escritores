package main;

import java.util.*;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class Lector extends Thread {

	private int id;
	private int tiempoLectura;
	private int tiempoSleep;
	private MarcoTabla tablaEstado;
	private MarcoColaLectores colaLectores;
	private Semaphore mutex;
	private Semaphore wrt;
	private Fecha fecha=new Fecha();
	long time;

	public Lector(int id, int tiempoLectura, int tiempoSleepLec, JFrame tablaEstado, JFrame colaLectores, Semaphore mutex, Semaphore wrt){
		this.tiempoSleep=tiempoSleepLec;
		this.id=id;
		this.tiempoLectura=tiempoLectura;
		this.tablaEstado=(MarcoTabla) tablaEstado;
		this.colaLectores= (MarcoColaLectores) colaLectores;
		this.mutex=mutex;
		this.wrt=wrt;
				
	
	}
	
	public void run(){
		
		while (true){
			try {
				
				mutex.acquire();	//wait (p)
					colaLectores.modelo.addRow(new Object[]{"Lector id: "+id});  // Simulacion de la cola de Lectores
					Principal.contLectores++;
					if (Principal.contLectores == 1) {
						Principal.wrt.acquire();	//wait (p)
					}
					tablaEstado.modelo.addRow(new Object[]{id, "Lector", "Inicio Lectura", fecha.mostrarFecha()});
				mutex.release();	//signal (v)
				//Leyendo Base de Datos
				
				System.out.println("Lector: "+id+ " Iniciando Lectura " +" dato= "+Principal.baseDatos+ " Tiempo: "+fecha.mostrarFecha());
				Thread.sleep(tiempoLectura);
				mutex.acquire();	//wait (p)
					Principal.contLectores--;
					if(Principal.contLectores == 0) {
						Principal.wrt.release();	//signal (v)
					}
					tablaEstado.modelo.addRow(new Object[]{id, "Lector", "Fin Lectura", fecha.mostrarFecha()});
					colaLectores.modelo.removeRow(colaLectores.modelo.getRowCount() - 1);  // Simulacion de la cola de Lectores
				mutex.release();	//signal (v)
				
				System.out.println("Lector "+id+ " Finalizando Lectura " +" dato= "+Principal.baseDatos+ " Tiempo: "+fecha.mostrarFecha());
				Thread.sleep(tiempoSleep);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
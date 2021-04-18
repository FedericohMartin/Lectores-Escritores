package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MarcoColaEscritores extends JFrame{

		public DefaultTableModel modelo = new DefaultTableModel(0,1);
	
		public MarcoColaEscritores() {
			setTitle("Cola Escritores");
			
			setBounds(300,400,300,200);
			
			JTable tablaOperadores=new JTable(modelo);
			
			Object[] newIdentifiers={"Escritoes"} ;
			modelo.setColumnIdentifiers(newIdentifiers);
			
			add(new JScrollPane(tablaOperadores), BorderLayout.CENTER);
			
			}
		
}

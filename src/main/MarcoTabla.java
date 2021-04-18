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

public class MarcoTabla extends JFrame{

		public DefaultTableModel modelo = new DefaultTableModel(0,5);
	
		public MarcoTabla() {
			setTitle("Threads");
			
			setBounds(300,400,300,200);

			JTable tablaOperadores=new JTable(modelo);
			
			Object[] newIdentifiers={"id", "Tipo de Thread", "Estado", "Tiempo"} ;
			modelo.setColumnIdentifiers(newIdentifiers);
			
			add(new JScrollPane(tablaOperadores), BorderLayout.CENTER);
			
			}
		
}

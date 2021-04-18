package main;

import java.util.Calendar;

public class Fecha extends Calendar{

		private Calendar fecha;
		private String fechaString;
		
		
		public String mostrarFecha() {
			fecha= Calendar.getInstance();
			int hora= fecha.get(Fecha.HOUR);
			int min= fecha.get(Fecha.MINUTE);
			int seg= fecha.get(Fecha.SECOND);
			int mili= fecha.get(Fecha.MILLISECOND);
			fechaString= hora+ ":" +min +":"+ seg+ ":"+mili;
			return fechaString;
		}

		@Override
		public void add(int field, int amount) {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void computeFields() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void computeTime() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getGreatestMinimum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getLeastMaximum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMaximum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMinimum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void roll(int field, boolean up) {
			// TODO Auto-generated method stub
			
		}
}

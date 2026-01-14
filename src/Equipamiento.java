
abstract class Equipamiento {

	private String nombre;
	private String descripcion;

	// CONTRUCTOR
	public Equipamiento(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

		
	//info objeto
	@Override
	public String toString() {
		
		return  "                                            													  \n" 																																																					
				+"------------------------------ C A R A C T E R Í S T I C A S ------------------------------" 
				+"                                            													  \n" 																																																						
				+ "Nombre: " + this.nombre + "\n" 	
				+ "Descripción: " + this.descripcion +"\n";
	}

}

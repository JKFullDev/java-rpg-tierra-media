
import java.util.Random;

public abstract class Personaje {

	protected String nombre;
	protected Arma arma;
	protected Armadura armadura;
	protected Objeto objeto;
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int ataqueEspecial;
	protected int cantidadAtaqueEspecial;
	protected int vidaMaxima;
	protected int unicaInvocacion;

	public Personaje(String nombre, Arma arma, Armadura armadura, Objeto objeto, int vida, int ataque, int defensa, int ataqueEspecial, int cantidadAtaqueEspecial) {
		this.nombre = nombre;
		this.arma = arma;
		this.armadura = armadura;
		this.objeto = objeto;
		this.vida = vida;
		this.vidaMaxima = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.cantidadAtaqueEspecial = cantidadAtaqueEspecial;
		unicaInvocacion = 1;
	}

	
	// GETTERS Y SETTERS
	
	//nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//arma
	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	//armadura
	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	//objeto
	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	
	//vida
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida > vidaMaxima) {
			this.vida = vidaMaxima;
		} else {
			this.vida = vida;
		}
	}

	//ataque
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	//defensa
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	//ataqueEspecial
	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	//cantidad ataqueEspecial
	public int getCantidadAtaqueEspecial() {
		return cantidadAtaqueEspecial;
	}

	public void setCantidadAtaqueEspecial(int cantidadAtaqueEspecial) {
		this.cantidadAtaqueEspecial = cantidadAtaqueEspecial;
	}

	
	//vidaMáxima
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	//unicaInvocacion
	public int getUnicaInvocacion() {
		return unicaInvocacion;
	}


	public void setUnicaInvocacion(int unicaInvocacion) {
		this.unicaInvocacion = unicaInvocacion;
	}

	

	// METODOS
	
	//equipar arma
	public void equiparArma(Arma armaSeleccionada) {
		this.arma = armaSeleccionada;
		this.ataque += armaSeleccionada.getBonificacionAtaque();
		this.ataqueEspecial += armaSeleccionada.getBonificacionAEspecial();
		System.out.println();
        System.out.println("\n" + "¡¡ Tu arma será " + armaSeleccionada.getNombre() + " (+ " + armaSeleccionada.getBonificacionAtaque() + " Ataque | + "+ armaSeleccionada.getBonificacionAEspecial() + " AtaqueEspecial) !!");
	}
	
	
	

	//equipar armadura
	public void equiparArmadura(Armadura armaduraSeleccionada) {
		this.armadura = armaduraSeleccionada;
		this.defensa += armaduraSeleccionada.getBonificacionDefensa();
		this.vida += armaduraSeleccionada.getBonificacionVida();
		if (this.vida > this.vidaMaxima) {this.vidaMaxima = this.vida;}
		System.out.println();
		System.out.println("\n" + "¡¡ La " + armaduraSeleccionada.getNombre() + " te protegerá de tus enemigos (+ " + armaduraSeleccionada.getBonificacionDefensa() + " Defensa | + "+ armaduraSeleccionada.getBonificacionVida() + " Vida) !!");
	}
	
	
	
	//equipar objeto
	 public void equiparObjeto(Objeto objetoSeleccionado) {
	       this.objeto = objetoSeleccionado;
	        if (objetoSeleccionado.getBonificacionVida() > 0) {
	            this.vida += objetoSeleccionado.getBonificacionVida();
	            if (this.vida > this.vidaMaxima) {this.vidaMaxima = this.vida;}
	        }
	        if (objetoSeleccionado.getBonificacionAtaqueEspecial() > 0) {
	            this.cantidadAtaqueEspecial += objetoSeleccionado.getBonificacionAtaqueEspecial();
	        }
	        
	        System.out.println();
	        System.out.println("\n¡¡ " + objeto.getNombre() + " te será de ayuda (+ "+ objetoSeleccionado.getBonificacionVida() + " Vida + " + objetoSeleccionado.getBonificacionAtaqueEspecial() + " Ataques Especiales) !!");
			
	 }
	
	
	// atacar
	abstract public void atacar(boolean usarAtaqueEspecial, Personaje rival);

	

	// descansar
	public void descansar() {
		// Recupera 10 de vida, pero no puede superar la vida máxima
		int vidaRecuperada = 20;
		setVida(this.vida + vidaRecuperada);
		System.out.println();
		System.out.println(" \t\t    "+this.nombre + " ha descansado y ha ganado " + vidaRecuperada + " de vida.");

		// Crear un objeto Random para generar un número aleatorio
		Random rand = new Random();

		// Generar un número aleatorio entre 1 y 10
		int numeroAleatorio = rand.nextInt(10) + 1; // El rango es de 1 a 10 (inclusive)

		// Si el número aleatorio es 10, el personaje obtiene un nuevo ataque especial
		if (numeroAleatorio == 10) {
			this.cantidadAtaqueEspecial++; // Incrementar el ataque especial

			System.out.println();
			System.out.println(" \t\t    "+this.nombre + " ha recibido un ataque especial adicional por descansar.");
		}
	}

	//invocar
	public abstract void invocar();
	
	
	// info básica personaje
		@Override
		public String toString() {
			
			return  "                                            													  \n" 
					+"                                            													  \n" 																																																						
					+"-------------------------------- 📊 INFORMACION "+ this.nombre.toUpperCase() + " 📊 -----------------------------------" 
					+"                                            													  \n" 
					+"                                            													  \n" 
					+ "EQUIPAMIENTO |\n" 
					+ "-------------- \n" 
					+ "Arma: " + arma.getNombre() +"\n" 									 																																																						
					+ "Armadura: " + armadura.getNombre() + "\n" 							 																																																						
					+ "Objeto: " + objeto.getNombre() + "\n" 	
					+"                                            													  \n" 
					+ "STATS |\n" 
					+ "------- \n" 
					+ "❤️ Vida: " + this.vida +"\n" 																																																													
					+ "🗡️ Ataque: " + this.ataque + "\n" 																																																					
					+ "🛡️ Defensa: " + this.defensa + "\n" 
					+ "⚔️ Ataque Especial: " + this.ataqueEspecial + " (x"+ this.cantidadAtaqueEspecial + " veces)\n" ;
		}




		
}

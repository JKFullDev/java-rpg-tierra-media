
import java.util.Random;

public class Humano extends Personaje {

	private int curiosidad;
	
	public Humano() {
		super("Aragorn", null, null, null, 120, 100, 85, 140, 2);
		this.curiosidad = 15;
	}

	@Override
	public void atacar (boolean usarAtaqueEspecial, Personaje rival) {
		
		// habilidad de Elfo
		Random rand = new Random();
		boolean encontrado =  rand.nextInt(100) < this.curiosidad;
		
		if(encontrado) {
			this.cantidadAtaqueEspecial++;
			System.out.println();
			System.out.println("\t\t\t  "+"¡Aragorn ha encontrado un Ataque Especial!");
		}

		
		// variable daño
		int danio = 0;
		
		// si el usuario elige usar el ataque especial y aun le queda un ataque especial
		// hace un total de daño de la suma del personaje mas el ataque especial
		if (this.cantidadAtaqueEspecial > 0 && usarAtaqueEspecial == true) {
			danio = this.ataqueEspecial - rival.defensa;
			rival.setVida(rival.getVida() - danio);
			this.cantidadAtaqueEspecial--;
			System.out.println();
			System.out.println("\t\t\t  "+this.nombre + " ha usado un ataque especial!");
		}
		// si ataque especial es menor a 1 no se puede utilizar el ataque especial
		// asique
		// el único daño que provoca es el que causa el propio personaje
		else if (this.cantidadAtaqueEspecial < 1 && usarAtaqueEspecial == true) {
			System.out.println();
			System.out.println("\t\t\t  "+"¡No tienes fuerza para usar tu ataque especial");
			danio = (this.ataque - rival.defensa);
			rival.vida -= danio;
		}
		// si el usuario no quiere usar su ataque especial, el único daño que
		// provoca es el que causa el propio personaje
		else if (usarAtaqueEspecial == false) {
			danio = (this.ataque - rival.defensa);
			rival.vida -= danio;
		}
		
		System.out.println();
		System.out.println("\t\t\t  "+"Has causado " + danio + " puntos de daño.");
	
		if (rival.getVida() <= 0) {
			System.out.println();
			System.out.println("\t\t\t  "+rival.getNombre() + " ha sido derrotado!");
		}
		
	}


	@Override
	public void invocar() {
		vida += 15;
	    ataque += 10;
	    defensa += 10;
	    System.out.println();
	    System.out.println("\t\t\t  "+this.nombre + " invoca la Sabiduría de Gandalf y gana 15 puntos de vida, y 10 puntos de ataque y defensa!");
	}
	
	
}

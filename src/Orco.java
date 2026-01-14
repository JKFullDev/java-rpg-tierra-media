import java.util.Random;

public class Orco extends Personaje {

	private int rabia;
	
	public Orco() {
		super("Azog", null, null, null, 130, 110, 75, 130, 2);
		this.rabia = 10;
	}

	@Override
	public void atacar (boolean usarAtaqueEspecial, Personaje rival) {
		
		// habilidad de Elfo
		Random rand = new Random();
		boolean destrozar =  rand.nextInt(100) < this.rabia;
		
		if(destrozar) {
			rival.defensa-=20;
			System.out.println();
			System.out.println("\t\t\t  "+"¡Azog anula 20 puntos de defensa de su rival!");
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
		
		// si se habia activado la habilidad de Azog, se devuelven los valores por defecto a la defensa del rival tras atacar		
				if(destrozar) {
					rival.defensa+=30;
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
		ataque += 30;
		vida+=10;
		System.out.println();
        System.out.println("\t\t\t  "+this.nombre + " invoca el Ojo de Sauron y gana 30 puntos de ataque y 10 puntos de vida!");
	}
}

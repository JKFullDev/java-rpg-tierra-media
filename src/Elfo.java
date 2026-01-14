
import java.util.Random;

public class Elfo extends Personaje {

	private int precision;
	
	public Elfo() {
		super("Legolas", null, null, null, 105, 110, 90, 125, 2);
		this.precision = 10;
	}


	@Override
	public void atacar (boolean usarAtaqueEspecial, Personaje rival) {
		
		// habilidad de Elfo
		Random rand = new Random();
		boolean critico =  rand.nextInt(100) < this.precision;
		
		if(critico) {
			this.ataque += 20;
			this.ataqueEspecial += 10;
			System.out.println();
			System.out.println("\t\t\t  "+"¡Elron va a hacer un crítico (+20 ataque | +10 ataque Especial!");
		}

		
		// variable daño
		int danio = 0;
		
		// si el usuario elige usar el ataque especial y aun le queda algun ataque especial
		// hace un total de daño de la suma del personaje mas el ataque especial
		if (this.cantidadAtaqueEspecial > 0 && usarAtaqueEspecial == true) {
			danio = this.ataqueEspecial - rival.defensa;
			rival.setVida(rival.getVida() - danio);
			this.cantidadAtaqueEspecial--;
			System.out.println();
			System.out.println("\t\t\t  "+this.nombre + " ha usado un ataque especial!");
			
		}
		// si la cantidad de ataque especial es menor a 1 no se puede utilizar el ataque especial
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
		
		// si se habia activado la habilidad de Elron, se devuelven los valores por defecto tras atacar		
		if(critico) {
			this.ataque -= 30; 
			this.ataqueEspecial -= 20;
		}
	}

	


	@Override
	public void invocar() {
		this.vida += 40;
		System.out.println();
        System.out.println("\t\t\t  "+this.nombre + " invoca el Canto de Galadriel y recupera 40 puntos de vida!");
    }
	
}


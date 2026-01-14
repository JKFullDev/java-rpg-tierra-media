
public class Armadura extends Equipamiento{
	
    private int bonificacionDefensa;
    private int bonificacionVida;
    
    public Armadura(String nombre, String descripcion, int bonificacionDefensa, int bonificacionVida) {
        super(nombre, descripcion);
        this.bonificacionDefensa = bonificacionDefensa;
        this.bonificacionVida = bonificacionVida;
    }
    
	public int getBonificacionDefensa() {
		return bonificacionDefensa;
	}

	public void setBonificacionDefensa(int bonificacionDefensa) {
		this.bonificacionDefensa = bonificacionDefensa;
	}

	public int getBonificacionVida() {
		return bonificacionVida;
	}

	public void setBonificacionVida(int bonificacionVida) {
		this.bonificacionVida = bonificacionVida;
	}

}

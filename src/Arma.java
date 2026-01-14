
class Arma extends Equipamiento {

    private int bonificacionAtaque;
    private int bonificacionAEspecial;

    public Arma(String nombre, String descripcion, int bonificacionAtaque, int bonificacionAEspecial) {
        super(nombre, descripcion);
        this.bonificacionAtaque = bonificacionAtaque;
        this.bonificacionAEspecial = bonificacionAEspecial;
    }

	public int getBonificacionAtaque() {
		return bonificacionAtaque;
	}

	public void setBonificacionAtaque(int bonificacionAtaque) {
		this.bonificacionAtaque = bonificacionAtaque;
	}
	
	public int getBonificacionAEspecial() {
		return bonificacionAEspecial;
	}

	public void setBonificacionAEspecial(int bonificacionAEspecial) {
		this.bonificacionAEspecial = bonificacionAEspecial;
	}
	
}

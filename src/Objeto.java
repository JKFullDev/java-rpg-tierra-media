
class Objeto extends Equipamiento {
    private int bonificacionVida;
    private int bonificacionAtaqueEspecial;

    public Objeto(String nombre, String descripcion, int bonificacionVida, int bonificacionAtaqueEspecial) {
        super(nombre, descripcion);
        this.bonificacionVida = bonificacionVida;
        this.bonificacionAtaqueEspecial = bonificacionAtaqueEspecial;
    }


	public int getBonificacionVida() {
		return bonificacionVida;
	}

	public void setBonificacionVida(int bonificacionVida) {
		this.bonificacionVida = bonificacionVida;
	}

	public int getBonificacionAtaqueEspecial() {
		return bonificacionAtaqueEspecial;
	}

	public void setBonificacionAtaqueEspecial(int bonificacionAtaqueEspecial) {
		this.bonificacionAtaqueEspecial = bonificacionAtaqueEspecial;
	}


  
   
}



class Inventario {
    private Arma[] armas;
    private Armadura[] armaduras;
    private Objeto[] objetos;

    public Inventario() {
        // Definir tamaño fijo del inventario
        armas = new Arma[4];
        armaduras = new Armadura[4];
        objetos = new Objeto[4];
        inicializaEquipamiento();
    }

    private void inicializaEquipamiento() {
        // Armas con diferentes bonificaciones
        armas[0] = new Arma("Espada de Gondor", "Forjada en los fuegos de Gondor, otorgando gran poder al portador", 25, 10);
        armas[1] = new Arma("Arco de Lórien", "Un arco élfico con precisión milimétrica y un alcance impresionante", 20, 20);
        armas[2] = new Arma("Hacha de Durin", "Hacha legendaria enana, capaz de partir la roca con facilidad", 30, 10);
        armas[3] = new Arma("Maza de Morgoth", "Una maza brutal y oscura, imbuida con el poder de la sombra", 40, (-15));

        // Armaduras con diferentes bonificaciones
        armaduras[0] = new Armadura("Cota de Mithril", "Una armadura ligera pero casi impenetrable, forjada con Mithril", 15, 5);
        armaduras[1] = new Armadura("Armadura de Durin", "Protección legendaria de los reyes enanos, resistente a todo golpe", 20, (-5));
        armaduras[2] = new Armadura("Túnica Istar ", "Vestimenta de los magos, imbuida con protección mágica", 10, 15);
        armaduras[3] = new Armadura("Armadura de Morgul", "Forjada en Mordor, infunde terror en los enemigos", 25, (-10));

        
        // Objetos con diferentes bonificaciones
        objetos[0] = new Objeto("Amuleto Valar", "Bendecido por los dioses, otorga protección divina", 20, 0);
        objetos[1] = new Objeto("Capa Élfica", "Te vuelve casi invisible y protege contra la magia", 15, 1);
        objetos[2] = new Objeto("Escudo Enano", "Escudo de Mithril, capaz de resistir cualquier ataque", 20, 1);
        objetos[3] = new Objeto("Anillo Único", "Otorga poder inmenso, pero a un gran costo", 10, 2);
    }

    public void mostrarArmas() {
        System.out.println("\n"
                            +"╔═══════════════════════════════════════════════════════ ARMAS DISPONIBLES ═══════════════════════════════════════════════════════╗"
        );
        for (int i = 0; i < armas.length; i++) {
        	System.out.println();
            System.out.println("    "+(i + 1) + ". " + armas[i].getNombre() + " - " + armas[i].getDescripcion() + " (+ " + armas[i].getBonificacionAtaque() + " Ataque | + "+ armas[i].getBonificacionAEspecial() + " AtaqueEspecial)");
        }
        System.out.println("\n"
                            +"╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
        );
    }
    
    public void mostrarArmaduras() {
        System.out.println("\n"
        +"╔═════════════════════════════════════════════════════ ARMADURAS DISPONIBLES ═════════════════════════════════════════════════════╗"
        );
        for (int i = 0; i < armaduras.length; i++) {
        	System.out.println();
            System.out.println("    "+(i + 1) + ". " + armaduras[i].getNombre() + " - " + armaduras[i].getDescripcion() + " (+ " + armaduras[i].getBonificacionDefensa() + " Defensa | + "+ armaduras[i].getBonificacionVida() + " Vida)");
        }
        System.out.println("\n"
        +"╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
        );
    }

    public void mostrarObjetos() {
        System.out.println("\n"
        +"╔══════════════════════════════════════════════════════ OBJETOS DISPONIBLES ══════════════════════════════════════════════════════╗"
        );
        for (int i = 0; i < objetos.length; i++) {
        	System.out.println();
            System.out.println("    "+(i + 1) + ". " + objetos[i].getNombre() + " - " + objetos[i].getDescripcion()+ " (+ " + objetos[i].getBonificacionVida() + " Vida | + "+ objetos[i].getBonificacionAtaqueEspecial() + " Ataques Especiales)");
        }
        System.out.println("\n"
        +"╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
        );
    }

    public Arma obtenerArma(int indice) {
        if (indice >= 0 && indice < armas.length) {
            return armas[indice];
        }
        return null;
    }

    public Armadura obtenerArmadura(int indice) {
        if (indice >= 0 && indice < armaduras.length) {
            return armaduras[indice];
        }
        return null;
    }
    
    public Objeto obtenerObjeto(int indice) {
        if (indice >= 0 && indice < objetos.length) {
            return objetos[indice];
        }
        return null;
    }
}

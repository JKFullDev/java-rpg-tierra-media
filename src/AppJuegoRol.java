import java.util.Scanner;

public class AppJuegoRol {

    //Metodo para pantalla principal
    private static void inicio() {

    limpiarConsola();
    System.out.println(
              "         ___     ___                                                                                             \r\n"
              + "\"T$$$P\"   |  |_| |_                                                                                             \r\n"
              + " :$$$     |  | | |_                                                                                             \r\n"
              + " :$$$                                                      \"T$$$$$$$b.                                          \r\n"
              + " :$$$     .g$$$$$p.   T$$$$b.    T$$$$$bp.                   BUG    \"Tb      T$b      T$P   .g$P^^T$$  ,gP^^T$$ \r\n"
              + "  $$$    d^\"     \"^b   $$  \"Tb    $$    \"Tb    .s^s. :sssp   $$$     :$; T$$P $^b.     $   dP\"     `T :$P    `T\r\n"
              + "  :$$   dP         Tb  $$   :$;   $$      Tb  d'   `b $      $$$     :$;  $$  $ `Tp    $  d$           Tbp.   \r\n"
              + "  :$$  :$;         :$; $$   :$;   $$      :$; T.   .P $^^    $$$    .dP   $$  $   ^b.  $ :$;            \"T$$p.  \r\n"
              + "  $$$  :$;         :$; $$...dP    $$      :$;  `^s^' .$.     $$$...dP\"    $$  $    `Tp $ :$;     \"T$$      \"T$b \r\n"
              + "  $$$   Tb.       ,dP  $$\"\"\"Tb    $$      dP \"\"$\"\"$\" \"$\"$^^  $$$\"\"T$b     $$  $      ^b$  T$       T$ ;      $$;\r\n"
              + "  $$$    Tp._   _,gP   $$   `Tb.  $$    ,dP    $  $...$ $..  $$$   T$b    :$  $       `$   Tb.     :$ T.    ,dP \r\n"
              + "  $$$;    \"^$$$$$^\"   d$$     `T.d$$$$$P^\"     $  $\"\"\"$ $\"\", $$$    T$b  d$$bd$b      d$b   \"^TbsssP\" 'T$bgd$P  \r\n"
              + "  $$$b.____.dP                                 $ .$. .$.$ss,d$$$b.   T$b.                                       \r\n"
              + ".d$$$$$$$$$$P                                                         `T$b."
            );
    System.out.println("\n"
                      +"\n"
                      +"\n"
                      +"	╔════════════──── · ────════════════╗\n"
                      +"	          1. Jugar   				  \n"
                      +"	          2. Ver personajes           \n"
                      +" 	          3. ¿Cómo jugar?          	  \n"
                      +"	          4. Salir          		  \n"
                      +"	╚════════════──── · ────════════════╝"
                      +"\n"
                       );
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("	Elige una opción: ");
    int opcion = scanner.nextInt();
    
    switch (opcion) {
    case 1:
        limpiarConsola();
        jugar();
        break;
    case 2:
        limpiarConsola();
        verPersonajes();
        break;
    case 3:
        limpiarConsola();
        comoJugar();
        break;

    case 4:
        limpiarConsola();
        System.out.println("Has salido con exito...");
        break;
        
        
    
    }
}

    //1. Metodo para Jugar 
    private static void jugar() {
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        // --- AQUÍ ESTÁ EL CAMBIO IMPORTANTE: REUTILIZAMOS CÓDIGO ---
        Personaje p1 = elegirPersonaje(1);
        
        // Limpiamos consola entre jugadores para que quede bonito
        limpiarConsola(); 
        
        Personaje p2 = elegirPersonaje(2);
        // -----------------------------------------------------------
        
        int turno = 1;
        
         while (p1.vida > 0 && p2.vida > 0) {
                
            limpiarConsola();
                System.out.println("                              ═══════════════════╗");
                System.out.println("                                    R O N D A  " + turno);
                System.out.println("                                 ╚════════════════════");
                descripcionPersonajes(p1, p2);
                String opcion ="";
             // Accion personaje 1
                System.out.println();
                System.out.println("			╭─────────────────────────────────────╮");
                System.out.println("			|              JUGADOR 1              |");
                System.out.println("			╰─────────────────────────────────────╯");
                System.out.println();

                do {
                    System.out.println(" 		   	     ATACAR (1) ||  DESCANSAR (2)");
                    opcion = scanner.nextLine();
                    if (opcion.equalsIgnoreCase("1")) {
                        verificarInvocacion(p1, scanner);
                        System.out.println();
                        System.out.print(" \t\t    ¿Usar ataque especial? (s/n) => ");
                        String usarAE = scanner.nextLine();
                        if (usarAE.equalsIgnoreCase("S")) {
                            p1.atacar(true, p2);
                        }
                        else {
                            p1.atacar(false, p2);
                        }
                    } else if(opcion.equalsIgnoreCase("2")){
                        verificarInvocacion(p1, scanner);
                        p1.descansar();
                    }
                } while (!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2"));
                
                if (p2.vida <= 0) {
                    esperar(3);
                    limpiarConsola();
                    System.out.println(
                        "                                                                                                                                                    \r\n" + //
                        "                                                                                                                                                    \r\n" + //
                        "                                                                                                                                                    \r\n" + //
                        " ██████╗  █████╗ ███╗   ██╗ █████╗ ██████╗  ██████╗ ██████╗                           ██╗██╗   ██╗ ██████╗  █████╗ ██████╗  ██████╗ ██████╗      ██╗\r\n" + //
                        "██╔════╝ ██╔══██╗████╗  ██║██╔══██╗██╔══██╗██╔═══██╗██╔══██╗    ██╗                   ██║██║   ██║██╔════╝ ██╔══██╗██╔══██╗██╔═══██╗██╔══██╗    ███║\r\n" + //
                        "██║  ███╗███████║██╔██╗ ██║███████║██║  ██║██║   ██║██████╔╝    ╚═╝                   ██║██║   ██║██║  ███╗███████║██║  ██║██║   ██║██████╔╝    ╚██║\r\n" + //
                        "██║   ██║██╔══██║██║╚██╗██║██╔══██║██║  ██║██║   ██║██╔══██╗    ██╗              ██   ██║██║   ██║██║   ██║██╔══██║██║  ██║██║   ██║██╔══██╗     ██║\r\n" + //
                        "╚██████╔╝██║  ██║██║ ╚████║██║  ██║██████╔╝╚██████╔╝██║  ██║    ╚═╝              ╚█████╔╝╚██████╔╝╚██████╔╝██║  ██║██████╔╝╚██████╔╝██║  ██║     ██║\r\n" + //
                        " ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝                      ╚════╝  ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝     ╚═╝\r\n" + //
                        "                                                                                                                                                    \r\n" + //
                        "                                                                                                                                                    \r\n" + //
                        "                                                                                                                                                              "
                        );
                    break;
                }
                
                System.out.println();
                System.out.println();

                // Accion personaje 2
                System.out.println();
                System.out.println("			╭─────────────────────────────────────╮");
                System.out.println("			|              JUGADOR 2              |");
                System.out.println("			╰─────────────────────────────────────╯");
                System.out.println();

                do {
                    System.out.println(" 		   	     ATACAR (1) ||  DESCANSAR (2)");
                    opcion = scanner.nextLine();
                    if (opcion.equalsIgnoreCase("1")) {
                        verificarInvocacion(p2, scanner);
                        System.out.println();
                        System.out.print(" \t\t    ¿Usar ataque especial? (s/n) => ");
                        String usarAE = scanner.nextLine();
                        if (usarAE.equalsIgnoreCase("S")) {
                            p2.atacar(true, p1);
                        }
                        else {
                        p2.atacar(false, p1);
                        }
                    } else if(opcion.equalsIgnoreCase("2")){
                        verificarInvocacion(p2, scanner);
                        p2.descansar();
                    }
                } while (!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2"));
                
                if (p1.vida <= 0) {
                    esperar(3);
                    limpiarConsola();
                    System.out.println(
                        "                                                                                                                                                              \r\n" + //
                        "                                                                                                                                                              \r\n" + //
                        " ██████╗  █████╗ ███╗   ██╗ █████╗ ██████╗  ██████╗ ██████╗                           ██╗██╗   ██╗ ██████╗  █████╗ ██████╗  ██████╗ ██████╗     ██████╗ \r\n" + //
                        "██╔════╝ ██╔══██╗████╗  ██║██╔══██╗██╔══██╗██╔═══██╗██╔══██╗    ██╗                   ██║██║   ██║██╔════╝ ██╔══██╗██╔══██╗██╔═══██╗██╔══██╗    ╚════██╗\r\n" + //
                        "██║  ███╗███████║██╔██╗ ██║███████║██║  ██║██║   ██║██████╔╝    ╚═╝                   ██║██║   ██║██║  ███╗███████║██║  ██║██║   ██║██████╔╝     █████╔╝\r\n" + //
                        "██║   ██║██╔══██║██║╚██╗██║██╔══██║██║  ██║██║   ██║██╔══██╗    ██╗              ██   ██║██║   ██║██║   ██║██╔══██║██║  ██║██║   ██║██╔══██╗    ██╔═══╝ \r\n" + //
                        "╚██████╔╝██║  ██║██║ ╚████║██║  ██║██████╔╝╚██████╔╝██║  ██║    ╚═╝              ╚█████╔╝╚██████╔╝╚██████╔╝██║  ██║██████╔╝╚██████╔╝██║  ██║    ███████╗\r\n" + //
                        " ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝                      ╚════╝  ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝    ╚══════╝\r\n" + //
                        "                                                                                                                                                              \r\n" + //
                        "                                                                                                                                                              \r\n"
                        );
                    break;
                }
                
                esperar(1);

                turno++;
            }
            scanner.close();
    }
    
    //2. Metodo para Ver Personajes
    private static void verPersonajes() {

        Personaje personajes[] = {new Humano(), new Enano(), new Elfo(), new Orco()};

        for (int i = 0; i<personajes.length; i++){
            descripcionPersonajes(personajes[i]);
            esperar(5);
            limpiarConsola();
            
        }

         // Esperar a que el usuario pulse una tecla
         System.out.println("\nPulsa ENTER para volver al inicio...");
         @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
         scanner.nextLine(); // Espera entrada del usuario
         inicio();
    }

    //2.2.1 descripcion completa para personajes en VerPersonajes
    private static void descripcionPersonajes(Personaje personaje) {

        String descripcion = switch (personaje.getNombre()) {
            case "Aragorn" -> "Un montaraz del norte, heredero de Isildur y legítimo rey de Gondor. Valiente, sabio y un gran líder.";
            case "Thorin" -> "Príncipe de la Casa de Durin y líder de la expedición hacia Erebor. Orgulloso, valiente y determinado.";
            case "Legolas" -> "Príncipe élfico del Bosque Negro, maestro arquero y ágil guerrero. Astuto, leal y con sentidos sobrehumanos.";
            case "Azog" -> "Un despiadado orco blanco, líder de los ejércitos de Sauron y enemigo mortal de los enanos.";
            default -> "";
        };

        String raza = switch (personaje.getNombre()) {
            case "Aragorn" -> "HUMANO";
            case "Thorin" -> "ENANO";
            case "Legolas" -> "ELFO";
            case "Azog" -> "ORCO";
            default -> "";
        };
    

        System.out.println("\n"
        +"\n"
        +"	┌──────────────────────────────────────────═════════───── "+raza+" ─────═════════──────────────────────────────────────────┐\n"
        +"		Nombre: "+ personaje.getNombre() +"			 					\n"
        +"		" + descripcion + " 										 	\n"
        +"												 						\n"
        +"		Vida: "+ personaje.getVida() +"			 						\n"
        +"		Ataque: "+ personaje.getAtaque() +"			 					\n"
        +"		Ataque Especial: "+ personaje.getAtaqueEspecial() +" (x"+personaje.getCantidadAtaqueEspecial()+" veces)		\n"
        +"		Defensa: "+ personaje.getDefensa() +"			 				\n"
        +"	└──────────────────────────────────────────═════════───── "+raza+" ─────═════════──────────────────────────────────────────┘"
        +"\n"
        );

        if(raza.equalsIgnoreCase("HUMANO")) {humano();}
        if(raza.equalsIgnoreCase("ENANO")) {enano();}
        if(raza.equalsIgnoreCase("ELFO")) {elfo();}
        if(raza.equalsIgnoreCase("ORCO")) {orco();}
        

    }

    //2.2.2 descripcion completa para personajes cuando el jugador ha elegido equipamiento
    private static void descripcionPersonajes(Personaje personaje, Arma arma, Armadura armadura, Objeto objeto) {

        String descripcion = switch (personaje.getNombre()) {
            case "Aragorn" -> "Un montaraz del norte, heredero de Isildur y legítimo rey de Gondor. Valiente, sabio y un gran líder.";
            case "Thorin" -> "Príncipe de la Casa de Durin y líder de la expedición hacia Erebor. Orgulloso, valiente y determinado.";
            case "Legolas" -> "Señor de Rivendel, un elfo sabio y poderoso que lucha por la paz en la Tierra Media.";
            case "Azog" -> "Un despiadado orco blanco, líder de los ejércitos de Sauron y enemigo mortal de los enanos.";
            default -> "";
        };

        String raza = switch (personaje.getNombre()) {
            case "Aragorn" -> "HUMANO";
            case "Thorin" -> "ENANO";
            case "Legolas" -> "ELFO";
            case "Azog" -> "ORCO";
            default -> "";
        };
    

        System.out.println("\n"
        +"\n"
        +"	┌──────────────────────────────────────═════════───── "+raza+" ─────═════════──────────────────────────────────────┐\n"
        +"												 						\n"
        +"	    Nombre: "+ personaje.getNombre() +"			 					\n"
        +"		" + descripcion + " 										 	\n"
        +"												 						\n"
        +"	    ┌────────────────┐						 						\n"
        +"	    |  EQUIPAMIENTO  |									 						\n"
        +"	    └────────────────┘							 						\n"
        +"	    Arma: "+ personaje.arma.getNombre() +	"		 				\n"
        +"		 " + arma.getDescripcion() + " 									\n"
        +"												 						\n"
        +"	    Armadura: "+ personaje.armadura.getNombre() +"			 		\n"
        +"		 " + armadura.getDescripcion() + " 								\n"
        +"												 						\n"
        +"	    Objeto: "+ personaje.objeto.getNombre() +"			 			\n"
        +"		 " + objeto.getDescripcion() + " 								\n"
        +"												 						\n"
        +"	    ┌────────────────┐						 						\n"
        +"	    |  ESTADÍSTICAS  |									 						\n"
        +"	    └────────────────┘							 						\n"
        +"	    Vida: "+ personaje.getVida() +"			 						\n"
        +"	    Ataque: "+ personaje.getAtaque() +"			 					\n"
        +"	    Ataque Especial: "+ personaje.getAtaqueEspecial() +" (x"+personaje.getCantidadAtaqueEspecial()+" veces)		\n"
        +"	    Defensa: "+ personaje.getDefensa() +"			 				\n"
        +"												 						\n"
        +"	└──────────────────────────────────────═════════───── "+raza+" ─────═════════──────────────────────────────────────┘"
        +"\n"
        );

    }
    
    //2.2.3 descripcion para estadisticas durante batalla
    private static void descripcionPersonajes(Personaje p1, Personaje p2) {

        System.out.println("\n"
        +"\n"
        +"	┌─────────────────═════════───── "+p1.getNombre()+" ─────═════════──────────────────┐\n"
        +"                                                                                      \n"
        +"		Vida: "+ p1.getVida() +" / "+p1.getVidaMaxima()+"			 						\n"
        +"                                                                                      \n"
        +"		Ataque: "+ p1.getAtaque() +"			 					\n"
        +"                                                                                      \n"
        +"		Ataque Especial: "+ p1.getAtaqueEspecial() +" (x"+p1.getCantidadAtaqueEspecial()+" veces)		\n"
        +"                                                                                      \n"
        +"		Defensa: "+ p1.getDefensa() +"			 				\n"
        +"                                                                                      \n"
        +"	└─────────────────═════════───── "+p1.getNombre()+" ─────═════════──────────────────┘"
        +"\n"
        );

        System.out.println("\n"
        +"\n"
        +"	┌─────────────────═════════───── "+p2.getNombre()+" ─────═════════──────────────────┐\n"
        +"                                                                                      \n"
        +"		Vida: "+ p2.getVida()  +" / "+p2.getVidaMaxima()+"			 						\n"
        +"                                                                                      \n"
        +"		Ataque: "+ p2.getAtaque() +"			 					\n"
        +"                                                                                      \n"
        +"		Ataque Especial: "+ p2.getAtaqueEspecial() +" (x"+p2.getCantidadAtaqueEspecial()+" veces)		\n"
        +"                                                                                      \n"
        +"		Defensa: "+ p2.getDefensa() +"			 				\n"
        +"                                                                                      \n"
        +"	└─────────────────═════════───── "+p2.getNombre()+" ─────═════════──────────────────┘"
        +"\n"
        );

    }

    //3. Metodo para Como Jugar
    public static void comoJugar() {
    
        System.out.println(
              "                                                                                   \n"
            + "  ╔═══════════════════════════════════════════════════════════════════════════════╗\n"
            + "  ║                                  ¿CÓMO JUGAR?                                 ║\n"
            + "  ╠═══════════════════════════════════════════════════════════════════════════════╣\n"
            + "  ║                                                                               ║\n"
            + "  ║    El jugador 1 eligirá personaje y equipamiento (Arma, armadura y objeto)    ║\n"
            + "  ║    El jugador 2 eligirá personaje y equipamiento (Arma, armadura y objeto)    ║\n"
            + "  ║                                                                               ║\n"
            + "  ║   ¡Comienza la batalla!                                                       ║\n"
            + "  ║   En cada turno el jugador puede atacar (1 + enter) o descansar (2 + enter)   ║\n"
            + "  ║       -Atacar: se podrá elegir si usar el ataque especial o no (Si tiene      ║\n"
            + "  ║        ataques especiales disponibles) e infligirá el daño corresponiente     ║\n"
            + "  ║                                                                               ║\n"
            + "  ║       -Descansar: el jugador recuperará 20 puntos de vida y tendrá un 10%     ║\n"
            + "  ║        de probabilidad de encontrar un ataque especial                        ║\n"
            + "  ║                                                                               ║\n"
            + "  ║    Durante los ataques cada personaje tiene cierta probabilidad de activar    ║\n"
            + "  ║    su atributo especial:                                                      ║\n"
            + "  ║       - Humano: 20% Curiosidad (+1 Cantidad ataque especial)                  ║\n"
            + "  ║       - Enano: 10% Resistencia (+10 Defensa )                                 ║\n"
            + "  ║       - Elfo: 10% Critico (+30 Ataque | +20 Ataque especial)                  ║\n"
            + "  ║       - Orco: 10% Destrozar (-30 Defensa rival)                               ║\n"
            + "  ║                                                                               ║\n"
            + "  ║    Cuando uno de los jugadores tenga menos del 25% de su vida máxima podrá    ║\n"
            + "  ║    usar su invocación (máximo 1 vez)                                          ║\n"
            + "  ║       - Humano: Sabiduría de Gandalf (+15 vida | +15 defensa | +15 ataque)    ║\n"
            + "  ║       - Enano: Gloria de los Enanos (+20 Defensa )                            ║\n"
            + "  ║       - Elfo: Canto de Galadriel (+50 vida)                                   ║\n"
            + "  ║       - Orco: Ojo de Sauron (+30 ataque)                                      ║\n"
            + "  ║                                                                               ║\n"
            + "  ║     Cuando la vida de uno de los jugadores sea igual o menos a 0, habrá       ║\n"
            + "  ║     perdido el combate y su rival será el ganador                             ║\n"
            + "  ║                                                                               ║\n"
            + "  ║     CONSEJO: Cada personaje y equipamiento tiene fortalezas y debilidades     ║\n"
            + "  ║     ¡Elige sabiamente y usa estrategias para ganar!                           ║\n"
            + "  ║                                                                               ║\n"
            + "  ╚═══════════════════════════════════════════════════════════════════════════════╝\n"
            + "                                                                                   \n"
            + "   Pulsa ENTER para volver al menú principal..."
        );
    
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Espera a que el usuario presione ENTER
        inicio();
    }

    //mostrar las opciones de personaje
    private static void menuPersonajes() {
        System.out.println( "  ================================================ \n"
                + "   |               P E R S O N A J E S          |\n"
                + "  ================================================ \n"
                + "   |      	1.Humano  =>  Aragorn	        |    \n"
                + "   |	        2.Enano   =>  Thorin	 	|    \n"
                + "   |	        3.Elfo    =>  Legolas	        |    \n"
                + "   |            4.Orco    =>  Azog	 	| \n"
                + "  ================================================ \n");

        System.out.println();
    }

    // --- NUEVO MÉTODO UNIFICADO (REFECTORIZADO) ---
    private static Personaje elegirPersonaje(int numeroJugador) {

        @SuppressWarnings("resource")
        Scanner eleccion = new Scanner(System.in);

        String eleccionUsuario = "";
        Personaje p = null;
        
        System.out.println();
        System.out.println("      |─────────────────────────────────────|");
        // Usamos la variable numeroJugador para que sirva para los dos
        System.out.println("      |              JUGADOR " + numeroJugador + "              |");
        System.out.println("      |─────────────────────────────────────|");
        System.out.println();
        
        menuPersonajes();
        
        System.out.println();
        
        // Eleccion personaje
        System.out.println("ELIGE PERSONAJE: ");
        do {
            System.out.print("(Introduzca 1, 2, 3 o 4) => ");
            eleccionUsuario = eleccion.nextLine();
        } while (!eleccionUsuario.equalsIgnoreCase("1") && !eleccionUsuario.equalsIgnoreCase("2")  && !eleccionUsuario.equalsIgnoreCase("3")  && !eleccionUsuario.equalsIgnoreCase("4") );

        switch (eleccionUsuario) {
        case "1":
            p = new Humano();
            break;
        case "2":
            p = new Enano();
            break;
        case "3":
            p = new Elfo();
            break;
        case "4":
            p = new Orco();
            break;
        default:
            break;
        }

         System.out.println();
        
         System.out.println("Personaje elegido: ");
         descripcionPersonajes(p);

         esperar(3);
         limpiarConsola();
         System.out.println();
         System.out.println("·····························································································································");
         System.out.println();
          
         Inventario inventario = new Inventario();
         
            // Mostrar armas y permitir elegir
         Arma armaSeleccionada = null;
         
         inventario.mostrarArmas();
         do {
             System.out.println();
             System.out.print("\n" + p.nombre + ", elige tu arma (número): ");
             int opcionArma = eleccion.nextInt() - 1;
             armaSeleccionada = inventario.obtenerArma(opcionArma);
             if (armaSeleccionada == null) {
                 System.out.println();
                 System.out.println("Selección inválida, intenta nuevamente.");
             }
         } while (armaSeleccionada == null);
         p.equiparArma(armaSeleccionada);

         System.out.println();
         System.out.println("·····························································································································");
         System.out.println();
         
         // Mostrar armaduras y permitir elegir
         Armadura armaduraSeleccionada = null;
         
         inventario.mostrarArmaduras();
            do {
                System.out.println();
                System.out.print("\n" + p.getNombre() + ", elige tu armadura (número): ");
                int opcionArmadura = eleccion.nextInt() - 1;
                armaduraSeleccionada = inventario.obtenerArmadura(opcionArmadura);
                if (armaduraSeleccionada == null) {
                    System.out.println("Selección inválida. Inténtalo de nuevo.");
                }
            } while (armaduraSeleccionada == null);
            p.equiparArmadura(armaduraSeleccionada);
            
          System.out.println();
          System.out.println("·····························································································································");
          System.out.println();
             
          Objeto objetoSeleccionado;
            // Mostrar objetos y permitir elegir
            
            inventario.mostrarObjetos();
            do {
                System.out.println();
                System.out.print("\n" + p.getNombre() + ", elige tu objeto (número): ");
                int opcionEquipamiento = eleccion.nextInt() - 1;
                objetoSeleccionado = inventario.obtenerObjeto(opcionEquipamiento);
                if (objetoSeleccionado == null) {
                    System.out.println();
                    System.out.println("Selección inválida. Inténtalo de nuevo.");
                }
            } while (objetoSeleccionado == null);
            p.equiparObjeto(objetoSeleccionado);

            limpiarConsola();

            // Mostrar estadísticas del personaje después de equiparse
            System.out.println();
            descripcionPersonajes(p, armaSeleccionada, armaduraSeleccionada, objetoSeleccionado);
 
            String continuar = "";

            do {
                System.out.println();
                System.out.println("¿CONTINUAR?(s/n)");

                continuar = eleccion.next();

                if(continuar.equalsIgnoreCase("s")) {break;}

                // Recursividad: Si dice que no, volvemos a llamar a este mismo metodo
                else if(continuar.equalsIgnoreCase("n")){ return elegirPersonaje(numeroJugador); }

            } while (!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n"));
            

        return p;
    }

    //limpiar consola
    private static void limpiarConsola() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Error al borrar la consola.");
        }
    }

    //esperar x segundos antes de continuar
    public static void esperar(int segundos){
            try {
                Thread.sleep(segundos * 1000);
             } catch (Exception e) {
                System.out.println(e);
             }
     }
    
    //verificar si jugador quiere activar la invocacion (siempre y cuando tenga menos del 25% de su vida máxima)
    public static void verificarInvocacion(Personaje personaje, Scanner scanner) {
        if (personaje.vida < personaje.vidaMaxima * 0.25 && personaje.unicaInvocacion==1) {
            System.out.println();
            System.out.println(personaje.nombre + " está en peligro. ¿Quieres activar tu habilidad especial? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                personaje.invocar();
                personaje.unicaInvocacion--;
            }
        }
    }
    
    //ASCII enano
    public static void enano(){ 
        System.out.println("							\n"+
                        "			     _.-;-._\r\n" + //
                        "		            ;_.JL___; \r\n" + //
                        "		            F\"-/\\_-7L\r\n" + //
                        "		            | a/ e | \\\r\n" + //
                        "		           ,L,c;,.='/;,\r\n" + //
                        "		        _,-;;S:;:S;;:' '--._\r\n" + //
                        "		       ;. \\;;s:::s;;: .'   /\\\r\n" + //
                        "		      /  \\  ;::::;;  /    /  \\\r\n" + //
                        "		     / ,  k ;S';;'S.'    j __,l\r\n" + //
                        "		  ,---/| /  /S   /S '.   |'   ;\r\n" + //
                        "		 ,Ljjj |/|.' s .' s   \\  L    |\r\n" + //
                        "		 LL,_ ]( \\    /    '.  '.||   ;\r\n" + //
                        "		 ||\\ > /  ;-.'_.-.___\\.-'(|==\"(\r\n" + //
                        "		 JJ,\" /   |_  [   ]     _]|   /\r\n" + //
                        "		  LL\\/   ,' '--'-'-----'  \\  ( \r\n" + //
                        "		  ||     ;      |          |  >\r\n" + //
                        "		  JJ     |      |\\         |,/\r\n" + //
                        "		   LL    |      ||       ' | \r\n" + //
                        "		   ||    |      ||       . |\r\n" + //
                        "		   JJ    /_     ||       ;_|\r\n" + //
                        "		    LL   L \"==='|i======='_|\r\n" + //
                        "		    ||    i----' '-------';\r\n" + //
                        "		    JJ    ';-----.------,-'\r\n" + //
                        "		     LL     L_.__J,'---;'\r\n" + //
                        "		     ||      |   ,|    (\r\n" + //
                        "		     JJ     .'=  (|  ,_|\r\n" + //
                        "		      LL   /    .'L_    \\\r\n" + //
                        "		      ||   '---'    '.___>									\n"
                        );	
    }
    
    //ASCII elfo
    public static void elfo(){
        System.out.println("\n"+
                        "		                   .;;,.\r\n" + //
                        "		                  ; '\" ;\\ \\//\r\n" + //
                        "		                 \\|a (a|7 \\//\r\n" + //
                        "		                 j| ..  | ||/\r\n" + //
                        "		                //'.--.')\\-,/\r\n" + //
                        "		              .-||- '' ||/  `-.\r\n" + //
                        "		             ;  | \\ |/ |/ L.  ,|\r\n" + //
                        "		             f\\ |\\| Y  || \\ '._\\\r\n" + //
                        "		            j | \\|     (| |   | |\r\n" + //
                        "		           |  L_\\         L.__: |\r\n" + //
                        "		            \\(  '-.,-,    |   ; |\r\n" + //
                        "		             |'-.'.L_rr>  f--f  |\r\n" + //
                        "		.-=,,______,--------- J-. ;  ;__ \r\n" + //
                        "		   ``\"-,__   |  |      h  |  f  '--.__\r\n" + //
                        "		       `--;;--,_       h  f-j   |   __;==-.\r\n" + //
                        "		            / `-''-,,__J,'  \\_..--:'-'     '\r\n" + //
                        "		            | |    `' --L7//'-'`|\r\n" + //
                        "		            | ,     ||  h    |  (\r\n" + //
                        "		            | ;     | \\ J    j   |\r\n" + //
                        "		            | L__   | |  L_.'    |\r\n" + //
                        "		            |   |'-.| L.'h  |  : |\r\n" + //
                        "		            |;  \\     |  J ; : : |\r\n" + //
                        "		            | :  (    \\  'L| : : |\r\n" + //
                        "		            | ;   \\'.--|    \\  : |\r\n" + //
                        "		            | | : \\    \\-, /`\\ : |\r\n" + //
                        "		            L-'-;__\\   \\\\ '  | | |\r\n" + //
                        "		                    ;   \\\\   |'L_j\r\n" + //
                        "		                    _>  _|   |\r\n" + //
                        "		                   <___/ /-  \\\r\n" + //
                        "		                        /    /\r\n" + //
                        "		                        '---'"
        );
    }
    
    //ASCII humano
    public static void humano(){
        System.out.println("					 \r\n" + //
                        "		                    '-: __ :-'\r\n" + //
                        " 		                   -:  )(_ :--\r\n" + //
                        "		                    -' |r-_i'-\r\n" + //
                        "		            ,sSSSSs,   (2-,7\r\n" + //
                        "		            sS';:'`Ss   )-j\r\n" + //
                        "		           ;K e (e s7  /  (\r\n" + //
                        "		            S, ''  SJ (  ;/\r\n" + //
                        "		            sL_~~_;(S_)  _7\r\n" + //
                        "		|,          'J)_.-' />'-' `Z\r\n" + //
                        "		j J         /-;-A'-'|'--'-j\\\r\n" + //
                        "		 L L        )  |/   :    /  \\\r\n" + //
                        "		  \\ \\       | | |    '._.'|  L\r\n" + //
                        "		   \\ \\      | | |       | \\  J\r\n" + //
                        "		   \\ \\    _/ | |       |  ',|\r\n" + //
                        "		     \\ L.,' | | |       |   |/\r\n" + //
                        "		    _;-r-<_.| \\=\\    __.;  _/\r\n" + //
                        "		      {_}\"  L-'  '--'   / /|\r\n" + //
                        "		            |   ,      |  \\|\r\n" + //
                        "		            |   |      |   \")\r\n" + //
                        "		            L   ;|     |   /|\r\n" + //
                        "		           /|    ;     |  / |\r\n" + //
                        "		          | |    ;     |  ) |\r\n" + //
                        "		         |  |    ;|    | /  |\r\n" + //
                        "		         | ;|    ||    | |  |\r\n" + //
                        "		         L-'|____||    )/   |\r\n" + //
                        "		             % %/ '-,- /    /\r\n" + //
                        "		             |% |   \\%/_    |\r\n" + //
                        "		          ___%  (   )% |'-; |\r\n" + //
                        "		        C;.---..'   >%,(   \"'\r\n" + //
                        "		                   /%% /\r\n" + //
                        "		                  Cccc'								\n"
        
        );
    }
    
    //ASCII orco
    public static void orco(){
        System.out.println(
                "							\r\n" + //
                "		                    .'---`\",\r\n" + //
                "		                   ;        \\\r\n" + //
                "		            .---._; ^,       ;\r\n" + //
                "		         .-'      ;{ :  .-. ._;\r\n" + //
                "		    .--\"\"          \\*'   o/ o/\r\n" + //
                "		   /   ,  /         :    _`\";\r\n" + //
                "		  ;     \\;          `.   `\"+'\r\n" + //
                "		  |      }    /    _.'T\"--\"\\\r\n" + //
                "		  :     /   .'.--\"\"-,_ \\    ;\r\n" + //
                "		   \\   /   /_         `,\\   ;\r\n" + //
                "		    : /   /  `-.,_      \\`.  :\r\n" + //
                "		    |;   {     .' `-     ; `, \\\r\n" + //
                "		    : \\  `;   {  `-,__..-'   \\ `}+=,\r\n" + //
                "		     : \\  ;    `.   `,        `-,\\\"\r\n" + //
                "		     ! |\\ `;     \\}?\\|}\r\n" + //
                "		  .-'  | \\ ;\r\n" + //
                "		.'}/ i.'  \\ `,                              \r\n" + //
                "		``''-'    /   \\\r\n" + //
                "		         /J|/{/\r\n" + //
                "		           `'"
        );
    }

    //Main
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        inicio();
        
        scanner.close();
    }
    
}
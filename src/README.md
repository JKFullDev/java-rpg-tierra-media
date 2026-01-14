# ⚔️ Batalla por la Tierra Media - Java RPG

> Un juego de rol por consola basado en el universo de El Señor de los Anillos, desarrollado en Java aplicando principios sólidos de Programación Orientada a Objetos (POO).

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![RPG](https://img.shields.io/badge/Genre-RPG-red?style=for-the-badge)
![Console](https://img.shields.io/badge/Platform-Console-lightgrey?style=for-the-badge)

## 📖 Descripción
Este proyecto es un simulador de batalla por turnos donde dos jugadores se enfrentan encarnando a héroes y villanos legendarios de la Tierra Media. El juego implementa mecánicas complejas como **probabilidades de crítico**, **equipamiento estratégico** e **invocaciones únicas**.

El objetivo principal fue demostrar el dominio de conceptos de POO como **Herencia**, **Polimorfismo**, **Abstracción** y **Encapsulamiento**.

---

## 🚀 Características Principales

### 🎭 Clases y Razas Únicas
Cada personaje tiene estadísticas base y una habilidad pasiva única que se activa por probabilidad:
* **Humano (Aragorn):** *Curiosidad* (20% prob. de ganar ataques especiales extra).
* **Enano (Thorin):** *Resistencia* (10% prob. de aumentar drásticamente su defensa).
* **Elfo (Legolas):** *Crítico* (10% prob. de un golpe letal con daño masivo).
* **Orco (Azog):** *Destrozar* (10% prob. de reducir la armadura del rival).

### ⚔️ Sistema de Combate Profundo
* **Ataques Especiales:** Gestiona tu recurso de ataques poderosos.
* **Descanso Táctico:** ¿Arriesgarse a atacar o descansar para recuperar vida y buscar un ataque especial?
* **Invocaciones:** Cuando la salud cae por debajo del 20%, cada raza puede invocar una ayuda divina (ej. *Canto de Galadriel* u *Ojo de Sauron*) para cambiar las tornas del combate.

### 🛡️ Inventario y Equipamiento
Antes de la batalla, cada jugador personaliza su build eligiendo:
1.  **Arma:** Bonificadores de Ataque y Daño Especial.
2.  **Armadura:** Balance entre Defensa y Vida extra (o penalizaciones).
3.  **Objeto Mágico:** Reliquias como el *Anillo Único* o la *Capa Élfica*.

### 🎨 Experiencia Visual
* **Arte ASCII:** Gráficos en consola para cada raza y menús estilizados.
* **Feedback Inmersivo:** Mensajes detallados de combate y narrativa.

---

## 🛠️ Tecnologías y Conceptos Aplicados
Este no es solo un juego, es una demostración técnica de ingeniería de software:

* **POO Avanzada:** Uso de clases abstractas (`Personaje`, `Equipamiento`) para definir plantillas comunes.
* **Polimorfismo:** Sobrescritura del método `atacar()` para dar comportamientos únicos a cada raza.
* **Principio DRY (Don't Repeat Yourself):** Código refactorizado y modular.
* **Java Moderno:** Uso de `Switch Expressions` y manejo de flujos de entrada/salida.

---

## 🎮 Cómo Jugar

### Prerrequisitos
Tener instalado el **JDK (Java Development Kit)** versión 8 o superior.

### Instalación y Ejecución
1.  Clona el repositorio o descarga los archivos.
2.  Navega a la carpeta `src`.
3.  Compila el código:
    ```bash
    javac AppJuegoRol.java
    ```
4.  Ejecuta el juego:
    ```bash
    java AppJuegoRol
    ```
*Consejo: Nota: Se recomienda maximizar la consola o usar pantalla completa para la correcta visualización de los gráficos ASCII.*


### Controles
Sigue las instrucciones en pantalla. Usa el teclado numérico para seleccionar opciones en los menús y `ENTER` para confirmar.

---

## 📬 Contacto

LinkedIn: [Juan Carlos Alonso Hernando](https://www.linkedin.com/in/jcah-dev/)

Email: jcarlos.al.hr@gmail.com

Ubicación: Madrid, España
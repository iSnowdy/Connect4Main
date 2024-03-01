# Connect4

Solución al ejercicio: https://www.codewars.com/kata/586c0909c1923fdb89002031/train/java

# Análisis

### Descripción del programa:

- El problema consiste en un tablero de 7 columnas por 6 filas donde dos jugadores colocan discos por turnos.
- El objetivo es ser el primero en formar una línea de cuatro discos propios (horizontal o vertical).
- Implementaremos una clase Connect4 con un método play que recibe la columna donde el jugador desea colocar su disco.
- El juego debe manejar estados como victoria de un jugador, columna llena y finalización del juego, mostrando mensajes específicos en cada caso.

### El programa contiene:

1. Diseñar la clase Connect4:

  - Representación interna del tablero.
  - Inicializa el tablero y el estado del juego.
  - Alterna entre los jugadores tras cada movimiento válido.

2. Implementar el método play(int column).

  - Verifica si la columna está llena y retorna "Column full!" si es el caso.
  - Coloca el disco en la posición adecuada.
  - Verifica si el movimiento resulta en un ganador.
  - Cambia el turno al siguiente jugador si el juego continúa.

3. Métodos adicionales:

  - Verifica el estado del tablero y buscar ganadores.
  - Tener en cuenta la lógica de cambio de turnos.

4. Gestión de los estados:

  - Mantiene el control del jugador actual.
  - Mantiene el estado de la partida (en juego, ganada, etc.).

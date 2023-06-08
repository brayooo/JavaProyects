# Flight Manager
## Java 18 o superior
### Manejo del juego
* Para cambiar la velocidad y color de un avion, se debe hacer click derecho sobre este.
* El avión aterriza en el cuadrado gris situado en la parte derecha de la pista.
* Los controles para pausar, reanudar y finalizar, se encuentran en la parte superior izquierda de la pantalla.
### Posible incovenientes mientras se juega
* Puede que dos aviones nazcan en las mismas coordenadas acabando el juego, aunque visualmente no hayan aviones chocados.
* Puede que cuando se aterrice un avion, genere un error de concurrencia en la consola (No siempre pasa).
* Si el jugador pierde, debera volver a ejecutar el juego para jugar de nuevo.
* Si hay demasiados aviones volando, el cambio de ruta se vuelve más complicado, haciendo que al dibujar la nueva ruta, lo "saltos" sean más grandes de lo normal.
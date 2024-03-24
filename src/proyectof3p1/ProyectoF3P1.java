/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectof3p1;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ProyectoF3P1 {
    private static final GestorTareas gestor = new GestorTareas();
    private static final Scanner scanner = new Scanner(System. in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar todas las tareas");
            System.out.println("3. Mostrar tareas por fecha");
            System.out.println("4. Mostrar tareas por tipo");
            System.out.println("5. Modificar tarea");
            System.out.println("6. Completar tarea");
            System.out.println("7. Eliminar tarea");
            System.out.println("8. Probelmas para trabajar? Prueba nuestro pomodoro timer!");
            System.out.println("9. Cuantas tareas deberia hacer hoy?");
            System.out.println("10. Estresado de hacer tanto trabajo, prueba este mini juego!");
            System.out.println("11. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir línea restante

                            switch (opcion) {
                case 1:
                    System.out.print("Introduce la fecha de la tarea (dd/mm/yyyy): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Introduce los detalles de la tarea: ");
                    String detalles = scanner.nextLine();
                    System.out.print("Introduce el tipo de tarea (Universidad, Hogar, Trabajo, Otros): ");
                    String tipo = scanner.nextLine();
                    gestor.agregarTarea(fecha, detalles, tipo);
                    break;
                case 2:
                    gestor.mostrarTareas();
                    break;
                case 3:
                    System.out.print("Introduce la fecha para buscar tareas (dd/mm/yyyy): ");
                    fecha = scanner.nextLine();
                    gestor.mostrarTareasPorFecha(fecha);
                    break;
                case 4:
                    System.out.print("Introduce el tipo de tarea para buscar (Universidad, Hogar, Trabajo, Otros): ");
                    tipo = scanner.nextLine();
                    gestor.mostrarTareasPorTipo(tipo);
                    break;
                case 5:
                    System.out.print("Introduce el índice de la tarea a modificar: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consumir línea restante
                    System.out.print("Nueva fecha (dd/mm/yyyy): ");
                    fecha = scanner.nextLine();
                    System.out.print("Nuevos detalles: ");
                    detalles = scanner.nextLine();
                    System.out.print("Nuevo tipo (Universidad, Hogar, Trabajo, Otros): ");
                    tipo = scanner.nextLine();
                    gestor.modificarTarea(index, fecha, detalles, tipo);
                    break;
                case 6:
                    System.out.print("Introduce el indice de la tarea a completar: ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // Consumir línea restante
                    gestor.completarTarea(index);
                    break;
                case 7:
                    System.out.print("Introduce el i10"
                            + "ndice de la tarea a eliminar: ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // Consumir línea restante
                    gestor.eliminarTarea(index);
                    break;
                case 8:
                    System.out.println("Que es el pomodoro timer?");
                    System.out.println("Es una tecnica para estudiar en la que estudias 25 minutos y descansas 5 minutos");
                    System.out.println("Vamos a comnezar el temporizador para que logres temrminar tus pendientes!");
                    iniciarPomodoroTimer();
                case 9:    
                    Random random = new Random();
                    // Genera un número aleatorio entre 2 y 5, ambos inclusive.
                     int tareasRecomendadas = 2 + random.nextInt(4);
                     System.out.println("Se recomienda completar " + tareasRecomendadas + " tareas hoy.");
                     System.out.println("Este numero fue creado aleatoriamente y no nos hacemos responsables por no hacer todas tus tareas. ");
                     System.out.println("Tomar precauciones.");
                     break;
                case 10:
                    jugarAdivinaNumero();
                    break;
                case 11:
                    salir = true;
                    break;
                default:
                    if(opcion >=11){
                        System.out.println("te pasaste del numero, por lo tanto:");
                    }else{
                        System.out.println("Ingresaste un numero fuera del parametro o no ingresaste un numero.");
                    }
                    
                    System.out.println("Opción no válida. Por favor, elige otra opción.");
            }
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }
    
    
    private static void iniciarPomodoroTimer() { //ESTOS SON EXTRAS AL CODIGO
        // Matriz con tareas y sus tiempos: [0] es trabajo, [1] es descanso, en minutos
        int[][] tiempos = {{25}, {5}}; // Trabajo y Descanso en minutos

        // Ejecutar tarea de trabajo
        ejecutarTarea("Trabajo", tiempos[0][0]);

        // Ejecutar tarea de descanso
        ejecutarTarea("Descanso", tiempos[1][0]);

        System.out.println("El ciclo Pomodoro ha terminado. Puedes elegir comenzar otro o salir.");
    }

    private static void ejecutarTarea(String tarea, int duracionMinutos) {
        final long inicio = System.currentTimeMillis();
        final long duracion = duracionMinutos * 60 * 1000; // Duración en milisegundos
        System.out.println("Inicio del tiempo de " + tarea + ". Duración: " + duracionMinutos + " minutos.");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                long transcurrido = System.currentTimeMillis() - inicio;
                if (transcurrido >= duracion) {
                    System.out.println("Fin del tiempo de " + tarea + ".");
                    timer.cancel();
                } else {
                    System.out.println("Tiempo de " + tarea + " transcurrido: " + transcurrido / 1000 + " segundos.");
                }
            }
        }, 0, 10 * 1000); // Cada 10 segundos

        // Esperar a que termine la tarea
        try {
            Thread.sleep(duracion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void explicarPomodoro() {
        System.out.println("\nSaliendo...");
        System.out.println("El temporizador Pomodoro es una técnica de gestión del tiempo desarrollada por Francesco Cirillo a fines de la década de 1980.");
        System.out.println("Consiste en usar un temporizador para dividir el trabajo en intervalos, tradicionalmente de 25 minutos de duración, separados por breves intervalos de descanso.");
        System.out.println("Esta técnica ayuda a mejorar la agilidad mental y a mantener la concentración y la motivación, permitiendo gestionar mejor el tiempo de trabajo.");
    }
    private static void jugarAdivinaNumero() { // OTRO EXTRA AL CODIGO
        System.out.println("¡Bienvenido al juego de Adivina el Número!");
        System.out.println("Estoy pensando en un número entre 1 y 100. ¿Puedes adivinar cuál es?");
        
        int numeroSecreto = random.nextInt(100) + 1;
        ArrayList<Integer> intentos = new ArrayList<>();
        int intentosRestantes = 5;

        while (intentosRestantes > 0) {
            System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
            System.out.print("Ingresa tu número: ");
            int intento = scanner.nextInt();
            scanner.nextLine(); // Consumir línea restante
            intentos.add(intento);

            if (intento < numeroSecreto) {
                System.out.println("El número es mayor que " + intento + ".");
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor que " + intento + ".");
            } else {
                System.out.println("¡Felicidades! ¡Has adivinado el número " + numeroSecreto + " en " + intentos.size() + " intentos!");
                break;
            }

            intentosRestantes--;
        }

        if (intentosRestantes == 0) {
            System.out.println("¡Oh no! Has agotado todos tus intentos.");
            System.out.println("El número secreto era: " + numeroSecreto);
        }

        System.out.println("Números intentados:");
        for (int i = 0; i < intentos.size(); i++) {
            System.out.println((i + 1) + ". " + intentos.get(i));
        }
    }
       
    
}
    

class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(String fecha, String detalles, String tipo) {
        Tarea nuevaTarea = new Tarea(fecha, detalles, tipo);
        tareas.add(nuevaTarea);
    }

    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println("Índice: " + i + " - " + tareas.get(i));
            }
        }
    }

    public void mostrarTareasPorFecha(String fecha) {
        boolean encontrada = false;
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getFecha().equals(fecha)) {
                System.out.println("Índice: " + i + " - " + tareas.get(i));
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay tareas para la fecha: " + fecha);
        }
    }

    public void mostrarTareasPorTipo(String tipo) {
        boolean encontrada = false;
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getTipo().equalsIgnoreCase(tipo) && !tareas.get(i).isCompletada()) {
                System.out.println("Índice: " + i + " - " + tareas.get(i));
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay tareas del tipo: " + tipo);
        }
    }

    public void modificarTarea(int index, String fecha, String detalles, String tipo) {
        if (index >= 0 && index < tareas.size()) {
            Tarea tareaModificada = new Tarea(fecha, detalles, tipo);
            tareas.set(index, tareaModificada);
            System.out.println("Tarea modificada exitosamente.");
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }

    public void completarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            Tarea tarea = tareas.get(index);
            tarea.completarTarea();
            System.out.println("Tarea completada exitosamente.");
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }

    public void eliminarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.remove(index);
            System.out.println("Tarea eliminada exitosamente.");
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }
}
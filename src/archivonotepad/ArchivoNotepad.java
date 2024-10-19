/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivonotepad;

import java.io.IOException;

/**
 * Utilizando la clase Runtime, realiza un programa que lance un proceso hijo
 * que ejecute el notepad de Windows pasándole como argumento un fichero de
 * texto para que lo abra (crea un fichero de ejemplo en la raíz del proyecto
 * para probarlo). Los argumentos se pasan a través de la línea de comandos
 * (String[] args). *
 *
 * @author CherryReynosoCatalan
 */
public class ArchivoNotepad {

    /**
     * El método principal de la aplicación. Lanza un proceso hijo para abrir
     * Notepad y pasarle un archivo como argumento.
     *
     * @param args Los argumentos de la línea de comandos. Se espera que el
     * primer argumento sea la ruta completa del archivo de texto que se abrirá
     * en Notepad.
     */
    public static void main(String[] args) {
        // Usamos un  if para verificar si se ha pasado un argumento (ruta del archivo)
        if (args.length > 0) {

            try {
                // Creo un array con dos argumentos. Uno para ejecutar notepad y otro para indicar el archivo.
                String[] cmdArray = new String[2];

                //El primer argumento es Notepad:
                cmdArray[0] = "notepad.exe";

                //El segundo, el archivo que lo podemos proporcionar desde el IDE:
                cmdArray[1] = args[0];

                //Imprimimos un mensaje confirmano que se ejecuta NOTEPAD y el archivo.
                System.out.println("Ejecutando: " + cmdArray[0] + " y abriendo el archivo: " + cmdArray[1]);

                // Creamos el proceso para que se ejecute con runtime.exec
                Runtime.getRuntime().exec(cmdArray, null);

                //Imprimir mensaje 
                System.out.println(cmdArray[1] + " esta ahora abierto");

            } catch (IOException exc) {
                exc.printStackTrace();
            }
        } else {
            //Si no encuentra el argumento, se envia un mensaje a la consola
            System.out.println("Por favor, proporcionaun argumento.\nPara probar puede ser archivo.txt o argumento1");
        }
    }
}

//Consulta: https://stackoverflow.com/questions/31330857/how-to-use-runtime-getruntime-exec-to-run-an-arbitrary-java-program 

import java.io.*;
import java.util.ArrayList;


public class pruebaArchivo {
    private ArrayList<String> contenidoArchivo = new ArrayList<>();
    private ArrayList<edad> listaEntrada = new ArrayList<>();
    private final String rutaWindows = "C:\\Users\\Julian\\IdeaProjects\\yakshuri\\src\\datos.txt";
    public ArrayList<String> getContenidoArchivo() {
        return contenidoArchivo;
    }

    public ArrayList<edad> getListaEntrada() {
        return listaEntrada;
    }

    public void leerArchivo() {
        leerArchivo leer = new leerArchivo();
        this.contenidoArchivo =
                leer.leerArchivo(this.rutaWindows);
        for (int i = 0; i < this.contenidoArchivo.size(); i++) {
            String linea = this.contenidoArchivo.get(i);
            String elementosLinea[] = linea.split(";");
            try {
                int edadActual = Integer.parseInt(elementosLinea[0]);
                int años = Integer.parseInt(elementosLinea[1]);
                listaEntrada.add(new edad(edadActual, años));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                listaEntrada.add(new edad(0, 0));
            }
        }
    }
    public void escribirArchivo(ArrayList<edad> lista){
        String archivo = "resultados.csv";
        File f = new File(archivo);
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("");
            wr.append("edad actual, años, edad futura \n");
            for (int i=0; i < lista.size(); i++){
                wr.append(lista.get(i).getEdadActual() + "," + lista.get(i).getAños() +"," + lista.get(i).getEdadFutura() +  "\n");
            }
            wr.close();
            bw.close();
        }catch(IOException e){

        }
    }

    public static void main (String args[]){
        pruebaArchivo prueba = new pruebaArchivo();
        prueba.leerArchivo();
        for (int i=0; i < prueba.getListaEntrada().size(); i++){
            System.out.println(prueba.getListaEntrada().get(i).getEdadActual() +
                    "\t" + prueba.getListaEntrada().get(i).getAños() +
                    "\t" + prueba.getListaEntrada().get(i).getEdadFutura());
        }
        prueba.escribirArchivo(prueba.getListaEntrada());
    }
}
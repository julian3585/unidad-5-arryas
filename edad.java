
public class edad {
    private int edadActual;
    private int años;
    private int edadFutura;

    public edad(int edadActual, int años){
        this.años = años;
        this.edadActual = edadActual;
        this.calcularEdadFutura();

    }



    public int getEdadActual(){
        return  edadActual;
    }

    public  void  setEdadActual(int edadActual){
        this.edadActual = edadActual;
    }

    public  int getAños(){
        return años;
    }

    public void  setAños(int años){
        this.años = años;
    }

    public int getEdadFutura() {
        return edadFutura;
    }

    public void calcularEdadFutura(){
        this.edadFutura = this.edadActual + this.años;

    }

    public static void main(String[] args){
        edad vegetta777 = new edad(16, 6);
        System.out.println(vegetta777.getEdadFutura());
    }










}


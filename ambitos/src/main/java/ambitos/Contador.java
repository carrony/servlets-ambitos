package ambitos;

public class Contador {

	int cuenta=0;
	String mensaje;
	
	public Contador(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public void incContador() {
		this.cuenta++;
	}

	@Override
	public String toString() {
		return mensaje+": "+cuenta;
	}
	
	
}

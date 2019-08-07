import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Comparador {

	public static <E> List<Diferenca> comparar(E velho, E novo) throws Exception{
		List<Diferenca> difs = new ArrayList<>();
		
		Class<?> clazz = velho.getClass();
		
		for(Method m: clazz.getMethods()) {
			if(m.getName().startsWith("get")&& 
			m.getParameterCount() == 0 && 
			m.getReturnType() != void.class &&
			!m.isAnnotationPresent(IgnorarNaComparacao.class)) {
				
				Object valorvelho = m.invoke(velho);
				Object valornovo = m.invoke(novo);
				
				if(!valornovo.equals(valorvelho)) {
					Diferenca d = new Diferenca(m.getName(), valornovo, valorvelho);
					difs.add(d);
				}
			}
		}
		
		return difs;
	}
	
	
	
}

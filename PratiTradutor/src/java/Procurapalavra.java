/*
Nome do Programa Tradutor
Nome: Victor Propheta Erbano
data: 19/07/19
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Procurapalavra {
    
    public String recebePRT(String palavra) throws IOException {
		try {

			if (existePalavra(palavra)) {
				List<String> palavrasTraducoes = new palavras().portuingle();
				return procuraTraducao(palavra, palavrasTraducoes);
			}
		} catch (FileNotFoundException e) {
		}
		return palavra;
	}

	private String procuraTraducao(String palavra, List<String> palavrasTraducoes) {
		for (String palavraTraducao : palavrasTraducoes) {
			String[] split = palavraTraducao.split("=");
			if (split[0].equalsIgnoreCase(palavra)) {
				String traducao = split[1];
				return traducao.substring(0, 1).toUpperCase().concat(traducao.substring(1));
			}
		}
		return null;
	}

        private boolean existePalavra(String palavra) throws FileNotFoundException, IOException {
		List<String> palavras = new palavras().portuingle();
		return palavras.stream().map((p) -> p.split("=")).anyMatch((split) -> (split[0].equalsIgnoreCase(palavra)));
	}
}

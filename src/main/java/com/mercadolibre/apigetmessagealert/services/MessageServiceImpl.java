package com.mercadolibre.apigetmessagealert.services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * clase de tipo Service encargada de aplicar la logica de negocio necesaria
 * para determinar los mensajes recibidos.
 * 
 * @author ccortes5
 *
 */
@Service
public class MessageServiceImpl implements IMessageService {
	/**
	 * Metodo
	 */
	@Override
	public String getMessage(List<List<String>> messages) {

		LinkedHashSet<String> set = new LinkedHashSet<String>();
		// se itera sobre la lista de mensajes
		for (int i = 0; i < messages.size(); i++) {
			List<String> currentList = messages.get(i);
			// se toma cada una de las listas recibidas
			for (int j = 0; j < currentList.size(); j++) {
				// se comparan entre si todas las listas
				for (int x = messages.size() - 1; x >= 0; x--) {
					List<String> listComparator = messages.get(x);
					if (j < listComparator.size()) {
						// se identifica si la fracción del mensaje es igual entre las listas comparadas
						// y no es vacio " "
						if (currentList.get(j).equalsIgnoreCase(listComparator.get(j))
								&& (!currentList.get(j).equalsIgnoreCase("")
										&& !listComparator.get(j).equalsIgnoreCase(""))) {
							// se guarda la fracción del mensaje en una colección de tipo LinkedHashSet para
							// garantizar el orden del mensaje
							set.add(currentList.get(j));
						} else if (!listComparator.get(j).equals("")) {
							// la fracción del mensaje no se repite entre las listas comparadas
							set.add(listComparator.get(j));
						}
					}
				}
			}
		}

		return set.stream().map(Object::toString).collect(Collectors.joining(" "));
	}

}

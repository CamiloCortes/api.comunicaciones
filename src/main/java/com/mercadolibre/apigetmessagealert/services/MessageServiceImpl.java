package com.mercadolibre.apigetmessagealert.services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

	@Override
	public String getMessage(List<List<String>> messages) {

		LinkedHashSet<String> set = new LinkedHashSet<String>();
		for (int i = 0; i < messages.size(); i++) {
			List<String> currentList = messages.get(i);
			for (int j = 0; j < currentList.size(); j++) {

				for (int x = messages.size() - 1; x >= 0; x--) {
					List<String> listComparator = messages.get(x);
					if (j < listComparator.size()) {
						if (currentList.get(j).equalsIgnoreCase(listComparator.get(j))
								&& (!currentList.get(j).equalsIgnoreCase("")
										&& !listComparator.get(j).equalsIgnoreCase(""))) {

							set.add(currentList.get(j));
						} else if (!listComparator.get(j).equals("")) {

							set.add(listComparator.get(j));
						}
					}
				}
			}
		}
		System.out.println(set.stream().map(Object::toString).collect(Collectors.joining(" ")));
		return set.stream().map(Object::toString).collect(Collectors.joining(" "));
	}

}

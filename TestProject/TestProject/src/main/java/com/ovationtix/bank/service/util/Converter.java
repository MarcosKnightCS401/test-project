package com.ovationtix.bank.service.util;

import java.util.Collection;
import java.util.List;

//if you don't know what deepcopy is, google it and compare it to shallow copy.
public interface Converter<T,K> {

	List<T> convert(Collection<K> dataSet, boolean deepCopy);

	T convert(K dataObject, boolean deepCopy);

}

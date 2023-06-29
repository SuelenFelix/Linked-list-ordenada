package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class OrderedSingleLinkedListImpl<T extends Comparable<T>> extends SingleLinkedListImpl<T> implements
		OrderedLinkedList<T> {

	private Comparator<T> comparator;

	public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public T minimum() {
		T min = null;
		if(!this.isEmpty()){
			SingleLinkedListNode<T> aux = this.head;
			min = aux.getData();
			while(!aux.getNext().isNIL()){
				if(aux.getData().compareTo(aux.getNext().getData()) > 0) {
					min = aux.getNext().getData();
				}
				aux = aux.getNext();
			}
		}
		return min;
	}

	@Override
	public T maximum() {
		T max = null;
		if(!this.isEmpty()){
			SingleLinkedListNode<T> aux = this.head;
			max = aux.getData();
			while(!aux.getNext().isNIL()){
				if(aux.getData().compareTo(aux.getNext().getData()) < 0) {
					max = aux.getNext().getData();
				}
				aux = aux.getNext();
			}
		}
		return max;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
}

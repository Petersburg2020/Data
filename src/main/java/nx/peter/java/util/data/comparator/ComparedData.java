package nx.peter.java.util.data.comparator;

import nx.peter.java.util.data.Data;

public class ComparedData<D extends Data> implements Comparable<ComparedData<D>> {
	protected final D data1, data2;
	
	public ComparedData(D data1, D data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	public D getData1() {
		return data1;
	}

	public D getData2() {
		return data2;
	}
	
	public boolean contains(D data) {
		return data != null && (data1.equals(data) || data2.equals(data));
	}
	
	public boolean isValid() {
		return data1 != null && data2 != null && data1.isValid() && data2.isValid();
	}
	
	public boolean isEqual() {
		return data1 != null && data2 != null && data1.equals(data2);
	}

	public boolean equalData(D data1, D data2) {
		return this.data1.equals(data1) && this.data2.equals(data2);
	}
	
	public boolean equals(ComparedData<?> data) {
		return data != null && data.getData1().equals(data1) && data.getData2().equals(data2);
	}

	@Override
	public int compareTo(ComparedData<D> another) {
		return another.data2.compareTo(data2) * another.data1.compareTo(data1);
	}

	@Override
	public String toString() {
		return "[" +
				"\"data1\": \"" + data1 +
				"\", \"data2\": \"" + data2 +
				"\"] ";
	}
}

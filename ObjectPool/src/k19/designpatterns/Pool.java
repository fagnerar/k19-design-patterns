package k19.designpatterns;

public interface Pool<T> {
	
	T acquire();
	void release(T t);

}

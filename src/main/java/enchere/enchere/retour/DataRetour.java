package enchere.enchere.retour;

public class DataRetour<T> {
    T data;

    public DataRetour(T list) {
        this.data = list;

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

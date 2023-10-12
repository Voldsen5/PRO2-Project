package ex01;

public class FullName implements Comparable<FullName> {
    private String name;
    private String lastName;
    public FullName(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    @Override
    public int compareTo(FullName o) {
        if (this.name.compareTo(o.name) != 0)
            return this.name.compareTo(o.name);
        else
            return this.lastName.compareTo(o.lastName);
    }
}

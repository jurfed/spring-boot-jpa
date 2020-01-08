package ru.jurfed.jpa.jpql;

class NamesAndSalary {
    String name;
    int salary;

    public NamesAndSalary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "NamesAndSalary{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
package ru.jurfed.jpa.jpql;

public interface JpqlExamples {

    void readOnlyPerson(String name);
    void checkedRollBack(String name) throws JpqlExamplesImpl.InvalidNameException;

    void getSalary1();
    void getSalaryFromAnotherClass();

}

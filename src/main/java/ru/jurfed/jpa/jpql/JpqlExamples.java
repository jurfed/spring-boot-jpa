package ru.jurfed.jpa.jpql;

public interface JpqlExamples {

    //transactional
    void readOnlyPerson(String name);

    void checkedRollBack(String name) throws JpqlExamplesImpl.InvalidNameException;

    //jpql
    void getSalary1();

    void getSalaryFromAnotherClass();

    void distinct();

    void groupByMaxSalary();

    void addressJoinPerson();
}

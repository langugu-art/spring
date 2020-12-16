package com.abc.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {
    @Autowired
  private PersonDao persondao;
  public void print(){
      persondao.print();
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "persondao=" + persondao +
                '}';
    }

    public PersonService(PersonDao persondao) {
        this.persondao = persondao;
    }

    public PersonService() {
    }

    public PersonDao getPersondao() {
        return persondao;
    }

    public void setPersondao(PersonDao persondao) {
        this.persondao = persondao;
    }

}

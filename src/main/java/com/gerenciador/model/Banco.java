package com.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static List<Empresa> empresaList = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa.setNome("Alura");
        empresa2.setNome("Google");
        empresa.setCnpj("007.222.111/0001-23");
        empresa2.setCnpj("888.444.222/0007-11");
        empresaList.add(empresa);
        empresaList.add(empresa2);
    }

    public void adiciona(Empresa novaEmpresa) {
        novaEmpresa.setId(chaveSequencial++);
        Banco.empresaList.add(novaEmpresa);
        System.out.println(novaEmpresa.getNome() + " cadastrada com sucesso!");
    }

    public List<Empresa> getEmpresas() {
        return Banco.empresaList;
    }

    public void removeEmpresa(Integer id) {
        empresaList.removeIf(empresa -> empresa.getId() == id);
    }

    public Empresa searchById(Integer id) {
        for ( Empresa empresa : empresaList) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }
}

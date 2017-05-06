package br.usjt.ftce.desmob.clientev1;

import java.io.Serializable;

/**
 * Created by Marcelo Morales RA: 201517112 on 05/05/2017.
 */
    public class Pais implements Serializable, Comparable<Pais> {
        private Integer id;
        private String nomePais;
        private String capital;
        private String area;
        private String populacao;
        private String moeda;

        public Pais(Integer id, String nomePais, String capital, String area, String populacao, String moeda) {
            this.id = id;
            this.nomePais = nomePais;
            this.capital = capital;
            this.area = area;
            this.populacao = populacao;
            this.moeda = moeda;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNomePais() {
            return nomePais;
        }

        public void setNomePais(String nomePais) { this.nomePais = nomePais; }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getPopulacao() {
            return populacao;
        }

        public void setPopulacao(String populacao) {
            this.populacao = populacao;
        }

        public String getMoeda() {
            return moeda;
        }

        public void setMoeda(String moeda) {
            this.moeda = moeda;
        }

        public String getImagem() {
            String foto = this.capital.replace('@', '_');
            return foto.replace('.', '_');
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "id=" + id +
                    ", nomePais='" + nomePais + '\'' +
                    ", capital='" + capital + '\'' +
                    ", area='" + area + '\'' +
                    ", populacao='" + populacao + '\'' +
                    ", moeda='" + moeda + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pais paises = (Pais) o;

            if (!id.equals(paises.id)) return false;
            if (!nomePais.equals(paises.nomePais)) return false;
            if (!capital.equals(paises.capital)) return false;
            if (!area.equals(paises.area)) return false;
            if (!populacao.equals(paises.populacao)) return false;
            return moeda.equals(paises.moeda);

        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + nomePais.hashCode();
            result = 31 * result + capital.hashCode();
            result = 31 * result + area.hashCode();
            result = 31 * result + populacao.hashCode();
            result = 31 * result + moeda.hashCode();
            return result;
        }

        @Override
        public int compareTo(Pais paises) {
            return this.nomePais.compareTo(paises.getNomePais());
        }
    }

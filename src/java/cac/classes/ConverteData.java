/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cac.classes;

/**
 *
 * @author Uhelber
 */
public class ConverteData {

    public String clu_Data(String data) {
        String dt = "", dia = "", mes = "", ano = "", hr = "";

        if (data != null) {
            if (data.length() == 21) {
                if (data.substring(4, 5).equals("-")) {
                    /*
                     * capitura o dia, mes e ano separadamente
                     */
                    for (int i = 0; i < data.length(); i++) {
                        dt = data.substring(i, i + 1);

                        if (i > 7 && i < 10) {
                            dia += dt;
                        } else if (i > 4 && i < 7) {
                            mes += dt;
                        } else if (i < 4) {
                            ano += dt;
                        } else if (i > 10 && i < 19) {
                            hr += dt;
                        }
                    }
                    data = dia + "/" + mes + "/" + ano + " " + hr;
                } else if (data.substring(2, 3).equals(":")) {
                    for (int i = 0; i < data.length(); i++) {
                        dt = data.substring(i, i + 1);

                        if (i < 8) {
                            hr += dt;
                        } else if (i > 8 && i < 11) {
                            dia += dt;
                        } else if (i > 11 && i < 14) {
                            mes += dt;
                        } else if (i > 14 && i < 19) {
                            ano += dt;
                        }
                    }
                    data = ano + "-" + mes + "-" + dia + " " + hr;
                }
            }
            else if(data.length() == 10){
                if (data.substring(4, 5).equals("-")) {
                    /*
                     * capitura o dia, mes e ano separadamente
                     */
                    for (int i = 0; i < data.length(); i++) {
                        dt = data.substring(i, i + 1);

                        if (i > 7 && i < 10) {
                            dia += dt;
                        } else if (i > 4 && i < 7) {
                            mes += dt;
                        } else if (i < 4) {
                            ano += dt;
                        } else if (i > 10 && i < 19) {
                            hr += dt;
                        }
                    }
                    data = dia + "/" + mes + "/" + ano;
                } else if (data.substring(2, 3).equals("/")) {
                    for (int i = 0; i < data.length(); i++) {
                        dt = data.substring(i, i + 1);

                        if (i < 2) {
                            dia += dt;
                        } else if (i > 2 && i < 5) {
                            mes += dt;
                        } else if (i > 5 && i < 10) {
                            ano += dt;
                        }
                    }
                    data = ano + "-" + mes + "-" + dia;
                }
            }

        }

        return data;
    }
}

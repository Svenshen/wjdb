/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

/**
 *
 * @author Administrator
 */
public class Kehu {
    public String kehudaima;
    public String kehumingcheng;

    @Override
    public String toString() {
        return "Kehu{" + "kehudaima=" + kehudaima + ", kehumingcheng=" + kehumingcheng + '}';
    }

    public String getKehudaima() {
        return kehudaima;
    }

    public void setKehudaima(String kehudaima) {
        this.kehudaima = kehudaima;
    }

    public String getKehumingcheng() {
        return kehumingcheng;
    }

    public void setKehumingcheng(String kehumingcheng) {
        this.kehumingcheng = kehumingcheng;
    }

    public Kehu(String kehudaima, String kehumingcheng) {
        this.kehudaima = kehudaima;
        this.kehumingcheng = kehumingcheng;
    }
    public Kehu(){
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet.portal;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class ModelTable {
    String nom_recep,prenom_recep,adress_recep,id_recep,num_tel_recep, date_nes_recep;
     
    
    public ModelTable(String nom_recep,String prenom_recep,String adress_recep,String id_recep,String num_tel_recep,String date_nes_recep){
    this.nom_recep=nom_recep;
    this.prenom_recep=prenom_recep;
    this.adress_recep=adress_recep;
    this.id_recep=id_recep;
    this.num_tel_recep=num_tel_recep;
    this.date_nes_recep=date_nes_recep;
    }
    public String getNom(){
	return nom_recep;
}
public void setNom(String nom_recep){
	this.nom_recep=nom_recep;
}
/**
     * @return *******/

public String getPrenom(){
	return prenom_recep;
}
public void setPrenom(String prenom_recep){
	this.prenom_recep=prenom_recep;
}

public String getId(){
	return id_recep;
}

    
    public void setId(String id_recep){
	this.id_recep=id_recep;
}

    public String getDate_nes(){
	return date_nes_recep;
}
public void setDate_nes(String date_nes_recep){
	this.date_nes_recep=date_nes_recep;
}


public String getAdress(){
	return adress_recep;
}
public void setAdress(String adress_recep){
	this.adress_recep=adress_recep;
}

public String getTel(){
	return num_tel_recep;
}
public void setNum_tel(String num_tel_recep){
	this.num_tel_recep=num_tel_recep;
}
}
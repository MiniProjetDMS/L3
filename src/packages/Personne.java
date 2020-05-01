package packages;

import java.util.Date;

public abstract class Personne {
    
	private String nom;
	private String prenom;
	private int id_personne;
	private String sexe;
	private Date date_nes;
	private String address;
	private int num_tel;
	private String email;
	private String pseudo;
	private String mdp;
	public Personne(String nom,String prenom,int id_personne,String sexe,Date date_nes,String address,int num_tel,String email,String pseudo,String mdp){
	this.nom=nom;
	this.prenom=prenom;
	this.id_personne=id_personne;
	this.sexe=sexe;
	this.date_nes=date_nes;
	this.address=address;
	this.num_tel=num_tel;
	this.email=email;
	this.pseudo=pseudo;
	this.mdp=mdp;
        }

    public String getNom(){
            return nom;
    }
    public void setNom(String nom){
            this.nom=nom;
    }
    /**
         * @return *******/

    public String getPrenom(){
            return prenom;
    }
    public void setPrenom(String prenom){
            this.prenom=prenom;
    }

    public int getId_personne(){
            return id_personne;
    }

    
    public void setId_personne(int id_personne){
	this.id_personne=id_personne;
    }

    public String getSexe(){
            return sexe;
    }
    public void setSexe(String sexe){
            this.sexe=sexe;
    }

    public Date getDate_nes(){
            return date_nes;
    }
    public void setDate_nes(Date date_nes){
            this.date_nes=date_nes;
    }


    public String getAdress(){
            return address;
    }
    public void setAdress(String address){
            this.address=address;
    }


    public int getNum_tel(){
            return num_tel;
    }
    public void setNum_tel(int num_tel){
            this.num_tel=num_tel;
    }


    public String getEmail(){
            return email;
    }
    public void setEmail(String email){
            this.email=email;
    }


    public String getPseudo(){
            return pseudo;
    }
    public void setPseudo(String pseudo){
            this.pseudo=pseudo;
    }


    public String getMdp(){
            return mdp;
    }
    public void setMdp(String mdp){
            this.mdp=mdp;
    }
    public void ajouter(){};

    public void supprimer(){};

    public void modifier(){};
    }